package io.muzoo.gigadot.ssc.zork.command.impl;

import io.muzoo.gigadot.ssc.zork.Game;
import io.muzoo.gigadot.ssc.zork.command.Command;
import io.muzoo.gigadot.ssc.zork.map.MapFactory;
import io.muzoo.gigadot.ssc.zork.map.WorldMap;

import java.util.Map;


public class MapCommand implements Command{
    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public void execute(Game game, String argument) {
        WorldMap map = game.getCurrentMap();
        map.openMap();
    }



}