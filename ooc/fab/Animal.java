package io.muic.ooc.fab;

import java.util.List;
import java.util.Random;


public abstract class Animal extends Actor{

    // A shared random number generator to control breeding.
    private static final Random RANDOM = new Random();
    public Animal(boolean randomAge, Field field, Location location) {
        super(randomAge, field, location);
    }
    protected abstract int getMaxLitterSize();

    protected abstract double getBreedingProbability();

    protected abstract int getBreedingAge();
    protected int breed() {
        int births = 0;
        if (canBreed() && RANDOM.nextDouble() <= getBreedingProbability()) {
            births = RANDOM.nextInt(getMaxLitterSize()) + 1;
        }
        return births;
    }
    protected boolean canBreed() {
        return getAge() >= getBreedingAge();
    }


    @Override
    protected int getMaxAge() {
        return 0;
    }


    @Override
    public void act(List<Actor> newAnimals) {

    }
}

