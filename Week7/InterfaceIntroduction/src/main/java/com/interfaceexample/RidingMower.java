package com.interfaceexample;

public class RidingMower implements Driveable, PowerTool {
    private String make;
    private String model;
    private String blade;
    private int speed;

    public RidingMower(String make, String model, String blade, int speed) {
        this.make = make;
        this.model = model;
        this.blade = blade;
        this.speed = speed;
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

    public String getBlade() {
        return blade;
    }

    public void setBlade(String blade) {
        this.blade = blade;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void turnOn(){
        System.out.println("Turned the riding mower on. It goes vroom!");
    }

    public void repair(){
        System.out.println("Repaired the riding mower!");
    }
}
