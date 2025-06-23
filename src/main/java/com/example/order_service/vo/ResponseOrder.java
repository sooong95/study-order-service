package com.example.order_service.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseOrder {

    private String productId;
    private Integer quantity;
    private Integer unitPrice;
    private Integer totalPrice;
    private LocalDateTime createdAt;

    private String orderId;
}
