package com.example.hotelexercise;

public class Guest {
    //What does the class know?
    //Typically the things the class knows are private variables
    //These properties are backing the Guest
    //Encapsulated
    //Backed variables
    private String firstName;
    private String lastName;
    private int age;
    private String cardNumber;
    private String paymentMethod;
    private boolean isRewardsMember;

    public Guest(String firstName, String lastName, int age, String cardNumber, String paymentMethod, boolean isRewardsMember){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.cardNumber = cardNumber;
        this.paymentMethod = paymentMethod;
        this.isRewardsMember = isRewardsMember;
    }

    //overload
    //An overload is two methods with the same name but different number of arguments/parameters
    public Guest(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
}
