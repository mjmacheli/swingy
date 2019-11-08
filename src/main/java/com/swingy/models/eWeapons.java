package models;

public enum eWeapons {
    SWORD("Sword", 3),
	KNIFE("Knife", 4),
	GUN("GUN", 5);
    
    private String type;
    private int damage;

    void setType( String type ) {
        this.type = type;
    }

    String getType() {
        return ( this.type );
    }

    void setDamage( int damage ) {
        this.damage = damage;
    }

    String getDamage() {
        return ( this.damage );
    }
    
    eWeapons( String type, int damage ) {
        this.type = type;
        this.damage = damage;
    }
}