package com.example.hotelexercise;

import java.math.BigDecimal;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean isDirty;
    private boolean isOccupied;
    private String roomType;

    public Room(int numberOfBeds, double price, boolean isDirty, boolean isOccupied, String roomType) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isDirty = isDirty;
        this.isOccupied = isOccupied;
        this.roomType = roomType;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isAvailable(){
        if(isDirty == false && isOccupied == false){
            return true;
        }
        else{
            return false;
        }
    }

    public int getNumberOfBeds(){
        return this.numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds){
        this.numberOfBeds = numberOfBeds;
    }
}
