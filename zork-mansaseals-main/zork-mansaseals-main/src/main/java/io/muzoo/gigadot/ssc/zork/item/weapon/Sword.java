package io.muzoo.gigadot.ssc.zork.item.weapon;

import io.muzoo.gigadot.ssc.zork.Game;
import io.muzoo.gigadot.ssc.zork.Player;

import io.muzoo.gigadot.ssc.zork.monster.Monster;

import java.io.Serializable;
import java.util.Random;

public class Sword implements Weapon, Serializable {
    Random rand = new Random();
    private int atk=450;
    private String name = "Sword";
    private String desc = "Sword that deal random damage to 449";



    public int playerSwordDmgCalculation(Game game){
        Player player = game.getPlayer();
        int baseDmg = player.getAttackDmg()+this.getSwordAtk();
        Random rand = new Random();
        double dmgModifier = rand.nextDouble(0.2)+0.8;

        int finalDmg = (int) (baseDmg*dmgModifier);
        System.out.println("You have dealt "+ finalDmg + " damage!!!");
        return finalDmg;

    }

    public boolean hasShield(Game game){
        if(game.getPlayer().hasItemInBag("Shield")){
            return true;
        };
        return false;
    }
    public int monsterDmgCalculation(Game game){

        double monsterDmgMod;
        int monsterDmg = game.getCurrentRoom().getMonster().getAttackDmg();
        Random rand = new Random();
        if(hasShield(game)){
            monsterDmgMod = rand.nextDouble(1);

        }
        else {
            monsterDmgMod= rand.nextDouble(5);
        }

        int finalDmg = (int) (monsterDmg*monsterDmgMod);
        System.out.println("You have received "+ finalDmg + " damage!!!");
        return finalDmg;

    }




    @Override
    public void attackWith(Game game) {


        Player player = game.getPlayer();
        Monster monster = game.getCurrentRoom().getMonster();

            System.out.println("Attack - " + monster.getName());
            monster.decreaseHealth(playerSwordDmgCalculation(game));
            System.out.println("HP:" + monster.getHp() + "/" + monster.getMaxHp());
            System.out.println("");


            if ((monster.getAttackProbability() + rand.nextDouble(0.2)) > 0.9) {
                System.out.println("Player is being attacked!! \n" + "HP:" + player.getHp() + "/" + player.getMax_hp());
                player.decreaseHealth(monsterDmgCalculation(game));
                System.out.println("HP:" + player.getHp() + "/" + player.getMax_hp());
            } else {
                System.out.println(monster.getName() + " miss the attack!!");
                System.out.println("HP:" + player.getHp() + "/" + player.getMax_hp());
            }




        }








    public int getSwordAtk() {
        return atk;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return desc;
    }

}