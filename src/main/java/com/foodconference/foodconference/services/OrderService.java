package com.foodconference.foodconference.services;

import com.foodconference.foodconference.dto.OrderDto;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);
}
