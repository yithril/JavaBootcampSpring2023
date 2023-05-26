package com.example.hotelexercise;

public class Reservation {
    //private backing variables
    //instance variables
    private int numberOfNights;
    private boolean isWeekend;
    //Room class is a dependency
    private Room room;

    //make our constructor
    public Reservation(int numberOfNights, boolean isWeekend, Room room){
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
        this.room = room;
    }

    public double getReservationTotal(){
        //If its king we charge 139 if its double 124
        //Get the number of nights
        //Multiply number of nights by the cost of the room
        //Get the room type
        //Check if its the weekend or not
        //If its the weekend add 10% if its not do nothing
        double price = 0;
        if(this.room.getRoomType() == "king"){
            price = 139;
        }
        else{
            price = 124;
        }

        price = price * this.numberOfNights;

        if(this.isWeekend == true){
            price = price * 1.1;
        }

        return price;
    }

    public void displayPrice(){

    }

    //getters and setters
    public int getNumberOfNights(){
        return this.numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights){
        this.numberOfNights = numberOfNights;
    }

    public Room getRoom(){
        return this.room;
    }

    public void setRoom(Room room){
        this.room = room;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }
}
