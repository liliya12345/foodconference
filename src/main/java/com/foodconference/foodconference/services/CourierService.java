package com.foodconference.foodconference.services;
import com.foodconference.foodconference.dto.CourierDtoResponse;
import com.foodconference.foodconference.dto.UserRegistrationDto;

public interface CourierService {
    CourierDtoResponse createNewCourier (UserRegistrationDto courier);

    boolean approved(Long courierId);

    boolean disapproved(Long courierId);

    CourierDtoResponse getById(Long courierId);
}
