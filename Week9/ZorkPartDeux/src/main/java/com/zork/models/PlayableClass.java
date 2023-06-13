package com.zork.models;

public class PlayableClass {
    private int healthBoost;
    private int magicBoost;
    private int damageBoost;
    private String name;

    public PlayableClass(int healthBoost, int magicBoost, int damageBoost, String name) {
        this.healthBoost = healthBoost;
        this.magicBoost = magicBoost;
        this.damageBoost = damageBoost;
        this.name = name;
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

    public int getDamageBoost() {
        return damageBoost;
    }

    public void setDamageBoost(int damageBoost) {
        this.damageBoost = damageBoost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
