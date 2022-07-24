package io.muzoo.gigadot.ssc.zork.command.impl;

import io.muzoo.gigadot.ssc.zork.Game;
import io.muzoo.gigadot.ssc.zork.command.Command;
import io.muzoo.gigadot.ssc.zork.command.CommandType;


import java.util.Iterator;
import java.util.List;

public class HelpCommand implements Command {


    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public void execute(Game game, String argument) {

        Iterator it = List.of(CommandType.values()).iterator();
        while (it.hasNext()){
            CommandType enumCommandWord = (CommandType) it.next();
            System.out.println(enumCommandWord.getCommandWord());
        }

    }
}
