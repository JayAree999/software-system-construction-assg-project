package io.muzoo.gigadot.ssc.zork.item.weapon;

import io.muzoo.gigadot.ssc.zork.item.potion.BuffPotion;
import io.muzoo.gigadot.ssc.zork.item.potion.Potion;
import io.muzoo.gigadot.ssc.zork.item.potion.SmallPotion;

public enum WeaponType {
    SWORD(Sword.class, "Sword", "bad sword"),
    SHIELD(Shield.class, "Shield", "damn it! it took me a while");


    private Class<? extends Weapon> weaponClass;

    private String weaponName;
    private String weaponDescription;


    WeaponType(Class<? extends Weapon> weaponClass, String weaponName, String weaponDescription) {
        this.weaponClass =  weaponClass;
        this.weaponName = weaponName;
        this.weaponDescription = weaponDescription;

    }


    public String getWeaponName() {
        return weaponName;
    }

    public String getWeaponDescription() {
        return weaponDescription;
    }

    public Class getWeaponClass() {
        return weaponClass;
    }


}