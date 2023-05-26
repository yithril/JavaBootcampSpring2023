package com.staticlesson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //This is an instance of a bank account
        BankAccount bankAccount1 = new BankAccount("109", "Billy Bob", 5000);

        BankAccount bankAccount2 = new BankAccount("175", "Alouscious", 100);

        bankAccount1.deposit(100);

        //globally available
        BankAccount.getInterestRate();

    }
}
