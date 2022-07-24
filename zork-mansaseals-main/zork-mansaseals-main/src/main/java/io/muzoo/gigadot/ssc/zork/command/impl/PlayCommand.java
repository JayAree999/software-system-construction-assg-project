package io.muzoo.gigadot.ssc.zork.command.impl;

import io.muzoo.gigadot.ssc.zork.Game;
import io.muzoo.gigadot.ssc.zork.command.Command;
import io.muzoo.gigadot.ssc.zork.map.MapFactory;
import io.muzoo.gigadot.ssc.zork.map.MapType;

import java.util.Locale;

public class PlayCommand implements Command {
    @Override
    public int numArgs() {
        return 1;
    }




    @Override
    public void execute(Game game, String argument) {

        String capsArgument = argument.toUpperCase(Locale.ROOT);

            for (MapType map : MapFactory.getAvailableMap().keySet()) {

                if (capsArgument.equals(map.toString())) {

                    game.beginNewMap(map);


                    System.out.println("");


                    MapCommand mapPrint = new MapCommand();
                    mapPrint.execute(game, argument);
                    System.out.println(("Welcome to the " + game.getCurrentLevel().getName() + "!"));
                    System.out.println("To finish the game u must " + game.getCurrentMap().getTask());
                    System.out.println("");
                    System.out.println("[ Type 'help' for all commands available ]");

                    System.out.println("Type 'map' if you're lost!");
                    System.out.println("You're currently at spawn! use 'go' for heading in certain directions! e.g (go north)");
                    System.out.println("");

                    game.setInGame(true);
                    game.setOutGame(false);
                    return;
                }
            }
            System.out.println("");
            System.out.println(("Incorrect map name. Check your spelling!"));
            System.out.println("");

    }
}