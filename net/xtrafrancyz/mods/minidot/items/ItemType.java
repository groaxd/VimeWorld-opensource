package net.xtrafrancyz.mods.minidot.items;

public enum ItemType
{
    HEAD("\u0413\u043e\u043b\u043e\u0432\u0430", "head"),
    MASK("\u041c\u0430\u0441\u043a\u0430 (\u0413\u043e\u043b\u043e\u0432\u0430)", "head"),
    BODY("\u0422\u0435\u043b\u043e", "body"),
    PET("\u041f\u0438\u0442\u043e\u043c\u0435\u0446", "pet");

    private final String name;
    public final String slot;

    private ItemType(String name, String slot)
    {
        this.name = name;
        this.slot = slot;
    }

    public String getName()
    {
        return this.name;
    }
}
