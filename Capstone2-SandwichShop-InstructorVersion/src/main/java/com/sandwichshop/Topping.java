package com.sandwichshop;

import com.sandwichshop.enums.ToppingCategory;

import java.math.BigDecimal;

public class Topping {
    private String name;
    private ToppingCategory toppingCategory;
    private double basePrice;
    private double priceOffset;
    private boolean isRegularTopping;

    public Topping(String name, ToppingCategory toppingCategory, double basePrice, double priceOffset, boolean isRegularTopping) {
        this.name = name;
        this.toppingCategory = toppingCategory;
        this.basePrice = basePrice;
        this.priceOffset = priceOffset;
        this.isRegularTopping = isRegularTopping;
    }

    public Topping(String name, ToppingCategory toppingCategory, boolean isRegularTopping){
        this.name = name;
        this.toppingCategory = toppingCategory;
        this.isRegularTopping = isRegularTopping;
    }

    public BigDecimal getPrice(int sandwichSize){
        return new BigDecimal(this.isRegularTopping ? 0 : this.basePrice + (this.priceOffset * sandwichSize));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ToppingCategory getToppingCategory() {
        return toppingCategory;
    }

    public void setToppingCategory(ToppingCategory toppingCategory) {
        this.toppingCategory = toppingCategory;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getPriceOffset() {
        return priceOffset;
    }

    public void setPriceOffset(double priceOffset) {
        this.priceOffset = priceOffset;
    }
}
