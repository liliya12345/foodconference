package com.foodconference.foodconference.services;

import com.foodconference.foodconference.dto.ClientDtoResponse;
import com.foodconference.foodconference.dto.UserRegistrationDto;

public interface ClientService {
    ClientDtoResponse createClient(UserRegistrationDto client);

}
