package io.muic.ooc.fab;

import java.awt.*;



    public enum ActorType {
        //We can Configure properties in AnimalType
        //For example, set different Color.

        HUNTER(Hunter.class,Color.RED,0.001,27),
        RABBIT(Rabbit.class, Color.GREEN,0.1,9),
        FOX(Fox.class,Color.BLUE,0.01,18),
        TIGER(Tiger.class,Color.magenta,0.001,0);


//    TIGER(Tiger.class,Color.GREEN,.001);


        private Class<? extends Actor> actorClass;

        private int foodValue;

        private Color color;

        private double probability;
        ActorType(Class<? extends Actor> actorClass,Color color, double probability,int foodValue){
            this.actorClass = actorClass;
            this.color = color;
            this.probability = probability;
            this.foodValue = foodValue;
        }

        public double getProbability() {
            return probability;
        }

        public int getFoodValue() {
            return foodValue;
        }

        public Class<? extends Actor> getAnimalClass() {
            return actorClass;
        }


        public Color getColor() {
            return color;
        }
}
