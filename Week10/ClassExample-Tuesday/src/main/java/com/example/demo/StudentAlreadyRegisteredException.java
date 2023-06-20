package com.example.demo;

public class StudentAlreadyRegisteredException extends Exception {
    public StudentAlreadyRegisteredException(String errorMessage) {
        super(errorMessage);
    }
}
