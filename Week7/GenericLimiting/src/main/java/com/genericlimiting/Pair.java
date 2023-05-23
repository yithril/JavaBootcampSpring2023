package com.genericlimiting;

public class Pair<T extends Musician> {
    private T performer1;
    private T performer2;

    public Pair(T performer1, T performer2){
        this.performer1 = performer1;
        this.performer2 = performer2;
    }

    public void playDuet(){
        ((Musician)this.performer1).perform();
        ((Musician)this.performer2).perform();
    }
}
