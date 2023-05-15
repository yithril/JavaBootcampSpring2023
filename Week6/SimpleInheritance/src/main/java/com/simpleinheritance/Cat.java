package com.simpleinheritance;

public class Cat extends Animal {
    private int numberOfLives = 9;

    public void meow(){
        System.out.println("Meow");
    }

    public int getNumberOfLives() {
        return numberOfLives;
    }

    public void setNumberOfLives(int numberOfLives) {
        this.numberOfLives = numberOfLives;
    }
}
