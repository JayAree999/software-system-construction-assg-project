package io.muzoo.gigadot.ssc.zork;

import io.muzoo.gigadot.ssc.zork.item.Item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Player implements Serializable {


    private int max_hp;
    private int hp;
    private int attackDmg;
    private boolean alive;
    private List<Item> inventory;

    public Player() {
        max_hp = 1000;
        hp =777;
        attackDmg = 75;
        alive = true;
        inventory = new ArrayList<>();
    }

    public void increaseHealth(int hpToGain) {
        if (hp + hpToGain >= max_hp) {
            hp = max_hp;
        }
        else {
            hp += hpToGain;
        }
    }

    public void decreaseHealth(int attackDmg) {
        hp -= attackDmg;
        if (hp <= 0) {
            hp = 0;
            alive = false;
        }
    }

    public int getMax_hp() {
        return max_hp;
    }

    public void setMax_hp(int max_hp) {
        this.max_hp = max_hp;
    }

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getAttackDmg() {
        return attackDmg;
    }

    public void setAttackPower(int attackDmg) {
        this.attackDmg = attackDmg;
    }

    public List<Item> getInventory() {
        return inventory;
    }

//    public Item getItemInBag(String itemName){
//        for (Item item : inventory) {
//            if (item.getName().toLowerCase(Locale.ROOT).equals(itemName)) {
//                return item;
//            }
//        }
//        return null;
//    }

    public Boolean hasItemInBag(String whichItem) {
        for (Item item : inventory) {
            if (item.getName().toLowerCase(Locale.ROOT).equals(whichItem.toLowerCase(Locale.ROOT))) {
                return true;
            }
        }
        return false;
    }

    public void pickUpItem(Item item) {
        if (!(item==null)){
            inventory.add(item);
            return;
        }

    }

    public void printStats() {

        System.out.println((""));
        System.out.println(" Player's Stats ");
        System.out.println(("-> HP: " + hp + "/" + max_hp));
        System.out.println(("-> Attack : " + attackDmg));
        System.out.println("====================================");
        System.out.println(("              INVENTORY           "));
        System.out.println("");
        for (Item item : inventory) {
            System.out.println("> " + item.getName());
            System.out.println(item.getDescription());
        }
        System.out.println("====================================");

        }
    }

