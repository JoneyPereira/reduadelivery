package com.redua.apidelivery.dto;

import com.redua.apidelivery.entities.Product;
import lombok.Data;

import java.util.UUID;

@Data
public class ProductDTO {

    private UUID id_product;
    private String name;
    private Double price;
    private String description;
    private String imageUri;

    public ProductDTO(Product entity) {
        id_product = entity.getId_product();
        name = entity.getName();
        price = entity.getPrice();
        description = entity.getDescription();
        imageUri = entity.getImageuri();
    }
}
