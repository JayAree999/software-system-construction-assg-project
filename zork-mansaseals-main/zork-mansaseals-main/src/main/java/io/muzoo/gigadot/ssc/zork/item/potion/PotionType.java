package io.muzoo.gigadot.ssc.zork.item.potion;


public enum PotionType {
    SMALL_POTION(SmallPotion.class, "small potion","heal"),
    BUFF_POTION(BuffPotion.class, "buff potion","buff");


    private Class<? extends Potion> potionClass;

    private String potionName;
    private String potionDescription;


    PotionType(Class<? extends Potion> potionClass, String potName, String potionDescription) {
        this.potionClass =  potionClass;
        this.potionName = potName;
        this.potionDescription = potionDescription;

    }


    public String getPotionDescription() {
        return potionDescription;
    }

    public Class getPotionClass() {
        return potionClass;
    }

    public String getPotionName() {
        return potionName;
    }


}