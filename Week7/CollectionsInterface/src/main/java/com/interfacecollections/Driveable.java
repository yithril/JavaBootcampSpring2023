package com.interfacecollections;

public interface Driveable {
    void turnOnEngine();

    default void repair(){
        System.out.println("Repairing the car");
    }
}
