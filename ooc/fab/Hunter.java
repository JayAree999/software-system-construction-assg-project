package io.muic.ooc.fab;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Hunter extends Actor{


        // Characteristics shared by all foxes (class variables).

        // The age at which a fox can start to breed.

        // The age to which a fox can live.
        private static final int MAX_AGE = 150;
        // The likelihood of a fox breeding.

        // The food value of a single rabbit. In effect, this is the
        // number of steps a fox can go before it has to eat again.
        private static final int RABBIT_FOOD_VALUE = 9;
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
        public Hunter(boolean randomAge, Field field, Location location) {


            super(randomAge,field,location);
        }

        public void act(List<Actor> newHunter) {

            if (isAlive()) {

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

        /**
         * Check whether the fox is alive or not.
         *
         * @return True if the fox is still alive.
         */


        /**
         * Return the fox's location.
         *
         * @return The fox's location.
         */


        /**
         * Place the fox at the new location in the given field.
         *
         * @param newLocation The fox's new location.
         */

        /**
         * Increase the age. This could result in the fox's death.
         */


        /**
         * Make this fox more hungry. This could result in the fox's death.
         */


        /**
         * Look for rabbits adjacent to the current location. Only the first live
         * rabbit is eaten.
         *
         * @return Where food was found, or null if it wasn't.
         */
        private Location findFood() {
            List<Location> adjacent = getField().adjacentLocations(getLocation());
            Iterator<Location> it = adjacent.iterator();
            while (it.hasNext()) {
                Location where = it.next();
                Object animal = getField().getObjectAt(where);
                if (animal instanceof Rabbit) {
                    Rabbit rabbit = (Rabbit) animal;
                    if (rabbit.isAlive()) {
                        rabbit.setDead();
                        foodLevel = ActorType.RABBIT.getFoodValue();
                        return where;
                    }
                }
            }
            return null;
        }




        @Override
        protected int getMaxAge() {
            return MAX_AGE;
        }







    }


