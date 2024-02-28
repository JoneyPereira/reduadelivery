package com.redua.apidelivery.repositories;

import com.redua.apidelivery.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findAllByOrderByNameAsc();
}