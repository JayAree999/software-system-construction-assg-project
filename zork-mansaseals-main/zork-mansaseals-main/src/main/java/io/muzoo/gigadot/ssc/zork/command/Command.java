package io.muzoo.gigadot.ssc.zork.command;

import io.muzoo.gigadot.ssc.zork.Game;

import java.util.List;

public interface Command  {

    int numArgs();

    void execute(Game game, String argument);


}
