package com.crudoperations;

import com.crudoperations.dao.Product;
import com.crudoperations.datamanager.ProductDAO;
import org.apache.commons.dbcp2.BasicDataSource;
public class Main {
    //Data management should be in its own class
    //Just like we separated the user interface from the data in your previous project
    //you should keep things separate here.
    public static void main(String[] args) {
        if(args.length !=2){
            System.out.println("Set up the username and password in IntelliJ before running");
            System.exit(1);
        }

        String password = args[1];
        String userName = args[0];

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setPassword(password);
        dataSource.setUsername(userName);
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");

        ProductDAO dao = new ProductDAO(dataSource);

        System.out.println("List out all products! For example!");

        Product product = new Product();
        product.setProductName("Nutella");
        product.setDiscontinued(false);
        product.setCategoryID(3);
        product.setSupplierID(8);
        product.setUnitsInStock(100);
        product.setQuantityPerUnit("100 per box");
        product.setReorderLevel(20);
        product.setUnitPrice(2.5);
        product.setUnitsOnOrder(50);

        dao.createProduct(product);

        var productList = dao.getAllProducts();

        for(Product p : productList){
            System.out.println(p.getProductName());
        }
    }
}
