package com.foodconference.foodconference.services.impl;

import com.foodconference.foodconference.dto.ClientDtoResponce;
import com.foodconference.foodconference.models.Client;
import com.foodconference.foodconference.models.UserRole;
import com.foodconference.foodconference.repositories.ClientRepository;
import com.foodconference.foodconference.services.ClientService;
import com.foodconference.foodconference.transformers.ClientToClientDtoResponseTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;
    private final ClientToClientDtoResponseTransformer clientToClientDtoResponseTransformer;
    @Override
    public ClientDtoResponce createClient(Client client) {
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        client.getUserRoles().add(UserRole.ROLE_CLIENT);
        Client newClient = clientRepository.save(client);
        return clientToClientDtoResponseTransformer.transformClient(newClient);
    }
}
