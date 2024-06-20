package com.jpa.crud.practice.service;

import com.jpa.crud.practice.dto.ProductDto;
import com.jpa.crud.practice.dtoMapper.DtoMapper;
import com.jpa.crud.practice.entity.Product;
import org.springframework.stereotype.Service;
import com.jpa.crud.practice.repository.ProductRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto){
        Product product = productRepo.save(DtoMapper.dtoToEntity(productDto));
        return DtoMapper.entityToDto(product);
    }

    @Override
    public List<ProductDto> saveProducts(List<Product> products){
        List<Product> prodList = productRepo.saveAll(products);
        List<ProductDto> productDtoList = new ArrayList<>();
        prodList.forEach(product -> productDtoList.add(DtoMapper.entityToDto(product)));
        return productDtoList;
    }

    @Override
    public ProductDto getProductById(int id){
        Product product = productRepo.findById(id).orElse(null);
        return product == null ? null : DtoMapper.entityToDto(product);
    }

    @Override
    public ProductDto getProductByName(String name){
        Product product = productRepo.findByName(name);
        return product == null ? null : DtoMapper.entityToDto(product);
    }

    @Override
    public ProductDto getProductByIdAndName(int id, String name){
        Product product = productRepo.findByIdAndName(id,name);
        return product == null ? null : DtoMapper.entityToDto(product);
    }

    @Override
    public List<ProductDto> havingPriceGreaterThan(int price) {
        List<Product> productList = productRepo.findByPriceGreaterThan(price);
        List<ProductDto> productDtoList = new ArrayList<>();
        productList.forEach(product -> productDtoList.add(DtoMapper.entityToDto(product)));
        return productDtoList;
    }

    @Override
    public List<ProductDto> getProducts(){
        List<Product> prodList = productRepo.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();
        prodList.forEach(product -> productDtoList.add(DtoMapper.entityToDto(product)));
        return productDtoList;
    }

    @Override
    public String deleteProductById(int id) {
        productRepo.deleteById(id);
        return "Product removed with id:" + id;
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        Product product = DtoMapper.dtoToEntity(productDto);
        Product existingProduct =  productRepo.findById(product.getId()).orElseThrow();
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return DtoMapper.entityToDto(productRepo.save(existingProduct));
    }
}
