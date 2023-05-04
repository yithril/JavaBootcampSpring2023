package com.capstoneproject.ledger;

import java.util.Comparator;

public class TransactionDateComparator implements Comparator<Transaction> {
    @Override
    public int compare(Transaction trans1, Transaction trans2){
        return trans1.getTransactionLocalDate().compareTo(trans2.getTransactionLocalDate());
    }
}
