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

import java.util.Optional;

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
                .transform(courierRepository.save(newCourier));

    }

    @Override
    public boolean approved(Long courierId) {
        Optional<Courier> byId = courierRepository.findById(courierId);
        if (byId.isPresent()) {
            Courier courier = byId.get();
            courier.setApproved(true);
            courierRepository.save(courier);
            return true;
        }
        return false;
    }


    @Override
    public boolean disapproved(Long courierId) {
        Optional<Courier> byId = courierRepository.findById(courierId);
        if (byId.isPresent()) {
            Courier courier = byId.get();
            courier.setApproved(false);
            courierRepository.save(courier);
            return true;
        }
        return false;
    }

    @Override
    public CourierDtoResponse getById(Long courierId) {
        Courier courier = courierRepository.findById(courierId).orElse(new Courier());
        return courierToCourierDtoResponseTransformer.transform(courier);
    }


}
