package com.swingy.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.swingy.Application;
import com.swingy.models.Hero;
import com.swingy.models.eHeroes;
import com.swingy.utils.Point;

public class ConsoleController {

    public static Scanner in = new Scanner(System.in);

    private static List<Point> villiansLoc;

    public static void game() {

        //Game loop
        while( true ) {
            System.out.println("Enter 1 to create new player or 2 to select a player: ");
            int choice = Integer.parseInt( in.nextLine() );
            if ( choice == 1 ) {
                Application.player = createPlayer();
                //Play Game Here

            } else if ( choice == 2 ) { //Fetch from File
                if ( HeroController.savedPlayers() != null) {
                    Application.player = getHero();
                }
            } else {
                System.out.println( "Hero File empty" );
                System.exit( -1 );
            }
        }
    }



    public static String Map( List<Point> villians ) {

        int level = Application.player.getLevel();

        //Check if player on any edge
        if ( HeroController.checkGrid( Application.player )) {
            
        } else {
            System.out.println("You Win! ");
            Application.player.setExperience(Application.player.getExperience());
            System.exit(0);
        }

        System.out.printf("Level: " + Application.player.getLevel() +" | "+ Application.player.getExperience()  +" | "+  Application.player.getHitPoints());
		String map = "";
        for (int y = ((Application.player.getLevel() - 1) * 5 + 10
                - (Application.player.getLevel() % 2)); y >= 1; y--) {
			for (int x = 1; x <= ((Application.player.getLevel() - 1) * 5 + 10 - (Application.player.getLevel() % 2)); x++ ) {
				int pl = 0;
				if ((x == Application.player.getLocation().getX()) && (y == Application.player.getLocation().getY())) {
					for ( Point loc : villians) {
						if ((loc.getX() == Application.player.getLocation().getX()) 
								&& (loc.getY() == Application.player.getLocation().getY())) {
							pl = 1;
							map += "o";
							GameController.fight( villians );
							break;
						}
					}
					if (pl != 1) {
                        map += "o";
                    }
				} else {
					for ( Point loc : villians ) {
						if ((loc.getX() == x) && (loc.getY() == y)) {
							pl = 1;
							map += "x";
							break;
						}
					}
					if (pl != 1) {
                        map += " ";
                    }
				}
			}
			map += "\n";
		}
		Application.player.levelUp();
		if (level < Application.player.getLevel()) {			
			return Map( villians );
        }
        
		HeroController.saveState(Application.player);
        System.out.print( "You Win" );
        
		return map;
    }

    public static void listPlayers( List<Hero> playerList ) {
        System.out.flush();
        for (Hero player: playerList) {
			System.out.printf( (playerList.indexOf(player) + 1) + " | " + player.getCharName() + " | " +  player.getKind() + " | " +  player.getName());
		}
    }

    public static Hero getHero() {
        Hero player = null;
        int pl;
        List<Hero> players = HeroController.savedPlayers();

        while( player != null) {
            listPlayers( players );
            System.out.println("Select player");
            //test with index out of bounds
            pl = Integer.parseInt( in.nextLine());
            if ( player == players.get( pl )) {
                return ( player );
            } else {
                System.out.println( "Incorrect Selection" );
                System.exit( -1 );
            }
        }
        return ( player );
    }

    public static Hero createPlayer() {
        String name = null;
        Hero player = null;
        List<eHeroes> players = Arrays.asList(eHeroes.values());

        /**
         * Choose Player
         */
        while( player == null ) {
            System.out.flush();
            System.out.println("Choose a player");
            for (eHero pl: players) {
				System.out.printf( players.indexOf(pl) + 1 + " | " + pl.getName());
            }
            
            System.out.println("Choose player ");
            int choice = Integer.parseInt(in.nextLine());


            //validate input - correct index
            if ( player = players.get( choice -1 ) != null) {
                Application.saveGameState( HeroController.hero(name, pl).toArray());
						
				return HeroController.hero(name, pl);
            } else {
                System.out.println("incorrect Choice !");
                System.exit( -1 );
            }


        }

    }

    private static void Move() {

        int choice;
        String array;
        villiansLoc = VillianController.villianPos( Application.player );

        while( true ) {
            System.out.flush();
            array = Map( villiansLoc );

            System.out.println( array );
            if ( HeroController.checkGrid( Application.player )) {
                System.out.prinln( "Keys : 2) SOUTH \n 4) WEST \n 6) EAST 8) NORTH " );
                choice = Integer.parseInt(in.nextLine());

                switch( choice ) {

                    case 2 :
                        Application.player.getLocation().setY(Application.player.getLocation().getY() - 1);
                        System.out.println("x = "+ Application.player.getLocation().getX() + ", Y = " +Application.player.getLocation().getY());
                        break;
                    
                    case 4 :
                        Application.player.getLocation().setX(Application.player.getLocation().getX() - 1);
                        System.out.println("x = "+ Application.player.getLocation().getX() + ", Y = " +Application.player.getLocation().getY());
                        break;
                    
                    case 6 :
                        Application.player.getLocation().setX(Application.player.getLocation().getX() + 1);
                        System.out.println("x = "+ Application.player.getLocation().getX() + ", Y = " +Application.player.getLocation().getY());
                        break;

                    case 8 :
                        Application.player.getLocation().setY(Application.player.getLocation().getY() + 1);
                        System.out.println("x = "+ Application.player.getLocation().getX() + ", Y = " +Application.player.getLocation().getY());
                        break;

                    default :
                        System.out.println("Wrong direction! ");
                        break;
                }
            } else {
                return ;
            }
        }
        
    }


}
