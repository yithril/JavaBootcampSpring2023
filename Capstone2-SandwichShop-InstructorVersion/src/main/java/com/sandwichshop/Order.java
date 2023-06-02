package com.sandwichshop;

import com.sandwichshop.interfaces.OrderItem;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Order {
    private ArrayList<OrderItem> orderItems = new ArrayList<>();

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public BigDecimal getOrderTotal(){
        return this.orderItems.stream().map(x -> x.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addItemToOrder(OrderItem item){
        this.orderItems.add(item);
    }
}
