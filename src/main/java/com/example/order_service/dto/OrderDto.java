package com.example.order_service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class OrderDto implements Serializable {

    private String productId;
    private Integer quantity;
    private Integer unitPrice;
    private Integer totalPrice;

    private String orderId;
    private String userId;
}
