package io.muzoo.gigadot.ssc.zork.command.impl;

import io.muzoo.gigadot.ssc.zork.Game;
import io.muzoo.gigadot.ssc.zork.Player;
import io.muzoo.gigadot.ssc.zork.command.Command;
import io.muzoo.gigadot.ssc.zork.item.weapon.Weapon;
import io.muzoo.gigadot.ssc.zork.item.weapon.WeaponFactory;
import io.muzoo.gigadot.ssc.zork.item.weapon.WeaponType;
import io.muzoo.gigadot.ssc.zork.map.Room;
import io.muzoo.gigadot.ssc.zork.map.WorldMap;
import io.muzoo.gigadot.ssc.zork.monster.Monster;

import java.util.List;
import java.util.Locale;
import java.util.Random;

public class AttackWithCommand implements Command {

    private int countWins;
    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public void execute(Game game, String argument) {
        Player player = game.getPlayer();
        Room room = game.getCurrentRoom();
        Monster monster = game.getCurrentRoom().getMonster();



        if (argument ==null){
            System.out.println("attack with WHAT?");
        }
        else if (!room.containsMonster()) {
                    System.out.println("There is no Monster around here!");
                    System.out.println("");
                }

        else if (player.hasItemInBag(argument)) {

                for (WeaponType weaponType : WeaponType.values()) {


                    if (argument.toLowerCase(Locale.ROOT).equals(weaponType.getWeaponName().toLowerCase(Locale.ROOT))) {

                        Weapon weapon = WeaponFactory.createWeapon(weaponType);

                        weapon.attackWith(game);
                        if (!monster.isAlive()){
                            System.out.println("You have defeated the monster with " + argument + " !!!!" + "\n You will be granted more ATK!");
                            if (monster.getDrop()==null){
                                System.out.println("This monster has nothing");
                            }
                            else{
                                System.out.println(monster.getDrop().getName() + "DROP!!");
                            }
                            player.pickUpItem(monster.getDrop());
                            game.getCurrentRoom().removeMonster();
                            player.setAttackPower(player.getAttackDmg()+100);

                        }
                        if(!player.isAlive()){
                            System.out.println("YOU DIED");
                            game.exit();
                        }


                    }
                }


        }
        else {
            System.out.println("there is no item that you mentioned in inventory");
        }
//
        }
    }

