package com.example.exercise2;

public class Reservation {
    private String roomType;
    private float price;
    private int numberOfNights;
    private boolean isWeekend;

    public Reservation(String roomType, float price, int numberOfNights, boolean isWeekend) {
        this.roomType = roomType;
        this.price = price;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    public float getReservationTotal(){
        float finalPrice;

        if(this.roomType == "king"){
            finalPrice = this.numberOfNights * 139;
        }
        else{
            finalPrice = this.numberOfNights * 124;
        }

        if(this.isWeekend){
            finalPrice *= 1.1;
        }

        return finalPrice;
    }
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }
}
