package com.redua.apidelivery.services;

import com.redua.apidelivery.dto.ProductDTO;
import com.redua.apidelivery.entities.Product;
import com.redua.apidelivery.exceptions.DatabaseException;
import com.redua.apidelivery.exceptions.ResourceNotFoundException;
import com.redua.apidelivery.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
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

    @Transactional
    public ProductDTO update(UUID uuid, ProductDTO dto){
        try {
            Product entity = productRepository.getReferenceById(uuid);
            copyDtoToEntity(dto, entity);
            entity = productRepository.save(entity);
            return new ProductDTO(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Objeto não encontrado, uuid: " + uuid);
        }
    }

    public void delete(UUID uuid){
        try {
            productRepository.deleteById(uuid);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Objeto não encontrado, uuid: " + uuid);
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException("Violação de integridade!");
        }
    }

    private void copyDtoToEntity(ProductDTO dto, Product entity){
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
    }
}
