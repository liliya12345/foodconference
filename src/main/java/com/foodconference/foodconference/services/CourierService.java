package com.foodconference.foodconference.services;

import com.foodconference.foodconference.dto.ClientDtoResponse;
import com.foodconference.foodconference.dto.CourierDtoResponse;
import com.foodconference.foodconference.dto.UserRegistrationDto;
import com.foodconference.foodconference.models.Courier;

public interface CourierService {
    CourierDtoResponse createNewCourier (UserRegistrationDto courier);
}
