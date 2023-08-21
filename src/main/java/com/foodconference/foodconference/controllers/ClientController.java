package com.foodconference.foodconference.controllers;

import com.foodconference.foodconference.dto.ClientDtoResponse;
import com.foodconference.foodconference.models.Client;
import com.foodconference.foodconference.services.impl.ClientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
    private final ClientServiceImpl clientService;
    @PostMapping("/create")
    public ResponseEntity<ClientDtoResponse> createNewClient(@RequestBody Client client){
        ClientDtoResponse newClient = clientService.createClient(client);
        return  ResponseEntity.ok(newClient);
    }
}
