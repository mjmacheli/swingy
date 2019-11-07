package models;

public enum eArmor {
    ARMOR1("Armor1", 39),
    ARMOR2("Armor2", 59),
    SHIELD("Shield", 34);

    private String type;
    private int defensePlus;

    public Armors( String type, int defensePlus ) {
        this.type = type;
        this.defensePlus = defensePlus;
    }
    
    void setType( String type ) {
        this.type = type;
    }

    String getType() {
        return ( this.type );
    }

    void setDefensePlus( int defense ) {
        defensePlus = defense;
    }

    int getDefesePlus() {
        return ( this.defensePlus );
    }

}

public enum eHeroes {
    //Hero - Armor - Weapons
    JACKIE("Jackie", eArmor.ARMOR1, eWeapons.SWORD ),
    CHAN("China", eArmor.ARMOR2, eWeapons.GUN),
    VANDAM("VANDAM", eArmor.SHIELD, eWeapons.KNIFE);

    private String name;
    private eArmors	armor;
	private int		attack;
	private int		defense;
    private int		hitPoints;
    
    //Constructor
    Heros (String name,  eWeapons weapon, eArmors armor, eHelms helm) {
		this.name		= name;
		this.weapon		= weapon;
		this.armor		= armor;
		this.attack		= weapon.getDamage() + 100;
		this.defense	= armor.getStrength() + 100;
		this.hitPoints	= 200 + helm.getLife();
	}

    @override
    public static string toString() {
        return ( this.name );
    }
}