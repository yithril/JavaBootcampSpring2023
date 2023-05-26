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

    @Test
    public void roomIsAvailable_UserCanCheckIn(){
        //Arrange
        Room room1 = new Room(2, 100, false, false, "king");

        //Act
        room1.checkIn();

        //Assert
        assertEquals(true, room1.isDirty());
        assertEquals(true, room1.isOccupied());
    }

    @Test
    public void roomIsOccupied_UserCannotCheckIn(){
        //Arrange
        Room room1 = new Room(2, 100, false, true, "king");

        //Act
        room1.checkIn();

        assertEquals(false, room1.isDirty());
        assertEquals(true, room1.isOccupied());
    }

    @Test
    public void roomIsOccupied_UserChecksOut_Succeeds(){
        //Arrange
        Room room1 = new Room(2, 100, true, true, "king");

        //Act
        room1.checkOut();

        //Assert
        assertEquals(true, room1.isDirty());
        assertEquals(false, room1.isOccupied());
    }

    @Test
    public void roomIsNotOccupied_RoomIsClean_NoChange(){
        Room room1 = new Room(2, 100, false, false, "king");

        room1.checkOut();

        assertEquals(false, room1.isDirty());
        assertEquals(false, room1.isOccupied());
    }
}