package com.genericlimiting;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Violinist violinist = new Violinist();
        Cellist cellist = new Cellist();
        Flutist flutist = new Flutist();

        Pair<Musician> musicalPair = new Pair<>(violinist, flutist);

        musicalPair.playDuet();

        //Pair<Integer> integerPair = new Pair<>(2, 3);

        //integerPair.playDuet();

        //This code does not compile anymore
        //Pair<Integer> musicalPair2 = new Pair<Integer>(2, 3);
    }
}
