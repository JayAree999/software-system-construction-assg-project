package io.muzoo.gigadot.ssc.zork.item.potion;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PotionFactory {

     private static Map<PotionType, Potion> potionMap = new HashMap<>();

     static {
          for (PotionType potionType : PotionType.values()){
               Potion potion = null;
               try {
                    potion = (Potion) potionType.getPotionClass().getDeclaredConstructor().newInstance();
                    potionMap.put(potionType, potion);
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

          potionMap.put(PotionType.SMALL_POTION,  new SmallPotion());
          potionMap.put(PotionType.BUFF_POTION,  new BuffPotion());


     }
     public static Potion get(PotionType potionType){
          return potionMap.get(potionType);

     }
     public static Potion createPotion(PotionType potionName) {

          for (PotionType map : potionMap.keySet()) {

               if ((map.getPotionName().toUpperCase(Locale.ROOT)).equals(potionName.getPotionName().toUpperCase(Locale.ROOT))) {

                    try {
                         return potionMap.get(map).getClass().getDeclaredConstructor().newInstance();
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                         e.printStackTrace();
                    }
               }
          }
          return null;
     }
}