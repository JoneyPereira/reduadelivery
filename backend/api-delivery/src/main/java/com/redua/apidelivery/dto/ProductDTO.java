package com.redua.apidelivery.dto;

import com.redua.apidelivery.entities.Product;
import lombok.Data;

@Data
public class ProductDTO {

    private String id_product;
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
