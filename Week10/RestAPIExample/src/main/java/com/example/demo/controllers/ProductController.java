package com.example.demo.controllers;

import com.example.demo.models.Product;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("api/product")
    public List<Product> getAllProducts(){
        return this.productService.getAllProducts();
    }
    @PostMapping("api/product")
    public Product createProduct(@RequestBody Product product){
        return this.productService.createProduct(product);
    }

    @GetMapping("api/product/{id}")
    public Product getProductById(@PathVariable int id){
        return this.productService.getProductById(id);
    }

    @GetMapping("api/product/name")
    public Product getProductByName(@RequestParam("name") String name){
        return this.productService.getProductByName(name);
    }

    @DeleteMapping("api/product/{id}")
    public void deleteProduct(@PathVariable int id){
        this.productService.deleteProduct(id);
    }

    @PutMapping("api/product/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable int id){
        return this.productService.updateProduct(product, id);
    }
}
