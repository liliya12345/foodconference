package com.foodconference.foodconference.services;

import com.foodconference.foodconference.dto.ClientDtoResponce;
import com.foodconference.foodconference.models.Client;

public interface ClientService {
    ClientDtoResponce createClient(Client client);

}
