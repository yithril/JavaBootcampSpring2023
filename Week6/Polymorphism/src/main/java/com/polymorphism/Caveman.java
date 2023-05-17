package com.polymorphism;

public class Caveman extends Person {
    private boolean hasFurSkins;
    private boolean canMakeFire;

    public Caveman(String name, double height, boolean hasFurSkins, boolean canMakeFire) {
        super(name, height);
        this.hasFurSkins = hasFurSkins;
        this.canMakeFire = canMakeFire;
    }

    //override
    public void speak(){
        System.out.println(this.getName() + " grunts!");
    }

    public boolean isHasFurSkins() {
        return hasFurSkins;
    }

    public void setHasFurSkins(boolean hasFurSkins) {
        this.hasFurSkins = hasFurSkins;
    }

    public boolean isCanMakeFire() {
        return canMakeFire;
    }

    public void setCanMakeFire(boolean canMakeFire) {
        this.canMakeFire = canMakeFire;
    }
}
