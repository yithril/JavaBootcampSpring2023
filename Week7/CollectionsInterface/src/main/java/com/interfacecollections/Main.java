package com.interfacecollections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> stringArrayList = new ArrayList<>();

        stringArrayList = new LinkedList<>();

        Car car = new Car();

        car.repair();
    }
}
