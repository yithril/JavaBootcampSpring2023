package com.abstractclasses;

public class Dog extends Animal {
    private boolean isGoodBoy;
    private boolean isHuntingBreed;

    public void makeSound(){
        System.out.println("Bark!");
    }
    public boolean isGoodBoy() {
        return isGoodBoy;
    }

    public void setGoodBoy(boolean goodBoy) {
        isGoodBoy = goodBoy;
    }

    public boolean isHuntingBreed() {
        return isHuntingBreed;
    }

    public void setHuntingBreed(boolean huntingBreed) {
        isHuntingBreed = huntingBreed;
    }
}
