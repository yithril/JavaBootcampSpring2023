package com.example.demo.services;

import com.example.demo.dao.ProductDAO;
import com.example.demo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductDAO productDAO;

    @Autowired
    public ProductService(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    public List<Product> getAllProducts(){
        return this.productDAO.findAll();
    }
}
