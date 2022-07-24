package io.muic.ooc.fab;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ActorFactory {

    private static final Map<ActorType, Class<? extends Actor>> ACTOR_MAPPING = new HashMap<>();

    static {
        ACTOR_MAPPING.put(ActorType.HUNTER, Hunter.class);
        ACTOR_MAPPING.put(ActorType.FOX, Fox.class);
        ACTOR_MAPPING.put(ActorType.RABBIT, Rabbit.class);
        ACTOR_MAPPING.put(ActorType.TIGER, Tiger.class);
    }

    public static Actor createActor(ActorType anActorType, boolean randomAge, Field field, Location location) {
        try {
            return ACTOR_MAPPING.get(anActorType).getDeclaredConstructor(boolean.class, Field.class, Location.class).newInstance(randomAge, field,location);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e ) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Unknown animal type");
    }
}
