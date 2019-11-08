package com.swingy.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

import com.swingy.models.Hero;
import com.swingy.models.eHeroes;

public class HeroController {
    
    public static Hero hero( String name, eHeroes Character ) {
        //TODO : instantiate with builder

        return null;
    }

    public static List<Hero> savedPlayers() {
        //Read From file and instantiate player

        return null;
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

    public static void saveState( Hero hr ) {
        File users = new File( "GameState.txt");
        List<Hero> players = savedPlayers();

        try ( PrintWriter pw = new PrintWriter( new FileOutputStream( users ))) {

            for( Hero pl : players ) {
                if ( pl.getName().equals( hr.getName() )) {
                    pw.write( hr.toArray() + "\n");
                } else {
                    pw.write( pl.toArray() + "\n");
                }
            }
        } catch ( FileNotFoundException e ) {
            e.printStackTrace();
            System.exit( -1 );
        }
    }

    public static boolean checkGrid( Hero hr ) {
        if ((hr.getLocation().getX() >= 1 && hr.getLocation().getX() <= ((hr.getLevel() - 1) * 5 + 10 - (hr.getLevel() % 2))) )
            if ( hr.getLocation().getY() >= 1 && hr.getLocation().getY() <= (( hr.getLevel() - 1) * 5 + 10 - ( hr.getLevel() % 2)))
			    return true;
		return false;
    }
}