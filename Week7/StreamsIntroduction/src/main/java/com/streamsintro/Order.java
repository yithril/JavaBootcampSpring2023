package com.streamsintro;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private String customer;
    private List<LineItem> lineItems;

    public Order(int id, String customer){
        this.id = id;
        this.customer = customer;
        this.lineItems = new ArrayList<>();
    }

    public void addItem(LineItem item){
        lineItems.add(item);
    }

    public double getTotal(){
        //imperative programming
        double total = 0;
        for(LineItem item: lineItems) {
            total += item.getLineTotal();
        }
        return total;
    }
}

