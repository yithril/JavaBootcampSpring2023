package com.genericexercise;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //FixedList can add new things until it reaches the maximum
        FixedList<Double> fixedList = new FixedList<>(3);

        fixedList.add(1.4);
        fixedList.add(1000d);
        fixedList.add(5.78232);

        //this should not show up in the list
        fixedList.add(78234203.21);

        System.out.println(fixedList.getItems());
    }

}
