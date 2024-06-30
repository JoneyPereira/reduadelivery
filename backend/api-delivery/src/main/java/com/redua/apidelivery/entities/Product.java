package com.redua.apidelivery.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_product;

    private String name;
    private Double price;
    private String description;
    private String imageuri;
}
