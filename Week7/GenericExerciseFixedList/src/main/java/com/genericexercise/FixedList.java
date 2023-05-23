package com.genericexercise;

import java.util.ArrayList;
import java.util.List;

public class FixedList<T> {
    private List<T> items = new ArrayList<>();
    private int maxSize;

    public FixedList(int maxSize){
        this.maxSize = maxSize;
    }

    public void add(T item){
        if(items.size() < maxSize){
            items.add(item);
        }
    }

    public List<T> getItems(){
        return this.items;
    }
}
