import models.interfaces.Fightable;

public class Villian implements Fightable {
    private String name;
	private String kind;
	private int attack;
	private int defense;
	private int power;
    private Weapons weapon;
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

	public Weapons getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapons weapon) {
		this.weapon = weapon;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}


    public Villian( Villian villian ) {
        this.name = villain.getName();
		this.kind = villain.getKind();
		this.attack = villain.getAttack();
		this.defense = villain.getDefense();
		this.power = villain.getAttack() + villain.getDefense() + 13;
		this.weapon = villain.getWeapon();
		this.hitPoints = 130 + villain.getDefense();
    }

    public void updateHitPoints( int damage ) {
        if ( this.defense <= 0 ) {
            this.hitPoints =- damage;
        }
    }
}