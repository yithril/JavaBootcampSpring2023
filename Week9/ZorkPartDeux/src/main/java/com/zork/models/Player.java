package com.zork.models;

public class Player {
    private String name;
    private int age;
    private String gender;
    private Race playerRace;
    private PlayableClass playableClass;
    private int level;
    private int experience;
    private int playerHealth;
    private int playerMagic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Race getPlayerRace() {
        return playerRace;
    }

    public void setPlayerRace(Race playerRace) {
        this.playerRace = playerRace;
    }

    public PlayableClass getPlayableClass() {
        return playableClass;
    }

    public void setPlayableClass(PlayableClass playableClass) {
        this.playableClass = playableClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

    public int getPlayerMagic() {
        return playerMagic;
    }

    public void setPlayerMagic(int playerMagic) {
        this.playerMagic = playerMagic;
    }
}
