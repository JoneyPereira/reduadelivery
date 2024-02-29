package com.redua.apidelivery.controllers;

import com.redua.apidelivery.dto.OrderDTO;
import com.redua.apidelivery.dto.ProductDTO;
import com.redua.apidelivery.services.OrderService;
import com.redua.apidelivery.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll(){
        List<OrderDTO> listOrders = orderService.findAll();
        return ResponseEntity.ok().body(listOrders);
    }
    @PostMapping
    public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO dto) {
        dto = orderService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uuid}")
                .buildAndExpand(dto.getId_order()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
