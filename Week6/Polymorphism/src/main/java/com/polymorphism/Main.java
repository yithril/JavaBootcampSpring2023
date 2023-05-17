package com.polymorphism;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Caveman ugh = new Caveman("Ugh", 200, true, true);

        ModernMan jim = new ModernMan("Jim Everyman", 250, true);

        Person person = new Person("Clark Kent", 350);

        Person newPerson;

        newPerson = new ModernMan("Lebron James", 1000, true);

        newPerson = new Caveman("Bruh", 100, true, false);

        FutureMan futureMan = new FutureMan("Ultron", 500, true, true);

        //This does NOT work
        //ModernMan modernMan = new Caveman("Grak", 200, false, false);
        ArrayList<String> stringList = new ArrayList<>();

        ArrayList<Person> personList = new ArrayList<Person>();

        personList.add(jim);
        personList.add(ugh);
        personList.add(newPerson);
        personList.add(futureMan);

        //jim, ugh, newPerson
        for(Person p : personList){
            p.speak();
        }
    }
}
