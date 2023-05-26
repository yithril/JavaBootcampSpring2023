package com.example.exercise4;
public class Room {
    private boolean isDirty;
    private boolean isOccupied;
    private float price;
    private int numberOfBeds;

    public Room(boolean isDirty, boolean isOccupied, float price, int numberOfBeds) {
        this.isDirty = isDirty;
        this.isOccupied = isOccupied;
        this.price = price;
        this.numberOfBeds = numberOfBeds;
    }

    public void checkIn(){
        if(this.isOccupied){
            System.out.println("That room is occupied. Cannot check in.");
        }else{
            this.isDirty = true;
            this.isOccupied = true;
        }
    }

    public void checkout(){
        this.isOccupied = false;
    }

    public void cleanRoom(){
        if(this.isOccupied){
            System.out.println("Someone is still in the room.");
        }
        else{
            this.isDirty = false;
        }
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
