package com.foodconference.foodconference.controllers;

import com.foodconference.foodconference.dto.ClientDtoResponse;
import com.foodconference.foodconference.dto.CourierDtoResponse;
import com.foodconference.foodconference.dto.DistributorDtoResponse;
import com.foodconference.foodconference.dto.UserRegistrationDto;
import com.foodconference.foodconference.services.impl.ClientServiceImpl;
import com.foodconference.foodconference.services.impl.CourierServiceImpl;
import com.foodconference.foodconference.services.impl.DistributorServiceImpl;
import com.foodconference.foodconference.validators.UserRegistrationValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
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
    private final UserRegistrationValidator userRegistrationValidator;

    @PostMapping("/client")
    public ResponseEntity<?> createNewClient(@RequestBody @Valid UserRegistrationDto client, BindingResult bindingResult) {
        userRegistrationValidator.validate(client,bindingResult);
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
    public ResponseEntity<?> createNewDistributor(@RequestBody @Valid UserRegistrationDto distributor, BindingResult bindingResult) {
        userRegistrationValidator.validate(distributor,bindingResult);
        if (!bindingResult.hasErrors()) {
            DistributorDtoResponse newDistributor = distributorService.createDistributor(distributor);
            log.info("Created a new distributor:" + newDistributor.getUsername());
            return ResponseEntity.ok(newDistributor);
        }
        Map<String,String> errors= new HashMap<>();
        errors = bindingResult.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage, (a, b) -> b));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/courier")
    public ResponseEntity<?> createNewCourier(@RequestBody @Valid UserRegistrationDto courier,BindingResult bindingResult) {
        userRegistrationValidator.validate(courier,bindingResult);
        if (!bindingResult.hasErrors()) {
            CourierDtoResponse newCourier = courierService.createNewCourier(courier);
            log.info("Created a new courier:" + newCourier.getUsername());
            return ResponseEntity.ok(newCourier);
        }
        Map<String,String> errors= new HashMap<>();
        errors = bindingResult.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage, (a, b) -> b));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
