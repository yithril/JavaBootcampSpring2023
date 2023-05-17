package com.polymorphism;

public class Main {
    public static void main(String[] args) {
        Caveman ugh = new Caveman("Ugh", 200, true, true);

        ModernMan jim = new ModernMan("Jim Everyman", 250, true);

        Person person = new Person("Clark Kent", 350);

        person.speak();

        ugh.speak();

        jim.speak();
    }
}
