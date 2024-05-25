package com.jpa.crud.practice.controller;

import com.jpa.crud.practice.entity.Product;
import com.jpa.crud.practice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }

    @GetMapping("/getProductById/{id}")
    public Product findProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    @GetMapping("/getProductByName/{name}")
    public Product findProductByName(@PathVariable String name){
        return service.getProductByName(name);
    }

    @GetMapping("/getProductByIdAndName/{id}/{name}")
    public Product getProductByIdAndName(@PathVariable int id, @PathVariable String name){
        return  service.getProductByIdAndName(id,name);
    }

    @GetMapping("/getAllProducts")
    public List<Product> findAllProducts(){
        return service.getProducts();
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProductById(id);
    }
}
