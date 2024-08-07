package com.redua.apidelivery.repositories;

import com.redua.apidelivery.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findAllByOrderByNameAsc();
}
