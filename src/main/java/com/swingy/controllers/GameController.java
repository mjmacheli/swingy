package com.swingy.controllers;

import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.swingy.Application;
import com.swingy.models.Hero;
import com.swingy.models.Villian;
import com.swingy.models.eVillians;

public class GameController {
    

    public static void fight( List<com.swingy.utils.Point> villians2 ) {
        boolean res;
        int choice;

        try (Scanner in = new Scanner(System.in) ) {

            List<eVillians> villians = Arrays.asList( eVillians.values() );

            System.out.flush();
    
            System.out.println( " Menu: 1) Fight \n 2) Not Fight");
            choice = Integer.parseInt( in.nextLine() );
    
            switch( choice ) {
                case 1 :
                    res = startFight( Application.player, new Villian( villians.get( new Random().nextInt(2)) ) );
                    //Check if player and villian cillided
                    for ( Point loc: villians2 ) {
                        if ( loc.getX() == Application.player.getLocation().getX() && loc.getY() == Application.player.getLocation().getY()) {
                            villians2.remove( loc );
                            break;
                        }
                    }
                    if ( !res ) {
                        System.out.println( "You Lost! ");
                        System.exit( 0 );
                    } else {
                        System.out.println( "You Won! ");
                    }
                    break;
    
                case 2 :
                default :
                    if ( Application.player.canRun() == 0 ) {
                        System.out.println("Beaten ");
                        res = startFight( Application.player, new Villian( villians.get( new Random().nextInt(2))));
    
                        if ( !res ) {
                            System.out.println( "You Lost! ");
                            System.exit( 0 );
                        } else {
                            System.out.println( "You Won! ");
                        }
                        break;
    
                    } else {
                        System.out.println("Continue ..");
                    }
                    break ;
            }

        } catch ( Exception e ) {
            e.printStackTrace();
        }

    }


    //needs refactoring
    public static boolean startFight( Hero player, Villian villian ) {
        while (true) {
			int chanceOfAttack;

			if ( !(player.canRun() < 1)) {
				chanceOfAttack = new Random().nextInt(villian.getPower() + 100);
			} else {
				chanceOfAttack = new Random().nextInt(villian.getPower());
			}

			if (chanceOfAttack <= player.getPower()) {
				villian.setDefense(villian.getDefense() - player.getWeapon().getDamage());
				villian.updateHitPoints(player.getWeapon().getDamage());
			} else {
				player.setDefense(player.getDefense() - villian.getWeapon().getDamage());
				player.updateHitPoints(villian.getWeapon().getDamage());
			}

			if (player.getHitPoints() <= 0) {
				return false;
			} else if (villian.getHitPoints() <= 0) {
				player.setExperience(player.getExperience() + 375);
				
				// if (player.canRun() > 0) {
				// 	player.setHitPoints(player.getHitPoints()
				// 			+ Helms.values()[new Random().nextInt(Helms.values().length)].getLife());
				// }
				
				return true;
			}
		}
    }
}