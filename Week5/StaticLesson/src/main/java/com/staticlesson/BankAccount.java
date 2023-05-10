package com.staticlesson;

public class BankAccount {
    private String number;
    private String name;
    private double balance;
    private static double interestRate;

    public BankAccount(String number, String name, double balance) {
        this.number = number;
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
        //this.balance = this.balance + amount
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public static double getInterestRate(){
        return interestRate;
    }

    public static void setInterestRate(double newInterestRate){
        interestRate = newInterestRate;
    }
}
