package io.muzoo.gigadot.ssc.zork.map;

public enum MapType {
    CAVEN(Caven.class, "Caven"),
    CLASSROOM(Classroom.class, "Classroom");


    private Class<? extends WorldMap> mapClass;
    private String mapName;
    private String mapDescription;

    MapType(Class<? extends WorldMap> mapClass, String mapName) {
        this.mapClass = mapClass;
        this.mapName = mapName;
    }

    public Class<? extends WorldMap> getMapClass() {
        return mapClass;
    }

    public String getMapName() {
        return mapName;
    }
}