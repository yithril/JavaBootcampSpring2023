package com.abstractclasses;

public abstract class Animal {
    private int numberOfLegs;
    private int numberOfEyes;
    private boolean canFly;

    public abstract void makeSound();

    //the part of the function that contains the access
    //the return type, and the name is called the signature
    //public int getNumberOfLegs is the method signature
    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public int getNumberOfEyes() {
        return numberOfEyes;
    }

    public void setNumberOfEyes(int numberOfEyes) {
        this.numberOfEyes = numberOfEyes;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }
}
