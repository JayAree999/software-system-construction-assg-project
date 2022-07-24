package io.muzoo.gigadot.ssc.zork.command.impl;

import io.muzoo.gigadot.ssc.zork.Game;
import io.muzoo.gigadot.ssc.zork.Player;
import io.muzoo.gigadot.ssc.zork.command.Command;
import io.muzoo.gigadot.ssc.zork.map.Room;

import java.io.*;

public class SaveCommand implements Command, Serializable{
    @Override
    public int numArgs() {
        return 1;
    }


    @Override
    public void execute(Game game, String argument) {
        game.save(argument);
    }
}