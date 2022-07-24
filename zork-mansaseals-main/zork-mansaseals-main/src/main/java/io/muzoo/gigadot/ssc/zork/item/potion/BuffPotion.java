package io.muzoo.gigadot.ssc.zork.item.potion;

import io.muzoo.gigadot.ssc.zork.Game;
import io.muzoo.gigadot.ssc.zork.Player;
import io.muzoo.gigadot.ssc.zork.command.impl.DropCommand;
import io.muzoo.gigadot.ssc.zork.item.Item;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class BuffPotion implements Potion, Serializable {


    private int increaseAtk=100;
    private String name = "Buff Potion";
    private String desc = "Increase Attack Damage";

    @Override
    public void use(Game game) {

        Player player = game.getPlayer();
        List<Item> listOfItems = game.getPlayer().getInventory();
        List<Item> toRemove = new ArrayList<>();

        for (Item items : listOfItems){


                if (items.getName().equals(name)) {

                    player.setAttackPower(player.getAttackDmg()+this.increaseAtk);
                    System.out.println("BUFFING THE ATTACK");
                    toRemove.add(items);
                    System.out.println("You just applied " + getName() + " to yourself.");

                    System.out.println("Attack: " + player.getAttackDmg());
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
