package com.foodconference.foodconference.transformers;

import com.foodconference.foodconference.dto.OrderDto;
import com.foodconference.foodconference.models.Client;
import com.foodconference.foodconference.models.Order;
import com.foodconference.foodconference.models.enums.LifeStatusOfOrder;
import com.foodconference.foodconference.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
@RequiredArgsConstructor
public class OrderDtoToOrderTransformer  extends  Transformer<Order, OrderDto>{
    private  final UserRepository userRepository;
    private  final  DeliveryPlaceDtoToDeliveryPlaceTransformer deliveryPlaceDtoToDeliveryPlaceTransformer;
    @Override
    public Order transform(OrderDto orderDto) {
        Order order = new Order();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String principal = (String) authentication.getPrincipal();
        Client client=(Client)userRepository.findByUsername(principal).orElse(null);
        order.setClient(client);
        order.setCreateDateOfOrder(LocalDateTime.now());order.setDeliveryDateOfOrder(orderDto.getDeliveryDateOfOrder());
        order.setLifeStatusOfOrder(LifeStatusOfOrder.NEW);
        order.setPaymentForm(orderDto.getPaymentForm());
//        order.setDeliveryPlace(deliveryPlaceDtoToDeliveryPlaceTransformer.transform(orderDto.getDeliveryPlace()));
        return  order;
    }
}
