package io.muzoo.gigadot.ssc.zork.command.impl;

import io.muzoo.gigadot.ssc.zork.Game;
import io.muzoo.gigadot.ssc.zork.Player;
import io.muzoo.gigadot.ssc.zork.command.Command;
import io.muzoo.gigadot.ssc.zork.map.Room;
import io.muzoo.gigadot.ssc.zork.monster.Monster;


public class InfoCommand implements Command {
    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public void execute(Game game,String argument){

        Player player = game.getPlayer();

        Room room = game.getCurrentRoom();
        Monster monster = game.getCurrentRoom().getMonster();
        System.out.println("");
        player.printStats();
        room.printStats();


        if (room.containsMonster()) {
            monster.printStats();
        }
        else {
            System.out.println("[ No monster can be seen around the room ]");
        }
        System.out.println("");
    }
}

