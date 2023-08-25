package com.foodconference.foodconference.transformers;

import com.foodconference.foodconference.dto.ClientDtoResponse;
import com.foodconference.foodconference.models.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientToClientDtoResponseTransformer {
    public ClientDtoResponse transformClient(Client client) {
        ClientDtoResponse clientDtoResponce = new ClientDtoResponse();
        clientDtoResponce.setId(client.getId());
        clientDtoResponce.setName(client.getName());
        clientDtoResponce.setUsername(client.getUsername());
        clientDtoResponce.setRoleSet(client.getUserRoles());
        clientDtoResponce.setUserContactList(client.getUserContactList());
        return clientDtoResponce;
    }
}
