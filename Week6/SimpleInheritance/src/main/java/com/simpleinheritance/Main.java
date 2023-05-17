package com.simpleinheritance;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
            Dog fido = new Dog("German Shephard", "Black and Brown", true);

            //these methods are the same for dogs and cats
            fido.setNumberOfEyes(2);
            fido.setIsCarnivore(DietProfile.OMNIVORE);
            fido.setTeethSize(2);

            //Dogs can bark
            fido.Bark();

            Cat fluffy = new Cat();

            //these methods are the same for dogs and cats
            fluffy.setNumberOfEyes(2);
            fluffy.setIsCarnivore(DietProfile.OMNIVORE);
            fluffy.setTeethSize(1);

            //Cats can meow
            fluffy.meow();
    }
}
