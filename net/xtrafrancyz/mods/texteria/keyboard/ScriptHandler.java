package net.xtrafrancyz.mods.texteria.keyboard;

import javax.script.Bindings;
import javax.script.ScriptException;
import jdk.nashorn.api.scripting.ScriptObjectMirror;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.util.ByteMap;

class ScriptHandler implements KeyboardHandler
{
    private final int key;
    private final Bindings bindings;

    public ScriptHandler(int key, ByteMap params) throws ScriptException
    {
        this.key = key;
        this.bindings = Texteria.instance.scriptManager.newBinginds();
        this.bindings.put((String)"texteriaKeyboardScripting", this);
        this.bindings.put((String)"key", Integer.valueOf(key));
        String s = params.getString("script");
        Texteria.instance.scriptManager.compile(s).eval(this.bindings);
    }

    public boolean onStateChanged(boolean pressed)
    {
        return this.callScriptFunction("_onStateChanged", new Object[] {Boolean.valueOf(pressed)}) == Boolean.TRUE;
    }

    private Object callScriptFunction(String function, Object... args)
    {
        if (this.bindings != null)
        {
            Object object = this.bindings.get(function);

            if (object instanceof ScriptObjectMirror && ((ScriptObjectMirror)object).isFunction())
            {
                try
                {
                    return ((ScriptObjectMirror)object).call((Object)null, args);
                }
                catch (Exception exception)
                {
                    Texteria.log.warn((String)("An error occurred while calling a function \'" + function + "\' for a script on key " + this.key + ". Scripts will be disabled for the key \'" + this.key + "\'"), (Throwable)exception);
                }
            }
        }

        return null;
    }
}
