package com.redua.apidelivery.services;

import com.redua.apidelivery.dto.OrderDTO;
import com.redua.apidelivery.dto.ProductDTO;
import com.redua.apidelivery.entities.Order;
import com.redua.apidelivery.entities.OrderStatus;
import com.redua.apidelivery.entities.Product;
import com.redua.apidelivery.exceptions.ResourceNotFoundException;
import com.redua.apidelivery.repositories.OrderRepository;
import com.redua.apidelivery.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        List<Order> listOrders = orderRepository.findOrdersWithProducts();
        return listOrders.stream().map(OrderDTO::new).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public OrderDTO findById(UUID uuid){
        Optional<Order> obj = orderRepository.findById(uuid);
        Order order = obj.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado, uuid: " + uuid));
        return new OrderDTO(order);
    }
    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(),
                Instant.now(), OrderStatus.PENDING);
        for (ProductDTO p : dto.getProducts()){
            Product product = productRepository.getReferenceById(p.getId_product());
            order.getProducts().add(product);
        }
        order = orderRepository.save(order);
        return new OrderDTO(order);
    }
    @Transactional
    public OrderDTO setDelivered(UUID uuid){
        try {
            Order order = orderRepository.getReferenceById(uuid);
            order.setStatus(OrderStatus.DELIVERED);
            order = orderRepository.save(order);
            return new OrderDTO(order);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Objeto não encontrado, uuid: " + uuid);
        }
    }
    @Transactional
    public OrderDTO setPaid(UUID uuid){
        try {
            Order order = orderRepository.getReferenceById(uuid);
            order.setStatus(OrderStatus.PAID);
            order = orderRepository.save(order);
            return new OrderDTO(order);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Objeto não encontrado, uuid: " + uuid);
        }
    }
}
