package io.muzoo.gigadot.ssc.zork.item.weapon;

import io.muzoo.gigadot.ssc.zork.Game;
import io.muzoo.gigadot.ssc.zork.Player;
import io.muzoo.gigadot.ssc.zork.item.Item;
import io.muzoo.gigadot.ssc.zork.map.Room;
import io.muzoo.gigadot.ssc.zork.monster.Monster;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Shield implements Weapon, Serializable {

    Random rand = new Random();
    private int durability=2;
    private int atk= 9999;
    private String name = "Shield";
    private String desc = "Wow! This is cheating!";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return desc;
    }


    public int playerShieldDmgCalculation(Game game){

        int baseDmg = atk;
        Random rand = new Random();
        int dmgModifier = rand.nextInt(2);
        if (dmgModifier == 1){
            durability--;
            System.out.println("The Shield is breaking!!");
        }


        int finalDmg = baseDmg*dmgModifier;
        System.out.println("You have dealt "+ finalDmg + " damage!!!");
        return finalDmg;

    }
    @Override
    public void attackWith(Game game) {
        Player player = game.getPlayer();
        Monster monster = game.getCurrentRoom().getMonster();
        List<Item> inventory = player.getInventory();


            System.out.println("Attack - " + monster.getName());
            monster.decreaseHealth(playerShieldDmgCalculation(game));
            if (durability==0){
                System.out.println("The shield break!!");
                for (Item item : inventory) {
                    if (item.getName().toLowerCase(Locale.ROOT).equals("Shield")) {
                        inventory.remove(item);

                        return;
                    }
                };
            }

            System.out.println("HP:" + monster.getHp() + "/" + monster.getMaxHp());
            System.out.println("");


            if ((monster.getAttackProbability() + rand.nextDouble(0.2)) > 0.9) {
                System.out.println("Player is being attacked!! \n" + "HP:" + player.getHp() + "/" + player.getMax_hp());
                player.decreaseHealth(monster.getAttackDmg() + rand.nextInt(200));
                System.out.println("HP:" + player.getHp() + "/" + player.getMax_hp());
            } else {
                System.out.println(monster.getName() + " miss the attack!!");
                System.out.println("HP:" + player.getHp() + "/" + player.getMax_hp());
            }

        }


}
