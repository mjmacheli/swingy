import java.util.Scanner;

import controllers.HeroController;

public class ConsoleController {

    public static Scanner in = new Scanner(System.in);

    public static void game() {

        //Game loop
        while( true ) {
            System.out.println("Enter 1 to create new player or 2 to select a player: ");
            int choice = Integer.parseInt( in.nextline() );
            if ( choice == 1 ) {
                Application.player = createPlayer();
                //Play Game Here

            } else if ( choice == 2 ) { //Fetch from File
                if ( Hero.getPlayer ) {
                    Application.player = getHero();
                }
            } else {
                System.out.error( "Hero File empty" );
                System.exit( -1 );
            }
        }
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

        while( !player ) {
            listPlayers( players );
            System.out.println("Select player");
            //test with index out of bounds
            pl = Integer.parseInt( in.nextline() );
            if ( player = players.get( pl )) {
                return ( player );
            } else {
                System.out.error( "Incorrect Selection" );
                System.exit( -1 );
            }
        }
        return ( player );
    }

    public static Hero createPlayer() {
        String name = null;
        Hero player = null;
        List<eHeroes> players = Arrays.asList(eHeros.values());

        /**
         * Choose Player
         */
        while( player == null ) {
            System.out.flush();
            Sysyem.out.println("Choose a player");
            for (Heros pl: players) {
				System.out.printf( players.indexOf(pl) + 1 + " | " + pl.getName());
            }
            
            System.out.println("Choose player ");
            int choice = Integer.parseInt(in.nextLine());

            //validate input - correct index
            if ( player = players.get( choice -1 ) != null) {
                Application.saveGameState( HeroController.hero(name, pl).toArray());
						
				return HeroController.hero(name, pl);
            } else {
                System.out.error("incorrect Choice !");
                System.exit( -1 );
            }


        }

    }


}
