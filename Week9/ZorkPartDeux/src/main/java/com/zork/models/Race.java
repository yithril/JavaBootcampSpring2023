package com.zork.models;

public class Race {
    private String name;
    private String homeland;
    private int healthBoost;
    private int magicBoost;
    private double regenRate;
    //Primary Key
    private int raceID;

    public Race(String name, String homeland, int healthBoost, int magicBoost, double regenRate) {
        this.name = name;
        this.homeland = homeland;
        this.healthBoost = healthBoost;
        this.magicBoost = magicBoost;
        this.regenRate = regenRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeland() {
        return homeland;
    }

    public void setHomeland(String homeland) {
        this.homeland = homeland;
    }

    public int getHealthBoost() {
        return healthBoost;
    }

    public void setHealthBoost(int healthBoost) {
        this.healthBoost = healthBoost;
    }

    public int getMagicBoost() {
        return magicBoost;
    }

    public void setMagicBoost(int magicBoost) {
        this.magicBoost = magicBoost;
    }

    public double getRegenRate() {
        return regenRate;
    }

    public void setRegenRate(double regenRate) {
        this.regenRate = regenRate;
    }
}
