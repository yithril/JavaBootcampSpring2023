package com.capstoneproject.ledger;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private float amount;
    private String description;
    private String vendor;
    private boolean isDebit;
    private LocalDate transactionDate;

    private LocalTime transactionTime;

    public Transaction(float amount, String description, String vendor, boolean isDebit) {
        this.amount = amount;
        this.description = description;
        this.vendor = vendor;
        this.isDebit = isDebit;
        this.transactionDate = LocalDate.now();
        this.transactionTime = LocalTime.now();
    }

    public Transaction(float amount, String description, String vendor, boolean isDebit, LocalDate date, LocalTime time) {
        this.amount = amount;
        this.description = description;
        this.vendor = vendor;
        this.isDebit = isDebit;
        this.transactionDate = date;
        this.transactionTime = time;
    }

    public LocalDate getTransactionLocalDate(){
        return this.transactionDate;
    }
    public String getTransactionDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return formatter.format(transactionDate);
    }

    public String getTransactionTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return formatter.format(transactionTime);
    }

    public float getAmount() {
        if(this.isDebit){
            return amount * -1;
        }
        else{
            return amount;
        }
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public boolean isDebit() {
        return isDebit;
    }

    public void setDebit(boolean debit) {
        isDebit = debit;
    }
}
