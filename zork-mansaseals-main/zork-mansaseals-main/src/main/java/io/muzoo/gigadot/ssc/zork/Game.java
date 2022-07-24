package io.muzoo.gigadot.ssc.zork;

import io.muzoo.gigadot.ssc.zork.command.*;

import io.muzoo.gigadot.ssc.zork.map.WorldMap;
import io.muzoo.gigadot.ssc.zork.map.MapFactory;
import io.muzoo.gigadot.ssc.zork.map.MapType;
import io.muzoo.gigadot.ssc.zork.map.Room;
import io.muzoo.gigadot.ssc.zork.map.WorldMap;

import java.io.*;

import java.util.*;

public class Game {

    private boolean exit = false;
    private boolean inGame = false;
    private boolean outGame = true;
    private static Player player = new Player();
    private StringBuilder inputTracker = new StringBuilder();
    public static WorldMap currentMap;
    private Scanner scanner = new Scanner(System.in);
    private static Room currentRoom;


    public boolean isExit(){
        return exit;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
    public void exit()  {
        this.exit = true;
        scanner.close();
    }
    public void start(){

        System.out.println("Game started!");
        System.out.println("========================================");
        System.out.println("WELCOME TO ZORK");
        System.out.println("========================================");

        for (MapType mapType: MapType.values()){
            System.out.println(mapType.getMapName().toUpperCase(Locale.ROOT));
        }

        System.out.println("Type 'play [map_name]' to start playing!");
        System.out.println("");
        createNewInputTracker();



        while (!isExit() && scanner.hasNextLine() ){
            String rawInput = scanner.nextLine();
            System.out.println("You entered string " + rawInput);

            try {

                CommandLine commandLine = CommandParser.parseCommand(rawInput);

                Command command = CommandFactory.get(commandLine.getCommandType());
                if (!commandLine.getCommandType().equals("save") && !commandLine.getCommandType().equals("load") && !commandLine.getCommandType().equals("quit")) {
                    addInputTracker(rawInput);
                }
                if (command == null) {
                    System.out.println("Try again");

                } else {
                    command.execute(this, commandLine.getArgument());


                }
                checkWin();


            } catch (NullPointerException e){
                System.out.println("WHAT? Need help? Type help");
            }

        }
        scanner.close();
    }
    public void checkWin(){
        WorldMap thisMap = getCurrentMap();
        HashSet<Room> done = new HashSet<Room>();
        for (Room rooms : thisMap.getAllRooms()){
            if(!rooms.containsMonster()){
                done.add(rooms);

            }

        }
        if (done.size()==thisMap.getAllRooms().size()){
            exit();
        }
    }


    public void beginNewMap(MapType mapName) {
        player = new Player();
        beginNewLevel(mapName);
    }
    public Player getPlayer() {

        return player;
    }

    public void save(String a){

        try {

            String path = "C:\\Users\\Jay\\Desktop\\saveZork\\" + a + ".txt";

            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(player);
            objectOutputStream.writeObject(currentRoom);
            System.out.println("Saving Process ....");


            fileOutputStream.close();
            objectOutputStream.close();

            System.out.println("");
            System.out.println("Save!");
            System.out.println("");
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }
    public void load(String a){

        try {

            FileInputStream fileIn = new FileInputStream("C:\\Users\\Jay\\Desktop\\saveZork\\" + a + ".txt");
            ObjectInputStream load = new ObjectInputStream(fileIn);

            this.player = (Player) load.readObject();
            this.currentRoom = (Room) load.readObject();

            System.out.println("Loading...");

            fileIn.close();
            load.close();
            System.out.println("Done!");
        }

        catch (Exception e) {
            e.getStackTrace();
        }
    }




    public static WorldMap getCurrentLevel() {
        return currentMap;
    }
    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public void setOutGame(boolean outGame) {
        this.outGame = outGame;
    }


    public WorldMap getCurrentMap(){
        return currentMap;
    }

    public void beginNewLevel(MapType currentLevel) {
        for (MapType level : MapFactory.getAvailableMap().keySet()) {

            if (currentLevel.equals(level)) {
                MapFactory factory = new MapFactory();
                this.currentMap = factory.createMap(level);
                this.currentRoom = this.currentMap.getStartRoom();
            }
        }
    }


    public void moveRoom(Room room) {
        currentRoom = room;
    }

    public void addInputTracker(String input) {
        inputTracker.append(input);
        inputTracker.append("\n");
    }

    public void createNewInputTracker() {
        inputTracker = new StringBuilder();
    }

    public String getInputTrackerAsString() {
        return inputTracker.toString();
    }
}
