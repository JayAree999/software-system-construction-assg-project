package io.muzoo.gigadot.ssc.zork.item.weapon;

import io.muzoo.gigadot.ssc.zork.item.potion.BuffPotion;
import io.muzoo.gigadot.ssc.zork.item.potion.Potion;

import io.muzoo.gigadot.ssc.zork.item.potion.SmallPotion;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class WeaponFactory {

    private static Map<WeaponType, Weapon> weaponMap = new HashMap<>();

    static {
        for (WeaponType weaponType : WeaponType.values()){
            Weapon weapon = null;
            try {
                weapon = (Weapon) weaponType.getWeaponClass().getDeclaredConstructor().newInstance();
                weaponMap.put(weaponType, weapon);
            } catch (InstantiationException e ){
                e.printStackTrace();
            } catch (IllegalAccessException e){
                e.printStackTrace();
            } catch (InvocationTargetException e){
                e.printStackTrace();
            } catch (NoSuchMethodException e){
                e.printStackTrace();
            }
        }

        weaponMap.put(WeaponType.SWORD,  new Sword());
        weaponMap.put(WeaponType.SHIELD,  new Shield());


    }
    public static Weapon get(WeaponType potionType){
        return weaponMap.get(potionType);

    }
    public static Weapon createWeapon(WeaponType weaponName) {

        for (WeaponType map : weaponMap.keySet()) {

            if ((map.getWeaponName().toUpperCase(Locale.ROOT)).equals(weaponName.getWeaponName().toUpperCase(Locale.ROOT))) {

                try {
                    return weaponMap.get(map).getClass().getDeclaredConstructor().newInstance();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}