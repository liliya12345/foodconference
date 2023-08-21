package com.foodconference.foodconference.services.impl;

import com.foodconference.foodconference.dto.DistributorDtoResponse;
import com.foodconference.foodconference.models.Distributor;
import com.foodconference.foodconference.models.UserRole;
import com.foodconference.foodconference.repositories.DistributorRepository;
import com.foodconference.foodconference.services.DistributorService;
import com.foodconference.foodconference.transformers.DistributorToDistributorDtoResponseTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DistributorServiceImpl implements DistributorService {
    private final DistributorRepository distributorRepository;
    private final PasswordEncoder passwordEncoder;
    private final DistributorToDistributorDtoResponseTransformer distributorToDistributorDtoResponseTransformer;

    @Override
    public DistributorDtoResponse createDistributor(Distributor distributor) {
        distributor.setPassword(passwordEncoder.encode(distributor.getPassword()));
        distributor.getUserRoles().add(UserRole.ROLE_DISTRIBUTOR);
        return distributorToDistributorDtoResponseTransformer
                .transformDistributor(distributorRepository.save(distributor));
    }
}
