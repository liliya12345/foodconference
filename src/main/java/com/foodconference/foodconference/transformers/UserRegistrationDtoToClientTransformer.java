package com.foodconference.foodconference.transformers;

import com.foodconference.foodconference.dto.UserRegistrationDto;
import com.foodconference.foodconference.models.Client;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationDtoToClientTransformer {
    public Client transform(UserRegistrationDto clientDtoRequest) {
        Client newClient = new Client();
        newClient.setId(clientDtoRequest.getId());
        newClient.setPassword(clientDtoRequest.getPassword());
        newClient.setUsername(clientDtoRequest.getUsername());
        newClient.setName(clientDtoRequest.getName());
        return newClient;
    }
}
