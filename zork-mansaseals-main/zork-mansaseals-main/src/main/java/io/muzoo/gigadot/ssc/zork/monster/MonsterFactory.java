package io.muzoo.gigadot.ssc.zork.monster;

import java.util.Locale;

public class MonsterFactory {
    public Monster createMonster(String input) {
        String monster = input.toLowerCase(Locale.ROOT);

        if (monster.equals("cat")) {
            return new Cat();
        }
        if (monster.equals("dragon")) {
            return new Dragon();
        }
        if (monster.equals("pikachu")) {
            return new Pikachu();
        }
        if (monster.equals("slime")) {
            return new Slime();
        }

        return null;
    }
}