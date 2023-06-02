package com.sandwichshop;

import com.sandwichshop.enums.BreadType;
import com.sandwichshop.interfaces.OrderItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Sandwich implements OrderItem {
    private ArrayList<Topping> toppings = new ArrayList<>();
    private boolean isToasted;
    private int size = 0;
    private BreadType breadType;

    public Sandwich(int size) {
        this.size = size;
    }

    @Override
    public String getName(){
        var base = String.format("%s sandwich on %s bread", getSandwichSizeDescription(), this.breadType.name());

        if(this.toppings.size() > 0){
            base += " Toppings: " + this.toppings.stream().map(x -> x.getName()).collect(Collectors.toList()).toString().replace("[", "")
                    .replace("]", "")
                    .replace(" ", "");
        }

        return base;
    }

    @Override
    public BigDecimal getPrice() {
        return this.toppings.stream().map(x -> x.getPrice(this.size)).reduce(BigDecimal.ZERO, BigDecimal::add).add(this.getBasePrice());
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public int getSize() {
        return size;
    }

    //only values of 0, 1, and 2 are allowed
    public void setSize(int size) {
        if(size > 2 || size < 0){
            throw new IllegalArgumentException("Sandwich sizes can be 0, 1, or 2.");
        }
        else{
            this.size = size;
        }
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    private BigDecimal getBasePrice(){
        return new BigDecimal(5.5 + (this.size * 1.5));
    }

    private String getSandwichSizeDescription(){
        switch(this.size){
            case 0:
                return "4 inch";
            case 1:
                return "8 inch";
            case 2:
                return "12 inch";
            default:
                return "Something went horribly wrong. CALL SOMEONE FOR HELP!";
        }
    }
}
