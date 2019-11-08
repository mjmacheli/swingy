package com.swingy.models;

public enum eArmor {
    ARMOR1("Armor1", 39),
    ARMOR2("Armor2", 59),
    SHIELD("Shield", 34);

    private String type;
    private int defensePlus;

    eArmor(String type, int defensePlus) {
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