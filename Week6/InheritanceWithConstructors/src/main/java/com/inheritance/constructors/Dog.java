package com.inheritance.constructors;

public class Dog extends Animal {
    private boolean isHouseTrained;
    private String collarColor;
    private boolean isGoodBoy;

    public Dog(int numberOfLegs, boolean canSwim, int numberOfEyes, boolean canWalk, boolean canFly, boolean isHouseTrained, String collarColor, boolean isGoodBoy) {
        super(numberOfLegs, canSwim, numberOfEyes, canWalk, canFly);
        this.isHouseTrained = isHouseTrained;
        this.collarColor = collarColor;
        this.isGoodBoy = isGoodBoy;
    }

    public boolean isHouseTrained() {
        return isHouseTrained;
    }

    public void setHouseTrained(boolean houseTrained) {
        isHouseTrained = houseTrained;
    }

    public String getCollarColor() {
        return collarColor;
    }

    public void setCollarColor(String collarColor) {
        this.collarColor = collarColor;
    }

    public boolean isGoodBoy() {
        return isGoodBoy;
    }

    public void setGoodBoy(boolean goodBoy) {
        isGoodBoy = goodBoy;
    }

    public void bark(){
        System.out.println("WOOF!");
    }
}
