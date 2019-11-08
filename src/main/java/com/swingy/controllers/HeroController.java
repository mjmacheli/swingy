package controllers;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import models.Hero;

public class HeroController {
    
    public static Hero hero( String name, Heros Character ) {
        //TODO : instantiate with builder
    }

    public static List<Hero> savedPlayers() {
        //Read From file and instantiate player
    }

    public static String playerStats( Hero pl ) {
        
        String stats = "";

        stats = "- Name : " + pl.getName() + " [Playing as - "+pl.getCharName()+"]\n";
		stats += "- Class : "+ pl.getKind() + "\n";
		stats += "- Weapon : "+ pl.getWeapon().getType()+"\n";
		stats += "- Attack : "+pl.getAttack()+"\n";
		stats += "- Defense : "+pl.getDefense()+"\n";
		stats += "- Level : "+pl.getLevel()+"\n";
		stats += "- Experience: "+(pl.getExperience())+" XP\n";
		stats += "- Hit Points : "+(pl.getHitPoints())+"\n";
		
		return stats;
    }

    
    public static boolean getPlayer( Hero pl ) {
        for (Hero hero : savedPlayers()) {
			if (pl.getName().equals(hero.getName())) {
				return ( true );
			}
		}
		return ( false );
    }

    public static void updateState( Hero pl ) {
        List<Hero> plyrs = savedPlayers();
        File users = new File("GameState.txt");

        try( PrintWriter pw = new PrintWriter( new FileOutputStream( users ))) {
            for( Hero p : plyrs ) {
                if ( p.getName().equals( pl.getName()) ) {
                    pw.write( pl.toArray() + "\n" );
                } else {
                    pw.write( p.toArray() + "\n" );
                }

            }
        } catch ( FileNotFoundException e ) {
            e.printStackTrace();
            System.exit(-2);
        }
    }
}