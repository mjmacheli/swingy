package com.swingy.models;

public class Villian implements iFightable {
    private String name;
	private String kind;
	private int attack;
	private int defense;
	private int power;
    private eWeapons weapon;
    private int hitPoints;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public eWeapons getWeapon() {
		return weapon;
	}

	public void setWeapon(eWeapons weapon) {
		this.weapon = weapon;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}


    public Villian( eVillians villian ) {
        this.name = villian.getName();
		this.attack = villian.getAttack();
		this.defense = villian.getDefense();
		this.power = villian.getAttack() + villian.getDefense() + 13;
		this.weapon = villian.getWeapons();
		this.hitPoints = 130 + villian.getDefense();
    }

    public void updateHitPoints( int damage ) {
        if ( this.defense <= 0 ) {
            this.hitPoints =- damage;
        }
    }

	@Override
	public String toArray() {
		// TODO Auto-generated method stub
		return( name + "," + attack + "," + defense + "," + hitPoints + "," + power + "," + weapon) ;
	}
}