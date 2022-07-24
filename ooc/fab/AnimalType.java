package io.muic.ooc.fab;

import java.awt.*;

public enum AnimalType {
    //We can Configure properties in AnimalType
    //For example, set different Color.

    RABBIT(Rabbit.class, Color.ORANGE,.08),
    FOX(Fox.class,Color.BLUE,.02);
//    TIGER(Tiger.class,Color.GREEN,.001);


    private Class<? extends Animal> animalClass;

    private Color color;

    private double probability;
    AnimalType(Class<? extends Animal> animalClass,Color color, double probability){
        this.animalClass = animalClass;
        this.color = color;
        this.probability = probability;
    }

    public double getProbability() {
        return probability;
    }

    public Class<? extends Animal> getAnimalClass() {
        return animalClass;
    }


    public Color getColor() {
        return color;
    }
}
