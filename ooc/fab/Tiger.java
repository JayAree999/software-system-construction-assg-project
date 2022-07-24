package io.muic.ooc.fab;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Tiger extends Animal {
    // Characteristics shared by all foxes (class variables).

    // The age at which a fox can start to breed.
    private static final int BREEDING_AGE = 30;
    // The age to which a fox can live.
    private static final int MAX_AGE = 1000;
    // The likelihood of a fox breeding.
    private static final double BREEDING_PROBABILITY = 0.001;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 2;
    // The food value of a single rabbit. In effect, this is the
    // number of steps a fox can go before it has to eat again.


    private static final Random RANDOM = new Random();

    // Individual characteristics (instance fields).
    // The fox's age.

    // Whether the fox is alive or not.

    // The fox's position.

    // The fox's food level, which is increased by eating rabbits.
    private int foodLevel;

    /**
     * Create a fox. A fox can be created as a new born (age zero and not
     * hungry) or with a random age and food level.
     *
     * @param randomAge If true, the fox will have random age and hunger level.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Tiger(boolean randomAge, Field field, Location location) {


        super(randomAge,field,location);
        foodLevel = RANDOM.nextInt(ActorType.RABBIT.getFoodValue()+ActorType.FOX.getFoodValue());
    }

    @Override
    protected int getMaxLitterSize() {
        return MAX_LITTER_SIZE;
    }



    @Override
    protected double getBreedingProbability() {
        return BREEDING_PROBABILITY;
    }


    public void act(List<Actor> newTigers) {
        incrementAge();
        incrementHunger();
        if (isAlive()) {
            giveBirth(newTigers);
            // Move towards a source of food if found.
            Location newLocation = findFood();
            if (newLocation == null) {
                // No food found - try to move to a free location.
                newLocation = getField().freeAdjacentLocation(getLocation());
            }
            // See if it was possible to move.
            if (newLocation != null) {
                setLocation(newLocation);
            } else {
                // Overcrowding.
                setDead();
            }
        }
    }

    private void incrementHunger() {
        foodLevel--;
        if (foodLevel <= 0) {
            setDead();
        }
    }


    private Location findFood() {
        List<Location> adjacent = getField().adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while (it.hasNext()) {
            Location where = it.next();
            Object animal =getField().getObjectAt(where);
            if (animal instanceof Rabbit && (animal instanceof Tiger == false) ) {
                Animal living = (Animal) animal;

                if (living.isAlive()) {
                    living.setDead();
                    foodLevel = ActorType.RABBIT.getFoodValue();
                    return where;
                }
            }
            if (animal instanceof Fox && (animal instanceof Tiger == false) ) {
                Animal living = (Animal) animal;

                if (living.isAlive()) {
                    living.setDead();
                    foodLevel = ActorType.FOX.getFoodValue();
                    return where;
                }
            }


        }
        return null;
    }

    private void giveBirth(List<Actor> newTigers) {
        // New foxes are born into adjacent locations.
        // Get a list of adjacent free locations.
        List<Location> free = getField().getFreeAdjacentLocations(getLocation());
        int births = breed();
        for (int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Tiger young = new Tiger(false, getField(), loc);
            newTigers.add(young);
        }
    }



    @Override
    protected int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected int getBreedingAge() {
        return BREEDING_AGE;
    }




}
