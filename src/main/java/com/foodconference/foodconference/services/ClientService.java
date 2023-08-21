package com.foodconference.foodconference.services;

import com.foodconference.foodconference.dto.ClientDtoResponse;
import com.foodconference.foodconference.models.Client;

public interface ClientService {
    ClientDtoResponse createClient(Client client);

}
