package io.muzoo.gigadot.ssc.zork.command.impl;

import io.muzoo.gigadot.ssc.zork.Game;
import io.muzoo.gigadot.ssc.zork.Player;
import io.muzoo.gigadot.ssc.zork.command.Command;
import io.muzoo.gigadot.ssc.zork.item.Item;
import io.muzoo.gigadot.ssc.zork.item.potion.Potion;

import java.util.List;
import java.util.Locale;

public class DropCommand implements Command {


    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public void execute(Game game, String argument) {

        Player player = game.getPlayer();
        List<Item> inventory = player.getInventory();
        String itemToRemove = argument.trim().toLowerCase(Locale.ROOT);

            for (Item item : inventory) {
                if (item.getName().toLowerCase(Locale.ROOT).equals(itemToRemove)) {
                    inventory.remove(item);
                    System.out.println((""));
                    System.out.println("You just dropped " + argument + " in " + game.getCurrentRoom().getDescription());
                    game.getCurrentRoom().setItems(item);
                    System.out.println("");
                    return;
                }
            }
        System.out.println(argument + "is not in your inventory!");
        }
    }


