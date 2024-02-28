package com.redua.apidelivery.services;

import com.redua.apidelivery.dto.OrderDTO;
import com.redua.apidelivery.dto.ProductDTO;
import com.redua.apidelivery.entities.Order;
import com.redua.apidelivery.entities.Product;
import com.redua.apidelivery.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        List<Order> listOrders = orderRepository.findAll();
        return listOrders.stream().map(OrderDTO::new).collect(Collectors.toList());
    }
}
