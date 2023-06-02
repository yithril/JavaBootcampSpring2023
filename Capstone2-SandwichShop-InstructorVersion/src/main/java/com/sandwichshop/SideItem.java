package com.sandwichshop;

import com.sandwichshop.interfaces.OrderItem;

import java.math.BigDecimal;

public class SideItem implements OrderItem {
    private String name;
    private double basePrice;
    private double priceOffset;
    private int size;

    public SideItem(String name, double basePrice, double priceOffset, int size) {
        this.name = name;
        this.basePrice = basePrice;
        this.priceOffset = priceOffset;
        this.size = size;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(this.basePrice + (this.priceOffset * this.size));
    }
}
