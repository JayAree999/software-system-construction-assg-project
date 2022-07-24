package io.muic.ooc.fab;

import java.util.List;
import java.util.Random;

public abstract class Actor {


    // A shared random number generator to control breeding.
    private static final Random RANDOM = new Random();

    private int age = 0;
    private Location location;
    private Field field;

    protected void setDead() {
        setAlive(false);
        if (getLocation() != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    public Location getLocation() {
        return location;
    }

    public Field getField() {
        return field;
    }

    private boolean alive = true;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    protected void incrementAge() {
        age++;
        if (age > getMaxAge()) {
            setDead();
        }
    }

    public Actor(boolean randomAge, Field field, Location location) {

        this.field = field;
        setLocation(location);
        if (randomAge) {
            setAge(RANDOM.nextInt(getMaxAge()));
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    protected void setLocation(Location newLocation) {
        if (location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }


    protected abstract int getMaxAge();


    public abstract void act(List<Actor> newActors);

}
