package com.foodconference.foodconference.transformers;
import com.foodconference.foodconference.dto.UserRegistrationDto;
import com.foodconference.foodconference.models.Courier;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationDtoToCourierTransformer extends Transformer<Courier, UserRegistrationDto> {
    @Override
    public Courier transform(UserRegistrationDto courierDtoRequest) {
        Courier newCourier = new Courier();
        newCourier.setId(courierDtoRequest.getId());
        newCourier.setPassword(courierDtoRequest.getPassword());
        newCourier.setUsername(courierDtoRequest.getUsername());
        newCourier.setName(courierDtoRequest.getName());
        return newCourier;
    }
}
