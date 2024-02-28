package com.redua.apidelivery.services;

import com.redua.apidelivery.dto.ProductDTO;
import com.redua.apidelivery.entities.Product;
import com.redua.apidelivery.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        List<Product> listProcuts = productRepository.findAllByOrderByNameAsc();
        return listProcuts.stream().map(ProductDTO::new).collect(Collectors.toList());
    }
}
