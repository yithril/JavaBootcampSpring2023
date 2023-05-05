package com.capstoneproject.ledger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
    In all honesty this is not the implementation for filtering I might use in real life.
    However, the real one I would use is extremely advanced and I don't know
    if it would even be readable to you guys. So here's a simpler implementation.
*/

public class LedgerScreen {

    public static void ledgerScreen(){
        boolean runningLedger = true;

        while(runningLedger){
            if(getAllTransactions().size() == 0){
                System.out.println("No transaction data to display. Please make deposits or payments to populate the ledger.");
            }
            else{
                displayLedgerMenu();

                Scanner scanner = new Scanner(System.in);

                int userInput = Integer.parseInt(scanner.nextLine());

                switch(userInput){
                    case 1:
                        displayTransactionList(getAllTransactions());
                        break;
                    case 2:
                        displayTransactionList(filterDepositOrPayment(false));
                        break;
                    case 3:
                        displayTransactionList(filterDepositOrPayment(true));
                        break;
                    case 4:
                        System.out.println("Please input the description of the transaction");
                        displayTransactionList(filterByDescription(scanner.nextLine()));
                        break;
                    case 5:
                        System.out.println("Please input the vendor of the transaction");
                        displayTransactionList(filterByVendor(scanner.nextLine()));
                        break;
                    case 6:
                        System.out.println("Previous month's transactions");
                        displayTransactionList(filterByPreviousMonth());
                        break;
                    case 7:
                        System.out.println("Month to date transactions");
                        displayTransactionList(filterMonthToDate());
                        break;
                    case 8:
                        System.out.println("Year to date transactions");
                        displayTransactionList(filterYearToDate());
                        break;
                    case 9:
                        System.out.println("Exiting ledger...");
                        runningLedger = false;
                    default:
                        System.out.println("That was not a valid choice, please try again.");
                        break;
                }
            }
        }

    }

    private static void displayTransactionList(ArrayList<Transaction> transactions){
        Collections.sort(transactions, new TransactionDateComparator());

        for(Transaction t : transactions){
            System.out.printf("$%.2f | %s | %s | %s | %s %n", t.getAmount(), t.getVendor(), t.getDescription(), t.getTransactionDate(), t.getTransactionTime());
        }
    }
    private static void displayLedgerMenu(){
        System.out.println("--------------------------------Ledger-----------------------------------");
        System.out.println("Select from the following options:");
        System.out.println("1. View All Transactions");
        System.out.println("2. View Deposits");
        System.out.println("3. View Payments");
        System.out.println("4. Filter By Description.");
        System.out.println("5. Filter By Vendor");
        System.out.println("6. Previous Month");
        System.out.println("7. Month to Date");
        System.out.println("8. Year to Date");
        System.out.println("9. Go Back");
    }

    private static ArrayList<Transaction> filterByPreviousMonth(){
        ArrayList<Transaction> transactions = getAllTransactions();
        ArrayList<Transaction> returnList = new ArrayList<>();

        for(Transaction t : transactions){
            int lastMonth = LocalDate.now().minusMonths(1).getMonthValue();
            int lastYear = LocalDate.now().getYear();

            if(t.getTransactionLocalDate().getMonthValue() == lastMonth && t.getTransactionLocalDate().getYear() == lastYear){
                returnList.add(t);
            }
        }
        return returnList;
    }

    private static ArrayList<Transaction> filterMonthToDate(){
        ArrayList<Transaction> transactions = getAllTransactions();
        ArrayList<Transaction> returnList = new ArrayList<>();
        LocalDate firstDayOfMonth = LocalDate.now().withDayOfMonth(1);

        for(Transaction t : transactions){
            if(t.getTransactionLocalDate().isAfter(firstDayOfMonth)){
                returnList.add(t);
            }
        }
        return returnList;
    }

    private static ArrayList<Transaction> filterYearToDate(){
        ArrayList<Transaction> transactions = getAllTransactions();
        ArrayList<Transaction> returnList = new ArrayList<>();

        for(Transaction t : transactions){
            if(t.getTransactionLocalDate().isAfter(LocalDate.now().minusYears(1))){
                returnList.add(t);
            }
        }
        return returnList;
    }

    private static ArrayList<Transaction> getAllTransactions(){
        return TransactionFileHandler.readTransactionsFromFile();
    }
    private static ArrayList<Transaction> filterDepositOrPayment(boolean isDebit){
        ArrayList<Transaction> returnList = new ArrayList<>();
        ArrayList<Transaction> transactions = getAllTransactions();

        for(int i = 0; i < transactions.size(); i++){
            if(isDebit && transactions.get(i).getAmount() < 0){
                returnList.add(transactions.get(i));
            }

            if(!isDebit && transactions.get(i).getAmount() > 0){
                returnList.add(transactions.get(i));
            }
        }

        return returnList;
    }

    private static ArrayList<Transaction> filterByDescription(String searchTerm){
        ArrayList<Transaction> returnList = new ArrayList<>();
        ArrayList<Transaction> transactions = getAllTransactions();

        for(int i = 0; i < transactions.size(); i++){
            if(transactions.get(i).getDescription().toUpperCase().contains(searchTerm.toUpperCase())){
                returnList.add(transactions.get(i));
            }
        }

        return returnList;
    }

    private static ArrayList<Transaction> filterByVendor(String searchTerm){
        ArrayList<Transaction> returnList = new ArrayList<>();
        ArrayList<Transaction> transactions = getAllTransactions();

        for(int i = 0; i < transactions.size(); i++){
            if(transactions.get(i).getVendor().toUpperCase().contains(searchTerm.toUpperCase())){
                returnList.add(transactions.get(i));
            }
        }

        return returnList;
    }
}
