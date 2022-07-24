package io.muzoo.gigadot.ssc.zork.map;

import io.muzoo.gigadot.ssc.zork.item.Item;
import io.muzoo.gigadot.ssc.zork.item.potion.Potion;
import io.muzoo.gigadot.ssc.zork.monster.Monster;

import java.io.Serializable;
import java.util.*;

public class Room implements Serializable {

        private HashMap<String, Room> exits;

        private String description;
        private List<Item> allItem;
        private Monster monster;


    public Room(String description) {
        exits = new HashMap<String, Room>();
            this.description = description;
            allItem = new ArrayList<>();
            monster = null;
        }

    public void setExits(Room north, Room south, Room west, Room east)
    {
        if(north != null)
            exits.put("north", north);
        if(south != null)
            exits.put("south", south);
        if(west != null)
            exits.put("west", west);
        if(east != null)
            exits.put("east", east);

    }

        public Collection<String> getAllExits() {
            return exits.keySet();
        }
        public Room getThatRoom(String key) {
             return exits.get(key);
        }
        public String getDescription() {
            return description;
        }

        public void setItems(Item... someItems){
            for (Item a : someItems){
                this.allItem.add(a);
            }
        }

        public void removeItem(Item item) {
            this.allItem.remove(item);
        }

        public List<Item> getAllItems() {
            return allItem;
        }


        public boolean containsItem() {
            return !allItem.isEmpty();
        }

        public Monster getMonster() {
            return monster;
        }

        public void setMonster(Monster monster) {
            this.monster = monster;
        }

        public boolean containsMonster() {
            return monster != null;
        }

        public void removeMonster() {
            monster = null;
        }

        public void printStats() {

            System.out.println("");
            System.out.println("Current Room");

            System.out.println(" Exits: " + getAllExits());
            if (!allItem.isEmpty()) {
                List<String> itemList = new ArrayList<>();
                for (Item item : allItem) {
                    itemList.add(item.getName());
                }
                System.out.println((" Item(s): " + itemList));
            }
            else {
                System.out.println(" Item(s): No Item can be picked up in this room.");
            }
            System.out.println((""));
        }


}

