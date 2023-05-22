package com.interfaceexample;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        RidingMower mower = new RidingMower("John Deere", "X5100", "sharp?", 100);

        Car car = new Car("Dodge", "Charger");

        ArrayList<IDriveable> thingsThatAreDriveable = new ArrayList<>();

        //polymorphism
        thingsThatAreDriveable.add(mower);
        thingsThatAreDriveable.add(car);

        for(IDriveable driveable: thingsThatAreDriveable){
            driveable.turnOn();
        }
    }
}
