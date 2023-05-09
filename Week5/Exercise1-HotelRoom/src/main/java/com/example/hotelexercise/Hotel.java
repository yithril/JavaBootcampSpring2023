package com.example.hotelexercise;

public class Hotel {
    public static void main(String[] args){
        //instantiation = new
        Guest firstGuest = new Guest("George", "Washington", 60, "123456", "Visa", true);

        Guest secondGuest = new Guest("John", "Adams", 42);

        Room room = new Room(2, 100, false, false, "king");

        //calling a method
        //invoking a method
        room.setRoomType("double");

        String roomType = room.getRoomType();
    }
}
