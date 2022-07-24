package io.muzoo.gigadot.ssc.zork.monster;

import io.muzoo.gigadot.ssc.zork.item.Item;

import java.io.Serializable;

public class Monster implements Serializable {

    private String name;
    private String description;
    private int maxHp;
    private int hp;
    private int attackDmg;
    private double attackProbability;
    private boolean alive;
    private Item drop;

    public Monster(String name, String description, int hp, int attackDmg, double attackProbability, Item drop) {
        this.name = name;
        this.description = description;
        this.maxHp = hp;
        this.hp = hp;
        this.attackDmg = attackDmg;
        this.attackProbability = attackProbability;
        this.drop = drop;
        alive = true;
    }

    public void decreaseHealth(int attackDmg) {
        hp -= attackDmg;
        if (hp <= 0) {
            hp = 0;
            alive = false;
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public Item getDrop() {
        return drop;
    }

    public int getHp() {
        return hp;
    }

    public int getAttackDmg() {
        return attackDmg;
    }

    public double getAttackProbability() {
        return attackProbability;
    }

    public boolean isAlive() {
        if (getHp()<=0){
            return false;
        }
        return true;
    }

    public void printStats() {
        System.out.println((""));
        System.out.println("[ Monster's Stats ]");
        System.out.println("   Name: " + name);
        System.out.println("   HP: " + hp + "/" + maxHp);
        System.out.println(("   Description: " + description));
        System.out.println("");
    }
}