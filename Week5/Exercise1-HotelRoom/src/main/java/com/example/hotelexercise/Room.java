package com.example.hotelexercise;

public class Room {
    private boolean isDirty;
    private boolean isOccupied;
    private float price;
    private int numberOfBeds;

    public Hotel(boolean isDirty, boolean isOccupied, float price, int numberOfBeds) {
        this.isDirty = isDirty;
        this.isOccupied = isOccupied;
        this.price = price;
        this.numberOfBeds = numberOfBeds;
    }

    public boolean isAvailable(){
        if(!this.isDirty && !this.isOccupied){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void setDirty(boolean dirty) {
        isDirty = dirty;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }
}
