package com.foodconference.foodconference.controllers;

import com.foodconference.foodconference.dto.ClientDtoRequest;
import com.foodconference.foodconference.dto.ClientDtoResponse;
import com.foodconference.foodconference.dto.CourierDtoResponse;
import com.foodconference.foodconference.dto.DistributorDtoResponse;
import com.foodconference.foodconference.models.Client;
import com.foodconference.foodconference.models.Courier;
import com.foodconference.foodconference.models.Distributor;
import com.foodconference.foodconference.services.impl.ClientServiceImpl;
import com.foodconference.foodconference.services.impl.CourierServiceImpl;
import com.foodconference.foodconference.services.impl.DistributorServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/registration")
public class RegistrationController {
    private final ClientServiceImpl clientService;
    private final DistributorServiceImpl distributorService;
    private final CourierServiceImpl courierService;

    @PostMapping("/client")
    public ResponseEntity<?> createNewClient(@RequestBody @Valid ClientDtoRequest client, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            ClientDtoResponse newClient = clientService.createClient(client);
            log.info("Created a new client:" + newClient.getUsername());
            return ResponseEntity.ok(newClient);
        }
        Map<String,String> errors= new HashMap<>();
        errors = bindingResult.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage, (a, b) -> b));
          return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/distributor")
    public ResponseEntity<DistributorDtoResponse> createNewDistributor(@RequestBody Distributor distributor) {
        DistributorDtoResponse newDistributor = distributorService.createDistributor(distributor);
        log.info("Created a new client:" + newDistributor.getUsername());
        return ResponseEntity.ok(newDistributor);
    }

    @PostMapping("/courier")
    public ResponseEntity<CourierDtoResponse> createNewCourier(@RequestBody Courier courier) {
        CourierDtoResponse newCourier = courierService.createNewCourier(courier);
        log.info("Created a new client:" + newCourier.getUsername());
        return ResponseEntity.ok(newCourier);
    }

}
