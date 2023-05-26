package com.collectionsexamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        //array lists can change size
        //resizable
        ArrayList<Person> peopleList = new ArrayList<>();

        peopleList.add(new Person("Joe", "Everyman", 20));
        peopleList.add(new Person("Bob", "Everyman", 20));
        peopleList.add(new Person("Jim", "Everyman", 20));

        String[] stringArray = new String[3];

        //HashMap
        //The first is the key, the second is the value
        HashMap<String, String> dictionary = new HashMap<String, String>();

        dictionary.put("quixotic", "exceedingly idealistic; unrealistic and impractical.");
        dictionary.put("blah", "a word for when you can't think of something");
        dictionary.put("rococo", "the rococo style of art, decoration, or architecture.");

        dictionary.put("quixotic", "hey there");

        //System.out.println(dictionary.keySet());
        //System.out.println(dictionary.values());

        //System.out.println(dictionary.get("quixotic"));

        //ADVANCED
        HashMap<String, ArrayList<String>> betterDictionary = new HashMap<>();

        ArrayList<String> bearDefinitions = new ArrayList<>();
        bearDefinitions.add("Animal in the forest");
        bearDefinitions.add("To endure something");
        betterDictionary.put("bear", bearDefinitions);

        System.out.println(betterDictionary);
    }
}
