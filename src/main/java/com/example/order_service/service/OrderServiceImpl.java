package com.example.order_service.service;

import com.example.order_service.dto.OrderDto;
import com.example.order_service.entity.OrderEntity;
import com.example.order_service.entity.OrderRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Getter
@Setter
@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public OrderDto createOrder(OrderDto orderDto) {

        orderDto.setOrderId(UUID.randomUUID().toString());
        orderDto.setTotalPrice(orderDto.getQuantity() * orderDto.getUnitPrice());

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        OrderEntity orderEntity = mapper.map(orderDto, OrderEntity.class);

        orderRepository.save(orderEntity);
        return mapper.map(orderEntity, OrderDto.class);
    }

    @Override
    public OrderDto getOrderByOrderId(String orderId) {
        OrderEntity orderEntity = orderRepository.findByOrderId(orderId);
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper.map(orderEntity, OrderDto.class);
    }

    @Override
    public Iterable<OrderEntity> getOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }
}
