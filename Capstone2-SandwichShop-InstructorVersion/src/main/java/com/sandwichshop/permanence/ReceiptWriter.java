package com.sandwichshop.permanence;

import com.sandwichshop.Order;
import com.sandwichshop.interfaces.OrderItem;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReceiptWriter {
    public static void writeOrderToReceipt(Order order){
        try{
            //file name is based on date and time
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
            String fileName = df.format(new Date()) + ".txt";
            System.out.println(fileName);
            FileWriter fileWriter = new FileWriter(fileName, true);

            fileWriter.append(String.format("Order total was %s %n", currencyFormat(order.getOrderTotal())));
            int counter = 1;
            for(OrderItem item : order.getOrderItems()){
                fileWriter.append(String.format("%d. (%s) %s %n", counter, item.getPrice(), item.getName()));
                counter++;
            }

            fileWriter.close();
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
    }

    private static String currencyFormat(BigDecimal n) {
        return NumberFormat.getCurrencyInstance().format(n);
    }
}
