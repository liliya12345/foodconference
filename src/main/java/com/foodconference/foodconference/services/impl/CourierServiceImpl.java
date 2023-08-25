package com.foodconference.foodconference.services.impl;

import com.foodconference.foodconference.dto.CourierDtoResponse;
import com.foodconference.foodconference.models.Courier;
import com.foodconference.foodconference.models.UserRole;
import com.foodconference.foodconference.repositories.CourierRepository;
import com.foodconference.foodconference.services.CourierService;
import com.foodconference.foodconference.transformers.CourierToCourierDtoResponseTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourierServiceImpl implements CourierService {

    private final CourierRepository courierRepository;
    private final PasswordEncoder passwordEncoder;
    private final CourierToCourierDtoResponseTransformer courierToCourierDtoResponseTransformer;

    @Override
    public CourierDtoResponse createNewCourier(Courier courier) {
        courier.setPassword(passwordEncoder.encode(courier.getPassword()));
        courier.getUserRoles().add(UserRole.ROLE_COURIER);
        return courierToCourierDtoResponseTransformer
                .transformCourier(courierRepository.save(courier));

    }
}
