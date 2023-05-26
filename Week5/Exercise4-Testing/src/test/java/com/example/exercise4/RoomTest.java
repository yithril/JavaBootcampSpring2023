package com.example.exercise4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void checkIn_roomIsCleanAndUnoccupied_Succeeds() {
        //Arrange
        Room room = new Room(false, false, 100, 2);

        //Act
        room.checkIn();

        //Assert
        assertTrue(room.isDirty());
        assertTrue(room.isOccupied());
    }

    @Test
    void checkout() {

    }

    @Test
    void cleanRoom() {
    }
}