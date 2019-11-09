package com.swingy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import com.swingy.controllers.ConsoleController;
import com.swingy.models.Hero;

public class Application {
    public static Hero player;

    public static void main(String[] args) {
        File users = new File("users.txt");

        if (!users.exists()) {
            try {
                users.createNewFile();
            } catch (IOException e ) {
                System.out.println(" Failed to Open Users");
            }
        }

        if ( args.length > 0) {
            if (args[0].equals("CMD")) {
                //TODO: Command line based
                ConsoleController.game();
            } else if ( args[0].equals("GUI")) {
                //TODO GUI based
            } else {
                System.out.println("Wrong Choise");
                System.exit(-1);
            }
        } else {
            ConsoleController.game();
            System.out.println( "Atleast 1 Arg required" );
        }
    }

    public static void saveGameState( String data ) {
        File users = new File( "GameState.txt");
        try( PrintWriter pw = new PrintWriter( new FileOutputStream( users, true ))) {
            pw.append( data + "\n");
        } catch (FileNotFoundException e ) {
            e.printStackTrace();
        }
    }
}