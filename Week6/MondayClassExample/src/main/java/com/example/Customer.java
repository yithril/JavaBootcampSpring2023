package com.example;

import java.time.LocalDate;

public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private int creditRating;

    public Customer(int customerId, String firstName, String lastName, LocalDate birthDate, int creditRating) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.creditRating = creditRating;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(int creditRating) {
        this.creditRating = creditRating;
    }

    public int getAge(){
        return 0;
    }

    public void calculateCreditRating() {

    }
}
