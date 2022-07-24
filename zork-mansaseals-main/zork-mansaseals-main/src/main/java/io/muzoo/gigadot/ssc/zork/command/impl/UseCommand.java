package io.muzoo.gigadot.ssc.zork.command.impl;

import io.muzoo.gigadot.ssc.zork.Game;
import io.muzoo.gigadot.ssc.zork.Player;
import io.muzoo.gigadot.ssc.zork.command.Command;

import io.muzoo.gigadot.ssc.zork.item.potion.Potion;
import io.muzoo.gigadot.ssc.zork.item.potion.PotionFactory;
import io.muzoo.gigadot.ssc.zork.item.potion.PotionType;


public class UseCommand implements Command {


    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public void execute(Game game, String argument) {

        Player player = game.getPlayer();
        if (player.hasItemInBag(argument)) {
            for (PotionType potType : PotionType.values()) {
                if (potType.getPotionName().equals(argument)) {
                    System.out.println("ur pot is correct");
                    Potion potion = PotionFactory.createPotion(potType);
                    System.out.println("You are using : "+ potion.getName());
                    potion.use(game);
                }

            }


        }
        else if (argument == null){
            System.out.println("use something");

        }
        else {
            System.out.println("no potion in ur inv");
        }

    }
}
