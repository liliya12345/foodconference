package com.foodconference.foodconference.services.impl;

import com.foodconference.foodconference.dto.ClientDtoResponse;
import com.foodconference.foodconference.dto.UserRegistrationDto;
import com.foodconference.foodconference.models.Client;
import com.foodconference.foodconference.models.UserRole;
import com.foodconference.foodconference.repositories.ClientRepository;
import com.foodconference.foodconference.services.ClientService;
import com.foodconference.foodconference.transformers.ClientToClientDtoResponseTransformer;
import com.foodconference.foodconference.transformers.UserRegistrationDtoToClientTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;
    private final ClientToClientDtoResponseTransformer clientToClientDtoResponseTransformer;
    private final UserRegistrationDtoToClientTransformer clientDtoRequestToClientTransformer;

    @Override
    public ClientDtoResponse createClient(UserRegistrationDto clientDtoRequest) {
        Client client = clientDtoRequestToClientTransformer.transform(clientDtoRequest);
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        client.setUsername(client.getUsername());
        client.getUserRoles().add(UserRole.ROLE_CLIENT);
        Client newClient = clientRepository.save(client);
        return clientToClientDtoResponseTransformer.transform(newClient);
    }
}
