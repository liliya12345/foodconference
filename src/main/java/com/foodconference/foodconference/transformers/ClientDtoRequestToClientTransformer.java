package com.foodconference.foodconference.transformers;

import com.foodconference.foodconference.dto.ClientDtoRequest;
import com.foodconference.foodconference.models.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientDtoRequestToClientTransformer {
    public Client transform(ClientDtoRequest clientDtoRequest) {
        Client newClient = new Client();
        newClient.setId(clientDtoRequest.getId());
        newClient.setPassword(clientDtoRequest.getPassword());
        newClient.setUsername(clientDtoRequest.getUsername());
        newClient.setName(clientDtoRequest.getName());
        return newClient;
    }
}
