package com.jpa.crud.practice.service;

import com.jpa.crud.practice.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jpa.crud.practice.repository.ProductRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product saveProduct(Product product){
        return productRepo.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return productRepo.saveAll(products);
    }

    public List<Product> getProducts(){
        return productRepo.findAll();
    }

    public Product getProductById(int id){
        return productRepo.findById(id).orElse(null);
    }

    public Product getProductByName(String name){
        return productRepo.findByName(name);
    }

    public Product getProductByIdAndName(int id, String name){
        return productRepo.findByIdAndName(id,name);
    }

    public String deleteProductById(int id) {
        productRepo.deleteById(id);
        return "Product removed with id:" + id;
    }

    public Product updateProduct(Product product) {
        Optional prodOptional =  productRepo.findById(product.getId());
        Product existingProduct = (Product) prodOptional.get();
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return productRepo.save(existingProduct);
    }
}
