package io.muzoo.gigadot.ssc.zork.monster;

import io.muzoo.gigadot.ssc.zork.item.Item;
import io.muzoo.gigadot.ssc.zork.item.potion.BuffPotion;
import io.muzoo.gigadot.ssc.zork.item.potion.Potion;
import io.muzoo.gigadot.ssc.zork.item.potion.PotionFactory;
import io.muzoo.gigadot.ssc.zork.item.potion.PotionType;

public class Slime extends Monster {


    private static final Item buffPot= PotionFactory.createPotion(PotionType.BUFF_POTION);

    public Slime() {
        super("Slime",
                ".... boong~.. boong~...",
                1500,
                120,
                0.8,
                 buffPot
        );
    }
}