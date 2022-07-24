package io.muzoo.gigadot.ssc.zork.command.impl;

import io.muzoo.gigadot.ssc.zork.Game;
import io.muzoo.gigadot.ssc.zork.Player;
import io.muzoo.gigadot.ssc.zork.command.Command;
import io.muzoo.gigadot.ssc.zork.item.Item;
import io.muzoo.gigadot.ssc.zork.map.Room;


import java.util.Locale;

public class TakeCommand implements Command {
    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public void execute(Game game, String argument) {


        Player player = game.getPlayer();
        Room room = game.getCurrentRoom();

        String itemToTake = argument.trim().toLowerCase(Locale.ROOT);

        if (argument == null){
            System.out.println("");
            System.out.println(("You cannot just take nothing! Please specify the Item you desire to take."));
            System.out.println("");
        }
        else {
            for (Item item : room.getAllItems()) {
                if (item.getName().toLowerCase(Locale.ROOT).equals(itemToTake.toLowerCase(Locale.ROOT))) {

                    player.pickUpItem(item);
                    room.removeItem(item);
                    System.out.println("");
                    System.out.println(("You just picked up " + item.getName() + "!"));
                    System.out.println("");;
                    return;
                }
            }
            System.out.println("");
            System.out.println("[ " + argument + " ] cannot be found in this room.");
            System.out.println("");
        }
    }


}

