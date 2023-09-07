package com.foodconference.foodconference.services.impl;

import com.foodconference.foodconference.dto.CourierDtoResponse;
import com.foodconference.foodconference.dto.UserRegistrationDto;
import com.foodconference.foodconference.models.Courier;
import com.foodconference.foodconference.models.UserRole;
import com.foodconference.foodconference.repositories.CourierRepository;
import com.foodconference.foodconference.services.CourierService;
import com.foodconference.foodconference.transformers.CourierToCourierDtoResponseTransformer;
import com.foodconference.foodconference.transformers.UserRegistrationDtoToCourierTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourierServiceImpl implements CourierService {

    private final CourierRepository courierRepository;
    private final PasswordEncoder passwordEncoder;
    private final CourierToCourierDtoResponseTransformer courierToCourierDtoResponseTransformer;
    private final UserRegistrationDtoToCourierTransformer userRegistrationDtoToCourierTransformer;

    @Override
    public CourierDtoResponse createNewCourier(UserRegistrationDto courier) {
        Courier newCourier = userRegistrationDtoToCourierTransformer.transform(courier);
        newCourier.setPassword(passwordEncoder.encode(newCourier.getPassword()));
        newCourier.getUserRoles().add(UserRole.ROLE_COURIER);
        newCourier.setApproved(false);
        return courierToCourierDtoResponseTransformer
                .transformCourier(courierRepository.save(newCourier));

    }
}
