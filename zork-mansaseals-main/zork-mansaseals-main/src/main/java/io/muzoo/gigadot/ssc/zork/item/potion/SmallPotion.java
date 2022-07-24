package io.muzoo.gigadot.ssc.zork.item.potion;

import io.muzoo.gigadot.ssc.zork.Game;
import io.muzoo.gigadot.ssc.zork.Player;
import io.muzoo.gigadot.ssc.zork.command.impl.UseCommand;
import io.muzoo.gigadot.ssc.zork.item.Item;

import java.io.Serializable;
import java.util.*;

public class SmallPotion implements Potion, Serializable {

    private int increaseHP=5;
    private String name = "Small Potion";
    private String desc = "I hate this pot";


    @Override
    public void use(Game game) {

        Player player = game.getPlayer();
        List<Item> listOfItems = game.getPlayer().getInventory();
        List<Item> toRemove = new ArrayList<>();
        System.out.println(desc);
        for (Item items : listOfItems){


            if (items.getName().equals(name)) {

                player.increaseHealth(this.increaseHP);
                System.out.println("HEALING");
                toRemove.add(items);
                System.out.println("You just applied " + getName() + " to yourself.");
                System.out.println("HP: " + player.getHp() + "/"   + player.getMax_hp());
                System.out.println("");

            }

        }

        listOfItems.removeAll(toRemove);

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return desc;
    }
}
