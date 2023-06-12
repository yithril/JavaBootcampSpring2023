package com.example;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if(args.length != 2){
            System.out.println("Hey I need a username and a password!");
            System.exit(1);
        }

        String userName = args[0];
        String password = args[1];

        System.out.println("Input the product ID of the product you're looking for:");
        Scanner scanner = new Scanner(System.in);
        String productId = scanner.nextLine();

        //checked exception
        try{
            //attempt to establish connection to SQL server
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/northwind",
                            userName, password);

            String query = "SELECT * FROM products WHERE ProductID = ?";

            //ALWAYS use prepared statement
            //Prepare our query that SQL will run
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, productId);

            //Actually perform the query and get results back
            ResultSet resultSet = preparedStatement.executeQuery(query);

            //Loop through ALL rows returned by SQL
            while(resultSet.next()){
                System.out.println(resultSet.getString("ProductName"));
                System.out.println(resultSet.getInt("ProductID"));
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
