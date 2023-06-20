package com.example.demo.exception;



//Fun fact, you can make your own exceptions
//This way if the ones that come with Java aren't enough
//you can just make your own
public class StudentAlreadyRegisteredException extends Exception {
    public StudentAlreadyRegisteredException(String errorMessage) {
        super(errorMessage);
    }
}
