package io.muzoo.gigadot.ssc.zork.command.impl;

import io.muzoo.gigadot.ssc.zork.Game;
import io.muzoo.gigadot.ssc.zork.Player;
import io.muzoo.gigadot.ssc.zork.command.Command;
import io.muzoo.gigadot.ssc.zork.map.Room;

import java.util.Locale;

public class GoCommand implements Command {
    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public void execute(Game game, String argument) {

        Player player = game.getPlayer();
        Room room = game.getCurrentRoom();
        Room currentRoom = game.getCurrentRoom();
        String direction = argument.trim().toLowerCase(Locale.ROOT);


        if (room.getAllExits().contains(direction)) {
            game.moveRoom(room.getThatRoom(direction));
            currentRoom = room.getThatRoom(direction);
        }
        player.increaseHealth(100);
        System.out.println("");
        System.out.println("You have successfully moved to the room at " + direction + ".");
        System.out.println("Now, you are currently at " + currentRoom.getDescription() + ".");
        System.out.println("Your HP will recover by 100 HP.");
        if (currentRoom.containsMonster()){
            System.out.println("There is a Monster in this room!");

            InfoCommand bossInfo = new InfoCommand();
            bossInfo.execute(game, argument);

        }


        System.out.println("");

        if (!room.getAllExits().contains(direction)) {
            System.out.println("");
            System.out.println("There's no exit there!");
            System.out.println("Type [ info ] to get available exit(s).");
            System.out.println("");
        }

        }
    }



