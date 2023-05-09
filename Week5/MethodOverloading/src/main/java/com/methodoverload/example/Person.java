package com.methodoverload.example;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    //There are two getFullName functions
    //We say 'getFullName is overloaded'
    //It means you can call getFullName with no parameters, or with a boolean, you pick!
    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public String getFullName(boolean isReverseOrder){
        if(isReverseOrder){
            return this.lastName + " " + this.firstName;
        }
        else{
            return getFullName();
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
