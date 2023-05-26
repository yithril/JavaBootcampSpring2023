package com.example.hotelexercise;

public class Hotel {
    public static void main(String[] args){
        //instance of a room
        Room room = new Room(2, 100, false, false, "king");
        Reservation reservation = new Reservation(3, false, room);

        double total = reservation.getReservationTotal();
    }
}
