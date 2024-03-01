package com.redua.apidelivery.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.redua.apidelivery.entities.Order;
import com.redua.apidelivery.entities.OrderStatus;
import com.redua.apidelivery.entities.Product;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Jacksonized
@Builder
@Data
public class OrderDTO {

    private UUID id_order;
    private String address;
    private Double latitude;
    private Double longitude;
    private Instant moment;
    private OrderStatus status;

    private List<ProductDTO> products = new ArrayList<>();


    public OrderDTO() {
    }

    public OrderDTO(UUID id_order, String address, Double latitude, Double longitude, Instant moment, OrderStatus status, List<ProductDTO> products) {
        this.id_order = id_order;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.moment = moment;
        this.status = status;
        this.products = products;
    }

    public OrderDTO(Order entity) {
        id_order = entity.getId_order();
        address = entity.getAddress();
        latitude = entity.getLatitude();
        longitude = entity.getLatitude();
        moment = entity.getMoment();
        status = entity.getStatus();
        products = entity.getProducts().stream()
                .map(ProductDTO::new).collect(Collectors.toList());
    }
}
