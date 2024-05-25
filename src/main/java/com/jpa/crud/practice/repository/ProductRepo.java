package com.jpa.crud.practice.repository;

import com.jpa.crud.practice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductRepo extends JpaRepository<Product,Integer> {
    Product findByName(String name);

    Product findByIdAndName(int id, String name);
}
