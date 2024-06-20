package com.jpa.crud.practice.service;

import com.jpa.crud.practice.dto.ProductDto;
import com.jpa.crud.practice.entity.Product;
import java.util.List;

public interface ProductService {

    public ProductDto saveProduct(ProductDto productDto);

    public List<ProductDto> saveProducts(List<Product> products);

    public ProductDto getProductById(int id);

    public ProductDto getProductByName(String name);

    public ProductDto getProductByIdAndName(int id, String name);

    public String deleteProductById(int id);

    public List<ProductDto> getProducts();

    public ProductDto updateProduct(ProductDto productDto);
}
