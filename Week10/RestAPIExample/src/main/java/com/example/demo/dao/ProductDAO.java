package com.example.demo.dao;

import com.example.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Integer> {
    public Product getProductByName(String name);

    @Query(value = "SELECT * FROM product WHERE category_id=:id", nativeQuery = true)
    public List<Product> getProductByCategoryId(@Param("id") int id);
}
