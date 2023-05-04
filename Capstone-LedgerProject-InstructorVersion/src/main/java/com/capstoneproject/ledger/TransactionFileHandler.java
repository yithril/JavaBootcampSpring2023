package com.capstoneproject.ledger;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.IllegalFormatConversionException;

public class TransactionFileHandler {
    public static void writeTransactionToFile(Transaction transaction){
        try{
            FileWriter fileWriter = new FileWriter("transactions.csv", true);

            fileWriter.write(String.format("%s|%s|%s|%s|%.02f|%b %n", transaction.getTransactionDate(), transaction.getTransactionTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount(), transaction.isDebit()));
            fileWriter.close();
        }
        catch(IOException ioException){
            System.out.println("Could not write to transactions.csv file. There was an error.");
            ioException.printStackTrace();
        }
        catch(IllegalFormatConversionException formatException){
            System.out.println("Sorry, be sure to input your information in the correct format.");
            formatException.printStackTrace();
        }
    }

    public static ArrayList<Transaction> readTransactionsFromFile(){
        ArrayList<Transaction> transactions = new ArrayList<>();

        try{
            BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"));
            String line;

            while((line = reader.readLine()) != null){
                String[] splitTransaction = line.split("\\|");

                Transaction currentTransaction = new Transaction(Float.parseFloat(splitTransaction[4]),
                        splitTransaction[2],
                        splitTransaction[3],
                        Boolean.parseBoolean(splitTransaction[4]),
                        LocalDate.parse(splitTransaction[0]),
                        LocalTime.parse(splitTransaction[1]));

                transactions.add((currentTransaction));
            }
        }
        catch(NumberFormatException numberFormatException){
            System.out.println("The amount was not formatted correct");
        }
        catch(DateTimeParseException dateTimeParseException){
            System.out.println("Could not parse the date in the file to LocalDate");
            dateTimeParseException.printStackTrace();
        }
        catch(FileNotFoundException fileNotFoundException){
            System.out.println("The transactions.csv file was not found!");
        }
        catch(IOException ioException){
            System.out.println("There was an error reading from the transaction file.");
            ioException.printStackTrace();
        }

        return transactions;
    }
}
