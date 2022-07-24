package io.muzoo.gigadot.ssc.zork.map;


import java.util.List;

public interface WorldMap {
    String getName();
    void openMap();
    Room getStartRoom();
    String getDescription();
    String getTask();
    List<Room> getAllRooms();

}