package com.foodconference.foodconference.services.impl;

import com.foodconference.foodconference.dto.OrderDto;
import com.foodconference.foodconference.models.DeliveryPlace;
import com.foodconference.foodconference.models.Order;
import com.foodconference.foodconference.repositories.DeliveryPlaceRepository;
import com.foodconference.foodconference.repositories.OrderRepository;
import com.foodconference.foodconference.services.OrderService;
import com.foodconference.foodconference.transformers.DeliveryPlaceDtoToDeliveryPlaceTransformer;
import com.foodconference.foodconference.transformers.OrderDtoToOrderTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderDtoToOrderTransformer orderDtoToOrderTransformer;
    private final DeliveryPlaceRepository deliveryPlaceRepository;
    private final OrderRepository orderRepository;
    private final DeliveryPlaceDtoToDeliveryPlaceTransformer deliveryPlaceDtoToDeliveryPlaceTransformer;
    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        DeliveryPlace place = deliveryPlaceDtoToDeliveryPlaceTransformer.transform(orderDto.getDeliveryPlace());
        DeliveryPlace save = deliveryPlaceRepository.save(place);
        Order transform = orderDtoToOrderTransformer.transform(orderDto);
        transform.setDeliveryPlace(save);
        orderRepository.save(transform);
        return null;
    }
}
