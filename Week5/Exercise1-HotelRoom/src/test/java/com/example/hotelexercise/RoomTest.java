package com.example.hotelexercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    @Test
    public void getReservationTotal_ReturnsCorrectValue(){
        //Arrange
        //The arrange section of a unit test is to prepare any objects or variables you may need
        //Making new objects is common in the arrange step, so is making up variables
        Room room = new Room(2, 100, false, false, "king");
        Reservation reservation = new Reservation(3, false, room);

        //Act
        //Run the method. Perform the experiment.
        double result = reservation.getReservationTotal();

        //Assert
        //The number we get back should be 417
        assertEquals(417, result);
    }
}