package com.productionready.jdbc;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        if(args.length != 2){
            System.out.println("This app must be started with two parameters, the username and password for SQL");
            System.exit(1);
        }

        String userName = args[0];
        String password = args[1];

        //Putting the connection and prepared statement here ensures they will be disposed of
        //notice how there is code inside parenthesis next to try
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", userName, password);
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products");){

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                //loop through all the rows returned by SQL
                while(resultSet.next()){
                    System.out.println(resultSet.getInt("ProductID"));
                    System.out.println(resultSet.getString("ProductName"));
                    System.out.println(resultSet.getDouble("UnitPrice"));
                }
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
