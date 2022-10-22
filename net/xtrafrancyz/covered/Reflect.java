package net.xtrafrancyz.covered;

import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.xtrafrancyz.mods.texteria.Texteria;
import org.apache.logging.log4j.Level;
import sun.reflect.ReflectionFactory;

public class Reflect
{
    private static final Map<String, Reflect.ClassData> cache = new ConcurrentHashMap();

    public static < T extends Enum<? >> T addEnum(Class<T> enumType, String name, Object... args)
    {
        try
        {
            Reflect.ClassData<T> classdata = getClass(enumType);
            Field field = null;

            try
            {
                field = classdata.findFinalField("$VALUES");
            }
            catch (Reflect.UnableToFindFieldException var12)
            {
                try
                {
                    field = classdata.findFinalField("ENUM$VALUES");
                }
                catch (Reflect.UnableToFindFieldException var11)
                {
                    ;
                }
            }

            if (field == null)
            {
                int i = 4120;
                String s = "[L" + enumType.getName().replace('.', '/') + ";";

                for (Field field1 : enumType.getDeclaredFields())
                {
                    if ((field1.getModifiers() & i) == i && field1.getType().getName().replace('.', '/').equals(s))
                    {
                        field = field1;
                        field1.setAccessible(true);
                        Reflect.ClassData.FIELD_MODIFIERS.set(field1, Integer.valueOf(field1.getModifiers() & -17));
                        break;
                    }
                }
            }

            if (field == null)
            {
                throw new Reflect.UnableToFindFieldException(enumType, "$VALUES");
            }
            else
            {
                T[] at = (Enum[])((Enum[])field.get((Object)null));
                List<T> list = new ArrayList(Arrays.asList(at));
                Object[] aobject = new Object[args.length + 2];
                aobject[0] = name;
                aobject[1] = Integer.valueOf(list.size());
                System.arraycopy(args, 0, aobject, 2, args.length);
                ReflectionFactory reflectionfactory = ReflectionFactory.getReflectionFactory();
                T t = (Enum)reflectionfactory.newConstructorAccessor(classdata.findConstructor(aobject)).newInstance(aobject);
                list.add(t);
                field.set((Object)null, list.toArray((Enum[])((Enum[])Array.newInstance(enumType, 0))));
                setFinal(Class.class, enumType, "enumConstants", (Object)null);
                setFinal(Class.class, enumType, "enumConstantDirectory", (Object)null);
                return t;
            }
        }
        catch (Exception exception)
        {
            error(exception, "addEnum error");
            return (T)null;
        }
    }

    public static <E> E construct(Class<E> clazz, Object... args)
    {
        try
        {
            return (E)getClass(clazz).construct(args);
        }
        catch (Exception exception)
        {
            error(exception, "Constructor error");
            return (E)null;
        }
    }

    public static <E> E get(Class clazz, String field)
    {
        try
        {
            return (E)getClass(clazz).get((Object)null, field);
        }
        catch (Exception exception)
        {
            error(exception, "Get static field error");
            return (E)null;
        }
    }

    public static <R> R get(Object instance, String field)
    {
        try
        {
            return (R)getClass(instance.getClass()).get(instance, field);
        }
        catch (Exception exception)
        {
            error(exception, "Get field error");
            return (R)null;
        }
    }

    public static <T, E> E get(Class<T> clazz, T instance, String field)
    {
        try
        {
            return (E)getClass(clazz).get(instance, field);
        }
        catch (Exception exception)
        {
            error(exception, "Get field error");
            return (E)null;
        }
    }

    public static void set(Class clazz, String field, Object value)
    {
        try
        {
            getClass(clazz).set((Object)null, field, value);
        }
        catch (Exception exception)
        {
            error(exception, "Set static field error");
        }
    }

    public static void set(Object instance, String field, Object value)
    {
        try
        {
            getClass(instance.getClass()).set(instance, field, value);
        }
        catch (Exception exception)
        {
            error(exception, "Set field error");
        }
    }

    public static <T> void set(Class<T> clazz, T instance, String field, Object value)
    {
        try
        {
            getClass(clazz).set(instance, field, value);
        }
        catch (Exception exception)
        {
            error(exception, "Set field error");
        }
    }

    public static void setFinal(Class clazz, String field, Object value)
    {
        try
        {
            getClass(clazz).setFinal((Object)null, field, value);
        }
        catch (Exception exception)
        {
            error(exception, "Set static final field error");
        }
    }

    public static void setFinal(Object instance, String field, Object value)
    {
        try
        {
            getClass(instance.getClass()).setFinal(instance, field, value);
        }
        catch (Exception exception)
        {
            error(exception, "Set final field error");
        }
    }

    public static <T> void setFinal(Class<T> clazz, T instance, String field, Object value)
    {
        try
        {
            getClass(clazz).setFinal(instance, field, value);
        }
        catch (Exception exception)
        {
            error(exception, "Set final field error");
        }
    }

    public static <E> E invoke(Class clazz, String method, Object... args)
    {
        try
        {
            return (E)getClass(clazz).invoke((Object)null, method, args);
        }
        catch (Throwable throwable)
        {
            error(throwable, "Invoke static error");
            return (E)null;
        }
    }

    public static <E> E invoke(Object instance, String method, Object... args)
    {
        try
        {
            return (E)getClass(instance.getClass()).invoke(instance, method, args);
        }
        catch (Throwable throwable)
        {
            error(throwable, "Invoke error");
            return (E)null;
        }
    }

    public static <T, E> E invoke(Class<T> clazz, T instance, String method, Object... args)
    {
        try
        {
            return (E)getClass(clazz).invoke(instance, method, args);
        }
        catch (Throwable throwable)
        {
            error(throwable, "Invoke error");
            return (E)null;
        }
    }

    public static <T> boolean isConstructorExist(Class<T> clazz, Class... args)
    {
        return findConstructor(clazz, args) != null;
    }

    public static <T> boolean isMethodExist(Class<T> clazz, String method, Class... args)
    {
        return findMethod(clazz, method, args) != null;
    }

    public static <T> boolean isFieldExist(Class<T> clazz, String field)
    {
        return findField(clazz, field) != null;
    }

    public static <T> Constructor<T> findConstructor(Class<T> clazz, Class... args)
    {
        try
        {
            return getClass(clazz).findConstructor0(args);
        }
        catch (Exception var3)
        {
            return null;
        }
    }

    public static <T> Method findMethod(Class<T> clazz, String method, Class... args)
    {
        try
        {
            return getClass(clazz).findMethod0(method, args);
        }
        catch (Exception var4)
        {
            return null;
        }
    }

    public static <T> Field findField(Class<T> clazz, String field)
    {
        try
        {
            return getClass(clazz).findField(field);
        }
        catch (Exception var3)
        {
            return null;
        }
    }

    public static <T> Field findFinalField(Class<T> clazz, String field)
    {
        try
        {
            return getClass(clazz).findFinalField(field);
        }
        catch (Exception var3)
        {
            return null;
        }
    }

    public static Class<?> findClass(String name)
    {
        try
        {
            return Class.forName(name);
        }
        catch (ClassNotFoundException var2)
        {
            return null;
        }
    }

    public static void setAggressiveMethodsOverloading(Class clazz, boolean flag)
    {
        Reflect.ClassData reflect$classdata = getClass(clazz);

        if (reflect$classdata.aggressiveOverloading != flag)
        {
            reflect$classdata.aggressiveOverloading = flag;
            reflect$classdata.methods.clear();
        }
    }

    public static Lookup lookup()
    {
        return (Lookup)get(Lookup.class, "IMPL_LOOKUP");
    }

    private static <T> Reflect.ClassData<T> getClass(Class<T> clazz)
    {
        Reflect.ClassData<T> classdata = (Reflect.ClassData)cache.get(clazz.getName());

        if (classdata == null)
        {
            cache.put(clazz.getName(), classdata = new Reflect.ClassData(clazz));
        }

        return classdata;
    }

    private static void error(Throwable e, String message)
    {
        Texteria.log.log(Level.ERROR, message, e);
    }

    private static String classesToString(Class[] classes)
    {
        int i = classes.length - 1;

        if (i == -1)
        {
            return "()";
        }
        else
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append('(');
            int j = 0;

            while (true)
            {
                stringbuilder.append(classes[j].getName());

                if (j == i)
                {
                    return stringbuilder.append(')').toString();
                }

                stringbuilder.append(',');
                ++j;
            }
        }
    }

    static class AggressiveMethodMapKey
    {
        Class[] types;
        String name;

        public AggressiveMethodMapKey(String name, Class[] types)
        {
            this.name = name;
            this.types = types;
        }

        public int hashCode()
        {
            int i = this.name.hashCode();
            i = 31 * i + Arrays.hashCode((Object[])this.types);
            return i;
        }

        public boolean equals(Object obj)
        {
            if (!(obj instanceof Reflect.AggressiveMethodMapKey))
            {
                return false;
            }
            else
            {
                Reflect.AggressiveMethodMapKey reflect$aggressivemethodmapkey = (Reflect.AggressiveMethodMapKey)obj;

                if (this.types.length == reflect$aggressivemethodmapkey.types.length && reflect$aggressivemethodmapkey.name.equals(this.name))
                {
                    for (int i = 0; i < this.types.length; ++i)
                    {
                        if (this.types[i] != reflect$aggressivemethodmapkey.types[i])
                        {
                            return false;
                        }
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
    }

    static class ClassData<K>
    {
        private static Field FIELD_MODIFIERS = null;
        private final Class<K> clazz;
        private final Map<String, Field> fields = new HashMap();
        private final Map<Object, Method> methods = new HashMap();
        private final Map<Object, Constructor<K>> constructors = new HashMap();
        boolean aggressiveOverloading = false;

        public ClassData(Class<K> clazz)
        {
            this.clazz = clazz;
        }

        void set(Object instance, String field, Object value) throws Exception
        {
            this.findField(field).set(instance, value);
        }

        void setFinal(Object instance, String field, Object value) throws Exception
        {
            this.findFinalField(field).set(instance, value);
        }

        Object get(Object instance, String field) throws Exception
        {
            return this.findField(field).get(instance);
        }

        Object invoke(Object instance, String method, Object... args) throws Throwable
        {
            return this.findMethod(method, args).invoke(instance, args);
        }

        K construct(Object... args) throws Exception
        {
            return (K)this.findConstructor(args).newInstance(args);
        }

        Constructor<K> findConstructor(Object... args)
        {
            return this.findConstructor0(this.toTypes(args));
        }

        Constructor<K> findConstructor0(Class... types)
        {
            Object object = new Reflect.ConstructorMapKey(types);
            Constructor<K> constructor = (Constructor)this.constructors.get(object);

            if (constructor == null)
            {
                label51:

                for (Constructor constructor1 : this.clazz.getDeclaredConstructors())
                {
                    Class<?>[] oclass = constructor1.getParameterTypes();

                    if (oclass.length == types.length)
                    {
                        int i = 0;

                        while (true)
                        {
                            if (i >= oclass.length)
                            {
                                constructor = constructor1;
                                constructor1.setAccessible(true);
                                this.constructors.put(object, constructor1);
                                break label51;
                            }

                            if (types[i] != null && oclass[i] != types[i] && !oclass[i].isAssignableFrom(types[i]))
                            {
                                break;
                            }

                            ++i;
                        }
                    }
                }

                if (constructor == null)
                {
                    throw new Reflect.UnableToFindConstructorException(this.clazz, types);
                }
            }

            return constructor;
        }

        Method findMethod(String name, Object... args)
        {
            Class[] aclass = null;
            Object object;

            if (this.aggressiveOverloading)
            {
                aclass = this.toTypes(args);
                object = new Reflect.AggressiveMethodMapKey(name, aclass);
            }
            else
            {
                object = new Reflect.MethodMapKey(name, args.length);
            }

            Method method = (Method)this.methods.get(object);

            if (method == null)
            {
                if (aclass == null)
                {
                    aclass = this.toTypes(args);
                }

                method = this.fastFindMethod(name, aclass);

                if (method == null)
                {
                    throw new Reflect.UnableToFindMethodException(this.clazz, name, aclass);
                }

                this.methods.put(object, method);
            }

            return method;
        }

        Method findMethod0(String name, Class... types)
        {
            Object object;

            if (this.aggressiveOverloading)
            {
                object = new Reflect.AggressiveMethodMapKey(name, types);
            }
            else
            {
                object = new Reflect.MethodMapKey(name, types.length);
            }

            Method method = (Method)this.methods.get(object);

            if (method == null)
            {
                method = this.fastFindMethod(name, types);

                if (method == null)
                {
                    throw new Reflect.UnableToFindMethodException(this.clazz, name, types);
                }

                this.methods.put(object, method);
            }

            return method;
        }

        private Method fastFindMethod(String name, Class... types)
        {
            Method method = null;
            name = name.intern();
            Class oclass = this.clazz;

            while (true)
            {
                label35:

                for (Method method1 : oclass.getDeclaredMethods())
                {
                    if (name == method1.getName())
                    {
                        Class<?>[] oclass1 = method1.getParameterTypes();

                        if (oclass1.length == types.length)
                        {
                            int i = 0;

                            while (true)
                            {
                                if (i >= oclass1.length)
                                {
                                    method = method1;
                                    break label35;
                                }

                                if (types[i] != null && oclass1[i] != types[i] && !oclass1[i].isAssignableFrom(types[i]))
                                {
                                    break;
                                }

                                ++i;
                            }
                        }
                    }
                }

                if (method != null)
                {
                    method.setAccessible(true);
                    break;
                }

                oclass = oclass.getSuperclass();

                if (oclass == null)
                {
                    break;
                }
            }

            return method;
        }

        Field findFinalField(String name) throws Exception
        {
            Field field = this.findField(name);
            FIELD_MODIFIERS.set(field, Integer.valueOf(field.getModifiers() & -17));
            return field;
        }

        Field findField(String name)
        {
            Field field = (Field)this.fields.get(name);

            if (field == null)
            {
                for (Class oclass = this.clazz; oclass != null; oclass = oclass.getSuperclass())
                {
                    try
                    {
                        field = oclass.getDeclaredField(name);
                        field.setAccessible(true);
                        this.fields.put(name, field);
                        break;
                    }
                }

                if (field == null)
                {
                    throw new Reflect.UnableToFindFieldException(this.clazz, name);
                }
            }

            return field;
        }

        private Class[] toTypes(Object[] objects)
        {
            if (objects.length == 0)
            {
                return new Class[0];
            }
            else
            {
                Class[] aclass = new Class[objects.length];

                for (int i = 0; i < objects.length; ++i)
                {
                    if (objects[i] == null)
                    {
                        aclass[i] = null;
                    }
                    else
                    {
                        Class oclass = objects[i].getClass();

                        if (oclass == Integer.class)
                        {
                            oclass = Integer.TYPE;
                        }
                        else if (oclass == Double.class)
                        {
                            oclass = Double.TYPE;
                        }
                        else if (oclass == Boolean.class)
                        {
                            oclass = Boolean.TYPE;
                        }
                        else if (oclass == Float.class)
                        {
                            oclass = Float.TYPE;
                        }
                        else if (oclass == Long.class)
                        {
                            oclass = Long.TYPE;
                        }
                        else if (oclass == Character.class)
                        {
                            oclass = Character.TYPE;
                        }
                        else if (oclass == Byte.class)
                        {
                            oclass = Byte.TYPE;
                        }
                        else if (oclass == Short.class)
                        {
                            oclass = Short.TYPE;
                        }

                        aclass[i] = oclass;
                    }
                }

                return aclass;
            }
        }

        static
        {
            try
            {
                FIELD_MODIFIERS = Field.class.getDeclaredField("modifiers");
                FIELD_MODIFIERS.setAccessible(true);
            }
            catch (Exception exception)
            {
                Reflect.error(exception, "Field modifiers field not found");
            }
        }
    }

    static class ConstructorMapKey
    {
        Class[] types;

        public ConstructorMapKey(Class[] types)
        {
            this.types = types;
        }

        public int hashCode()
        {
            return Arrays.hashCode((Object[])this.types);
        }

        public boolean equals(Object obj)
        {
            if (!(obj instanceof Reflect.AggressiveMethodMapKey))
            {
                return false;
            }
            else
            {
                Reflect.AggressiveMethodMapKey reflect$aggressivemethodmapkey = (Reflect.AggressiveMethodMapKey)obj;

                if (this.types.length != reflect$aggressivemethodmapkey.types.length)
                {
                    return false;
                }
                else
                {
                    for (int i = 0; i < this.types.length; ++i)
                    {
                        if (this.types[i] != reflect$aggressivemethodmapkey.types[i])
                        {
                            return false;
                        }
                    }

                    return true;
                }
            }
        }
    }

    static class MethodMapKey
    {
        String name;
        int args;

        public MethodMapKey(String name, int args)
        {
            this.name = name;
            this.args = args;
        }

        public int hashCode()
        {
            return this.name.hashCode() + this.args;
        }

        public boolean equals(Object obj)
        {
            if (!(obj instanceof Reflect.MethodMapKey))
            {
                return false;
            }
            else
            {
                Reflect.MethodMapKey reflect$methodmapkey = (Reflect.MethodMapKey)obj;
                return reflect$methodmapkey.args == this.args && reflect$methodmapkey.name.equals(this.name);
            }
        }
    }

    private static class UnableToFindConstructorException extends Reflect.UnableToFindMethodException
    {
        public UnableToFindConstructorException(Class clazz, Class[] types)
        {
            super(clazz, (String)null, types);
        }

        public String toString()
        {
            return "Unable to find constructor \'" + this.className + ".<init>" + Reflect.classesToString(this.types) + "\'";
        }
    }

    private static class UnableToFindFieldException extends RuntimeException
    {
        private String fieldName;
        private String className;

        public UnableToFindFieldException(Class clazz, String fieldName)
        {
            this.fieldName = fieldName;
            this.className = clazz.getName();
        }

        public String getMessage()
        {
            return this.toString();
        }

        public String toString()
        {
            return "Unable to find field \'" + this.fieldName + "\' in class \'" + this.className + "\'";
        }
    }

    private static class UnableToFindMethodException extends RuntimeException
    {
        protected String methodName;
        protected String className;
        protected Class[] types;

        public UnableToFindMethodException(Class clazz, String methodName, Class[] types)
        {
            this.methodName = methodName;
            this.className = clazz.getName();
            this.types = types;
        }

        public String getMessage()
        {
            return this.toString();
        }

        public String toString()
        {
            return "Unable to find method \'" + this.className + "." + this.methodName + Reflect.classesToString(this.types) + "\'";
        }
    }
}
