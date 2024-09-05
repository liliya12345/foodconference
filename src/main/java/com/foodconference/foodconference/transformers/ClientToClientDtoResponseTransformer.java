package com.foodconference.foodconference.transformers;
import com.foodconference.foodconference.dto.ClientDtoResponse;
import com.foodconference.foodconference.models.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientToClientDtoResponseTransformer extends Transformer<ClientDtoResponse, Client> {
    @Override
    public ClientDtoResponse transform(Client client) {
        ClientDtoResponse clientDtoResponse = new ClientDtoResponse();
        clientDtoResponse.setId(client.getId());
        clientDtoResponse.setName(client.getName());
        clientDtoResponse.setUsername(client.getUsername());
        clientDtoResponse.setRoleSet(client.getUserRoles());
        clientDtoResponse.setUserContactList(client.getUserContactList());
        return clientDtoResponse;
    }
}
