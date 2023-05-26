package com.polyexercise;

public class Cash extends Asset {
    public Cash(String description, String dateAcquired, double originalCost) {
        super(description, dateAcquired, originalCost);
    }

    public double getValue(){
        return this.getOriginalCost();
    }
}
