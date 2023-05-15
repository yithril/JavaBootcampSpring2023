package com.example;
import java.math.BigDecimal;
import java.time.LocalDate;

//We could try combining the Employee and Customer class
//into one class. What are the drawbacks of doing so?
public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    //only for Employees
    private LocalDate hireDate;
    private double salary;
    private String department;

    //only for customers
    private int creditRating;

    //Employee Constructor
    public Person(String id, String firstName, String lastName, LocalDate birthDate, LocalDate hireDate, String department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.department = department;
    }

    //Customer constructor

    public Person(String id, String firstName, String lastName, LocalDate birthDate, int creditScore) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.creditRating = creditScore;
    }

    //methods just for employees
    public int getMonthsEmployed(){
        return 0;
    }

    public double earnPayRaise(BigDecimal percent){
        return 0;
    }

    //methods just for customers

}
