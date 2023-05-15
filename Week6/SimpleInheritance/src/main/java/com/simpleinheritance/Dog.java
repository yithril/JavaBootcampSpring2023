package com.simpleinheritance;

public class Dog extends Animal {
    private String breed;
    private String furColor;
    private boolean isHuntingDog;

    public Dog(String breed, String furColor, boolean isHuntingDog) {
        this.breed = breed;
        this.furColor = furColor;
        this.isHuntingDog = isHuntingDog;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    public boolean isHuntingDog() {
        return isHuntingDog;
    }

    public void setHuntingDog(boolean huntingDog) {
        isHuntingDog = huntingDog;
    }

    public void Bark(){
        System.out.println("Woof!");
    }
}
