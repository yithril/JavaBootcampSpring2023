package com.polymorphism;

public class Person {
    private String name;
    private double height;

    public Person(String name, double height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    //Default speak method
    public void speak(){
        System.out.printf("Whatsup! My name is %s %n", this.name);
    }
}
