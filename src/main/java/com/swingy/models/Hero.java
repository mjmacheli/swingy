package  com.swingy.models;

import java.util.Random;

import com.swingy.utils.Point;

public class Hero implements iFightable{
    private String name;
	private int level;
	private int experience;
	private int attack;
	private int defense;
	private int hitPoints;
	private int power;
	private String kind;
	private eWeapons weapon;
	private String charName;
    private Point location;
    


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
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

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
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

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

    public String toArray() {
		return name + "," + charName + "," + kind + "," + level + "," + experience + "," + attack + "," + defense + "," + hitPoints + "," + power + "," + weapon + "," + location.getX() + "," + location.getY();
    }
    
    @Override
	public String toString() {
		return "  " + name + " [" + charName + " - " + kind + "]";
    }
    
    public void updateHitPoints( int damage ) {
        if ( this.defense <= 0 ) {
            this.hitPoints =- damage;
        }
    }
    
    public int canRun() {
        return( new Random().nextInt(1)) ;
    }

    public void levelUp() {
            if ( this.experience < 1000 )
                this.level = 0;
            else if ( this.experience < 2450 )
                this.level = 1;
            else if ( this.experience < 4800 )
                this.level = 2;
            else if ( this.experience < 8050 )
                this.level = 3;
            else if ( this.experience < 12200 )
                this.level = 4;
            else
                this.level = 5;
        }
}