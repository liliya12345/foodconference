package com.foodconference.foodconference.transformers;
import com.foodconference.foodconference.dto.CourierDtoResponse;
import com.foodconference.foodconference.models.Courier;
import org.springframework.stereotype.Component;

@Component
public class CourierToCourierDtoResponseTransformer extends Transformer<CourierDtoResponse, Courier> {
    @Override
    public CourierDtoResponse transform(Courier courier) {
        CourierDtoResponse courierDtoResponse = new CourierDtoResponse();
        courierDtoResponse.setId(courier.getId());
        courierDtoResponse.setName(courier.getName());
        courierDtoResponse.setUsername(courier.getUsername());
        courierDtoResponse.setApproved(courier.getApproved());
        courierDtoResponse.setRoleSet(courier.getUserRoles());
        courierDtoResponse.setUserContactList(courier.getUserContactList());
        return courierDtoResponse;
    }
}
