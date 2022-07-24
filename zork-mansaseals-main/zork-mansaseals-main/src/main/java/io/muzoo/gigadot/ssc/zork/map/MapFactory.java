package io.muzoo.gigadot.ssc.zork.map;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;



public class MapFactory {

    private static Map<MapType, WorldMap> worldMap = new HashMap<>();

        static {
            for (MapType mapType : MapType.values()){
                WorldMap map = null;
                try {
                    map = (WorldMap) mapType.getMapClass().getDeclaredConstructor().newInstance();
                    worldMap.put(mapType, map);
                } catch (InstantiationException e ){
                    e.printStackTrace();
                } catch (IllegalAccessException e){
                    e.printStackTrace();
                } catch (InvocationTargetException e){
                    e.printStackTrace();
                } catch (NoSuchMethodException e){
                    e.printStackTrace();
                }
            }
            worldMap.put(MapType.CAVEN, new Caven());
            worldMap.put(MapType.CLASSROOM, new Caven());

        }

    public static WorldMap get(MapType mapType) {
        return worldMap.get(mapType);

    }



    public static Map<MapType, WorldMap> getAvailableMap() {
        return worldMap;
    }

    public WorldMap createMap(MapType mapName) {
        for (MapType map : worldMap.keySet()) {
            if (map.equals(mapName)) {
                try {
                    return worldMap.get(map).getClass().getDeclaredConstructor().newInstance();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
