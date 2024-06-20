package com.jpa.crud.practice.controller;

import com.jpa.crud.practice.dto.ProductDto;
import com.jpa.crud.practice.entity.Product;
import com.jpa.crud.practice.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductServiceImpl service;

    @PostMapping("/add-product")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(service.saveProduct(productDto), HttpStatus.CREATED);
    }

    @PostMapping("/add-products")
    public ResponseEntity<List<ProductDto>> addProducts(@RequestBody List<Product> products){
        return ResponseEntity.ok(service.saveProducts(products));
    }

    @GetMapping("/get-product-byId/{id}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable int id){
        return ResponseEntity.ok(service.getProductById(id));
    }

    @GetMapping("/get-product-byName/{name}")
    public ResponseEntity<ProductDto> findProductByName(@PathVariable String name){
        return ResponseEntity.ok(service.getProductByName(name));
    }

    @GetMapping("/get-product-byIdAndName/{id}/{name}")
    public ResponseEntity<ProductDto> getProductByIdAndName(@PathVariable int id, @PathVariable String name){
        return  ResponseEntity.ok(service.getProductByIdAndName(id,name));
    }

    @GetMapping("/get-product-priceGreaterThan/{price}")
    public ResponseEntity<List<ProductDto>> getProductsHavingPriceGreaterThan(@PathVariable int price){
        return ResponseEntity.ok(service.havingPriceGreaterThan(price));
    }

    @GetMapping("/get-all-product")
    public List<ProductDto> findAllProducts(){
        return service.getProducts();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProductById(id);
    }

    @PutMapping("/update")
    public ProductDto updateProduct(@RequestBody ProductDto productDto){
        return service.updateProduct(productDto);
    }
}
