package com.crudoperations.datamanager;

import com.crudoperations.dao.Product;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private DataSource dataSource;
    public ProductDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    //CRUD Create Read Update Delete

    //READ
    public List<Product> getAllProducts(){
        List<Product> productList = new ArrayList<>();

        String query = "SELECT * FROM products";

        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){

            try(ResultSet set = preparedStatement.executeQuery()){
                while(set.next()){
                    Product product = new Product(
                            set.getInt("ProductID"),
                            set.getString("ProductName"),
                            set.getInt("SupplierID"),
                            set.getInt("CategoryID"),
                            set.getString("QuantityPerUnit"),
                            set.getDouble("UnitPrice"),
                            set.getInt("UnitsInStock"),
                            set.getInt("UnitsOnOrder"),
                            set.getInt("ReorderLevel"),
                            set.getBoolean("Discontinued")
                    );

                    productList.add(product);
                }
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }

        return productList;
    }
    public Product getProductByID(int id){
        String query = "SELECT * FROM products WHERE productId = ?";
        Product product = new Product();

        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, id);

            try(ResultSet set = preparedStatement.executeQuery()){
                while(set.next()){
                    product = new Product(
                            set.getInt("ProductID"),
                            set.getString("ProductName"),
                            set.getInt("SupplierID"),
                            set.getInt("CategoryID"),
                            set.getString("QuantityPerUnit"),
                            set.getDouble("UnitPrice"),
                            set.getInt("UnitsInStock"),
                            set.getInt("UnitsInOrder"),
                            set.getInt("ReorderLevel"),
                            set.getBoolean("Discontinued")
                    );
                }
            }
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

        return product;
    }

    //CREATE
    public void createProduct(Product product){
        String query = "INSERT INTO products (ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued)" +
                       "VALUES(?,?,?,?,?,?,?,?,?)";

        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setInt(2, product.getSupplierID());
            preparedStatement.setInt(3, product.getCategoryID());
            preparedStatement.setString(4, product.getQuantityPerUnit());
            preparedStatement.setDouble(5, product.getUnitPrice());
            preparedStatement.setInt(6, product.getUnitsInStock());
            preparedStatement.setInt(7, product.getUnitsOnOrder());
            preparedStatement.setInt(8, product.getReorderLevel());
            preparedStatement.setBoolean(9, product.isDiscontinued());

            //Notice how this part is a bit different
            int rows = preparedStatement.executeUpdate();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    public  void deleteProduct(int productId){
        String sqlQuery = "DELETE FROM products WHERE productID = ?";

        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){

            preparedStatement.setInt(1, productId);

            int rows = preparedStatement.executeUpdate();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
