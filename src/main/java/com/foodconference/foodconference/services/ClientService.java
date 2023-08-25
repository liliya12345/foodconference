package com.foodconference.foodconference.services;

import com.foodconference.foodconference.dto.ClientDtoRequest;
import com.foodconference.foodconference.dto.ClientDtoResponse;
import com.foodconference.foodconference.models.Client;

public interface ClientService {
    ClientDtoResponse createClient(ClientDtoRequest client);

}
