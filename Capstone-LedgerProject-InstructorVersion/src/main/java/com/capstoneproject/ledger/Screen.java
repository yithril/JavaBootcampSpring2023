package com.capstoneproject.ledger;

import java.util.ArrayList;
import java.util.Scanner;

public class Screen {
    public static void mainScreen(){
        boolean programIsRunning = true;

        while(programIsRunning){
            displayUserOptions();
            int userChoice = getUserMenuSelection();

            switch(userChoice){
                case 1:
                    gatherTransactionData(false);
                    break;
                case 2:
                    gatherTransactionData(true);
                    break;
                case 3:
                    LedgerScreen.ledgerScreen();
                    break;
                case 4:
                    System.out.println("Exiting program. Have a nice day.");
                    programIsRunning = false;
                    break;
                default:
                    System.out.println("That was not a valid choice. Please try again.");
            }
        }
    }
    private static void gatherTransactionData(boolean isDebit){
        String vendor = promptUserForVendor();
        String description = promptUserForDescription();
        float amount = promptUserForAmount();

        if(validateTransaction(description, vendor, amount)){
            TransactionFileHandler.writeTransactionToFile(new Transaction(amount, description.trim(), vendor.trim(), isDebit));
        }
    }

    private static boolean validateTransaction(String description, String vendor, float amount){
        boolean problemFound = false;
        ArrayList<String> errors = new ArrayList<String>();

        if(description.isBlank() || description.isEmpty()){
            errors.add("The description cannot be blank.");
            problemFound = true;
        }

        if(vendor.isBlank() || vendor.isEmpty()){
            errors.add("The vendor cannot be blank.");
            problemFound = true;
        }

        if(amount <= 0){
            errors.add("Please input an amount that is greater than zero.");
            problemFound = true;
        }

        if(problemFound){
            for(int i = 0; i < errors.size(); i++){
                System.out.println(errors.get(i));
            }
            return false;
        }
        else{
            return true;
        }
    }

    private static void displayUserOptions(){
        System.out.println("--------------------Menu-------------------");
        System.out.println("Please select from the following options:");
        System.out.println("1. Make a deposit.");
        System.out.println("2. Make a payment.");
        System.out.println("3. View your ledger.");
        System.out.println("4. Exit program");
    }

    private static int getUserMenuSelection(){
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }
    private static String promptUserForVendor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide the name of the vendor: ");
        return scanner.nextLine();
    }

    private static String promptUserForDescription(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide a description of the transaction: ");
        return scanner.nextLine();
    }

    private static float promptUserForAmount(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide the amount of the transaction: ");
        return scanner.nextFloat();
    }
}
