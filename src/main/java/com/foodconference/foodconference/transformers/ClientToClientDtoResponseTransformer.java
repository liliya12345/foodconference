package com.foodconference.foodconference.transformers;

import com.foodconference.foodconference.dto.ClientDtoResponce;
import com.foodconference.foodconference.models.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientToClientDtoResponseTransformer {
   public ClientDtoResponce transformClient(Client client){
        ClientDtoResponce clientDtoResponce = new ClientDtoResponce();
        clientDtoResponce.setId(client.getId());
        clientDtoResponce.setName(client.getName());
        clientDtoResponce.setRoleSet(client.getUserRoles());
        clientDtoResponce.setUserContactList(client.getUserContactList());
        return clientDtoResponce;
    }
}
