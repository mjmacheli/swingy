package com.swingy.models;

public enum eHeroes {
    //Hero - Armor - Weapons
    JACKIE("Jackie", eArmor.ARMOR1, eWeapons.SWORD, eHelms.HELM1 ),
    CHAN("China", eArmor.ARMOR2, eWeapons.GUN, eHelms.HELM2 ),
    VANDAM("VANDAM", eArmor.SHIELD, eWeapons.KNIFE, eHelms.HELM3 );

    private String name;
    private eWeapons weapon;
    private eArmor	armor;
	private int		attack;
	private int		defense;
    private int		hitPoints;
    
    //Constructor
    eHeroes(String name, eArmor armor, eWeapons weapon, eHelms helm) {
		this.name		= name;
		this.weapon		= weapon;
		this.armor		= armor;
		this.attack		= weapon.getDamage() + 100;
		this.defense	= armor.getDefesePlus() + 100;
		this.hitPoints	= helm.getHitPoints() + 100;
	}

    @Override
    public  String toString() {
        return ( this.name );
    }

    public int getHitPoints() {
        return ( this.hitPoints );
    }

    public void setHitPoints( int hitPoints ) {
        this.hitPoints = hitPoints;
    }

    public int getDefense() {
        return ( this.defense );
    }

    public void setDefense( int defense ) {
        this.defense = defense;
    }

    public int getAttack() {
        return ( this.attack );
    }

    public void setAttack( int attack ) {
        this.attack = attack;
    }

    public eArmor getArmor() {
        return ( this.armor );
    }

    public void setArmor( eArmor armor ) {
        this.armor = armor;
    }

    public String getName() {
        return ( this.name );
    }

    public eWeapons getWeapons() {
        return ( this.weapon );
    }

    public void setWeapons( eWeapons Weapons ) {
        this.weapon = Weapons;
    }

    public void setName( String name ) {
        this.name = name;
    }
}