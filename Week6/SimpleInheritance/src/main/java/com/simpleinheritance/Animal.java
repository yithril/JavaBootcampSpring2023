package com.simpleinheritance;

public class Animal {
    private int numberOfEyes;
    private double teethSize;
    private boolean isFurBaby;
    private int numberOfLegs;
    private DietProfile isCarnivore;

    public Animal() {

    }
    public Animal(int numberOfEyes, double teethSize, boolean isFurBaby, int numberOfLegs, DietProfile isCarnivore) {
        this.numberOfEyes = numberOfEyes;
        this.teethSize = teethSize;
        this.isFurBaby = isFurBaby;
        this.numberOfLegs = numberOfLegs;
        this.isCarnivore = isCarnivore;
    }

    public int getNumberOfEyes() {
        return numberOfEyes;
    }

    public void setNumberOfEyes(int numberOfEyes) {
        this.numberOfEyes = numberOfEyes;
    }

    public double getTeethSize() {
        return teethSize;
    }

    public void setTeethSize(double teethSize) {
        this.teethSize = teethSize;
    }

    public boolean isFurBaby() {
        return isFurBaby;
    }

    public void setFurBaby(boolean furBaby) {
        isFurBaby = furBaby;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public DietProfile getIsCarnivore() {
        return isCarnivore;
    }

    public void setIsCarnivore(DietProfile isCarnivore) {
        this.isCarnivore = isCarnivore;
    }
}
