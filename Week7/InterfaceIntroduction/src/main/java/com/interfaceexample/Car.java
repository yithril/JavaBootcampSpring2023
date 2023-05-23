package com.interfaceexample;

//inheriting more than one class is called multiple inheritance
//it is not allowed in java
public class Car extends Vehicle implements Driveable, PowerTool {
    private String make;
    private String model;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void repair(){
        System.out.println("Repairing the Car.");
    }
    @Override
    public void turnOn() {
        System.out.println("The car goes vroom!");
    }
}
