package org.sandwichshop.models;

public class Ingredient {
    private String name;
    private boolean isIncluded;
    private double priceOffset;
    private double basePrice;

    public Ingredient(String name, boolean isIncluded, double priceOffset, double basePrice) {
        this.name = name;
        this.isIncluded = isIncluded;
        this.priceOffset = priceOffset;
        this.basePrice = basePrice;
    }

    public double getPrice(int size){
        if(isIncluded){
            return 0;
        }
        else{
            return this.basePrice + (this.priceOffset * size);
        }
    }
}
