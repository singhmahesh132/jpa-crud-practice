package com.jpa.crud.practice.dtoMapper;

import com.jpa.crud.practice.dto.ProductDto;
import com.jpa.crud.practice.entity.Product;

public class DtoMapper {

    public static Product dtoToEntity(ProductDto productDto){
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getQuantity(),
                productDto.getPrice()
        );
    }

    public static ProductDto entityToDto(Product product){
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getQuantity(),
                product.getPrice()
        );
    }
}
