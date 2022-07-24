package io.muzoo.gigadot.ssc.zork.map;



import io.muzoo.gigadot.ssc.zork.item.potion.Potion;
import io.muzoo.gigadot.ssc.zork.item.potion.PotionFactory;

import io.muzoo.gigadot.ssc.zork.item.potion.PotionType;

import io.muzoo.gigadot.ssc.zork.item.weapon.Weapon;
import io.muzoo.gigadot.ssc.zork.item.weapon.WeaponFactory;
import io.muzoo.gigadot.ssc.zork.item.weapon.WeaponType;
import io.muzoo.gigadot.ssc.zork.monster.Monster;
import io.muzoo.gigadot.ssc.zork.monster.MonsterFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Caven implements WorldMap, Serializable {

    private String name;
    private String description;
    private String task;
    private Room startRoom;
    private List<Room> roomList = new ArrayList<>();

    public Caven() {
        this.name = "Caven";
        this.description=("Welcome to the classroom");
        this.task= ("kill all monsters");



        MonsterFactory monsterFactory = new MonsterFactory();

        Room room1 = new Room("Spawn");
        roomList.add(room1);
        Room room2 = new Room("Garden");
        roomList.add(room2);
        Room room3 = new Room("Fountain");
        roomList.add(room3);
        Room room4 = new Room("Hallway1");
        roomList.add(room4);
        Room room5 = new Room("Hallway2");
        roomList.add(room5);
        Room room6 = new Room("Entrance to Boss room");
        roomList.add(room6);
        Room room7 = new Room("Boss Room");
        roomList.add(room7);

        room1.setExits(room2,null,room3,room4);
        room2.setExits(null, room1,null,null);
        room3.setExits(null,null,null,room1);
        room4.setExits(null,room5,room3,null);
        room5.setExits(room4,room6,null,null);
        room6.setExits(room5,null,room7,null);
        room7.setExits(null,null,null,room6);





        startRoom = room1;
//
        Weapon Sword = WeaponFactory.createWeapon(WeaponType.SWORD);
        Weapon Shield = WeaponFactory.createWeapon(WeaponType.SHIELD);



        Potion smallPotion = PotionFactory.createPotion(PotionType.SMALL_POTION);
        Potion buffPotion = PotionFactory.createPotion(PotionType.BUFF_POTION);



        Monster cat = monsterFactory.createMonster("Cat");
        Monster slime = monsterFactory.createMonster("Slime");
        Monster pikachu = monsterFactory.createMonster("Pikachu");
        Monster dragon = monsterFactory.createMonster("Dragon");



        room1.setItems(Sword, smallPotion);
        room3.setItems(Shield);
        room2.setMonster(cat);
        room4.setItems(buffPotion);
        room5.setMonster(slime);
        room6.setMonster(pikachu);
        room7.setMonster(dragon);


    }




    @Override
    public String getName() {
        return name;
    }

    @Override
    public void openMap() {

        File file = new File("C:\\Users\\Jay\\Desktop\\saveZork\\" + getName()+".txt");
        try {
            Scanner scanner = new Scanner(file);
            System.out.println("");
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                System.out.println(s);
            }
            System.out.println("");
        } catch (FileNotFoundException e) {
            System.out.println((""));
            System.out.println("!!! An error occurred while loading the map !!!");
            System.out.println((""));
        }
    }



    @Override
    public Room getStartRoom() {
        return this.startRoom;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getTask() {
        return task;
    }

    @Override
    public List<Room> getAllRooms() {
        return roomList;
    }
}