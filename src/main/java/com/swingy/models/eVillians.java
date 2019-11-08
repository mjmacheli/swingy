package com.swingy.models;

public enum eVillians {
    // Hero - Armor - Weapons
    ENEMY1("One E", eArmor.ARMOR1, eWeapons.SWORD, eHelms.HELM1 ),
    ENEMY2("Two E", eArmor.ARMOR2, eWeapons.GUN, eHelms.HELM1 ),
    ENEMY3("Three E", eArmor.SHIELD, eWeapons.KNIFE, eHelms.HELM1 );

    private String name;
    private eArmor armor;
    private eWeapons weapons;
    private int attack;
    private int defense;
    private int hitPoints;
    private eHelms helms;

    // Constructor
    eVillians(String name, eArmor armor, eWeapons weapons, eHelms helm) {
		this.name = name;
		this.weapons = weapons;
		this.armor = armor;
		this.attack	= weapons.getDamage() + 100;
		this.defense = armor.getDefesePlus() + 100;
		this.hitPoints	= helm.getHitPoints() + 100;
	}

    @Override
    public  String toString() {
        return ( this.name );
    }

    public eWeapons getWeapons() {
        return ( this.weapons );
    }

    public void setHitPoints(eWeapons wp ) {
        this.weapons = wp;
    }

    public eHelms getHelms() {
        return ( this.helms );
    }

    public void setHelms( eHelms h ) {
        this.helms = h;
    }

    public int getHitPoints() {
        return ( this.hitPoints );
    }

    public void setHitPoints( int hitPoints) {
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

    public void setAttack( int attack) {
        this.attack = attack;
    }

    public eArmor getArmor() {
        return ( this.armor );
    }

    public void setArmor( eArmor armor) {
        this.armor = armor;
    }

    public String getName() {
        return ( this.name );
    }

    public void setName( String name ) {
        this.name = name;
    }
}