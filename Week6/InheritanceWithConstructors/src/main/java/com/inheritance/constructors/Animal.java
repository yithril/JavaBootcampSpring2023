package com.inheritance.constructors;

public class Animal {
    private int numberOfLegs;
    private boolean canSwim;
    private int numberOfEyes;
    private boolean canWalk;
    private boolean canFly;

    public Animal(int numberOfLegs, boolean canSwim, int numberOfEyes, boolean canWalk, boolean canFly) {
        this.numberOfLegs = numberOfLegs;
        this.canSwim = canSwim;
        this.numberOfEyes = numberOfEyes;
        this.canWalk = canWalk;
        this.canFly = canFly;
    }

    public Animal(int numberOfLegs, boolean canSwim, int numberOfEyes){
        this.numberOfLegs = numberOfLegs;
        this.canSwim = canSwim;
        this.numberOfEyes = numberOfEyes;
    }

    //If you don't a write a constructor
    //Java gives you a default constructor
    //parameterless constructor
    /*
    public Animal(){

    }
     */

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public boolean isCanSwim() {
        return canSwim;
    }

    public void setCanSwim(boolean canSwim) {
        this.canSwim = canSwim;
    }

    public int getNumberOfEyes() {
        return numberOfEyes;
    }

    public void setNumberOfEyes(int numberOfEyes) {
        this.numberOfEyes = numberOfEyes;
    }

    public boolean isCanWalk() {
        return canWalk;
    }

    public void setCanWalk(boolean canWalk) {
        this.canWalk = canWalk;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public void eat(){
        System.out.println("Chomp chomp!");
    }
}
