import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;

public class Application {
    public static Hero player;

    public static void main(String[] args) {
        File users = new File("users.txt");

        if (!users.exists()) {
            try {
                users.createNewFile();
            } catch (IOException e ) {
                System.out.error(" Failed to Open Users");
            }
        }

        if ( args.length > 1) {
            if (args[0].equals("CMD")) {
                //TODO: Command line based
            } else if ( args[0].equals("GUI")) {
                //TODO GUI based
            } else {
                System.out.error("Wrong Choise");
            }
        }
    }

    public static void saveGameState( String data ) {
        File users = new File( "GameState.txt");
        try( PrintWriter state = new PrintWriter( new FileOutputStream( users, true ))) {
            state.append( data + "\n");
        } catch (FileNotFoundException e ) {
            e.printStackTrace();
        }
    }
}