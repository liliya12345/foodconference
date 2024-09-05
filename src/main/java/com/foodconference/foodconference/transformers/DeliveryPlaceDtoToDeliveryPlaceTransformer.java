package com.foodconference.foodconference.transformers;

import com.foodconference.foodconference.dto.DeliveryPlaceDto;
import com.foodconference.foodconference.models.Client;
import com.foodconference.foodconference.models.DeliveryPlace;
import com.foodconference.foodconference.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeliveryPlaceDtoToDeliveryPlaceTransformer extends Transformer<DeliveryPlace, DeliveryPlaceDto>{
   private final UserRepository userRepository;
    @Override
    public DeliveryPlace transform(DeliveryPlaceDto deliveryPlaceDto) {
        DeliveryPlace deliveryPlace= new DeliveryPlace();
//        deliveryPlace.setCity(deliveryPlaceDto.getCity());
        deliveryPlace.setStreet(deliveryPlaceDto.getStreet());
        deliveryPlace.setBuilding(deliveryPlaceDto.getBuilding());
        deliveryPlace.setDescription(deliveryPlaceDto.getDescription());
        deliveryPlace.setPostcode(deliveryPlaceDto.getPostcode());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String principal = (String) authentication.getPrincipal();
        Client client=(Client)userRepository.findByUsername(principal).orElse(null);
        deliveryPlace.setClient(client);
        return deliveryPlace;
    }
}
