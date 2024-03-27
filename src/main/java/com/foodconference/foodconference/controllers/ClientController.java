package com.foodconference.foodconference.controllers;

import com.foodconference.foodconference.dto.OrderDto;
import com.foodconference.foodconference.services.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
    private final OrderServiceImpl orderService;
    @PostMapping("/createOrder")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto){
    orderService.createOrder(orderDto);

    return null;
    //todo Return result;
    }

}
