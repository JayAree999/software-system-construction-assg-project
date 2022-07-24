package io.muzoo.gigadot.ssc.zork.command.impl;

import io.muzoo.gigadot.ssc.zork.Game;

import io.muzoo.gigadot.ssc.zork.command.Command;




public class LoadCommand implements Command {




    @Override
    public int numArgs() {
        return 1;
    }


    @Override
    public void execute(Game game, String argument) {
        game.load(argument);
    }
}