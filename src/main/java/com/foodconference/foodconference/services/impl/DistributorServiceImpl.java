package com.foodconference.foodconference.services.impl;

import com.foodconference.foodconference.dto.DistributorDtoResponse;
import com.foodconference.foodconference.dto.UserRegistrationDto;
import com.foodconference.foodconference.models.Distributor;
import com.foodconference.foodconference.models.UserRole;
import com.foodconference.foodconference.repositories.DistributorRepository;
import com.foodconference.foodconference.services.DistributorService;
import com.foodconference.foodconference.transformers.DistributorToDistributorDtoResponseTransformer;
import com.foodconference.foodconference.transformers.UserRegistrationDtoToDistributorTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class DistributorServiceImpl implements DistributorService {
    private final DistributorRepository distributorRepository;
    private final PasswordEncoder passwordEncoder;
    private final DistributorToDistributorDtoResponseTransformer distributorToDistributorDtoResponseTransformer;
    private final UserRegistrationDtoToDistributorTransformer userRegistrationDtoToDistributorTransformer;

    @Override
    public DistributorDtoResponse createDistributor(UserRegistrationDto distributor) {
        Distributor newDistributor = userRegistrationDtoToDistributorTransformer.transform(distributor);
        newDistributor.setPassword(passwordEncoder.encode(newDistributor.getPassword()));
        newDistributor.getUserRoles().add(UserRole.ROLE_DISTRIBUTOR);
        newDistributor.setApproved(false);
        return distributorToDistributorDtoResponseTransformer
                .transform(distributorRepository.save(newDistributor));
    }

    @Override
    public Page<DistributorDtoResponse> getAllDistributors(Pageable pageable) {
        Page<Distributor> pageDistributors = distributorRepository.findAll(pageable);
        return pageDistributors.map(distributorToDistributorDtoResponseTransformer::transform);
    }

    @Override
    public Boolean approved(Long distributorId) {
        Optional<Distributor> byId = distributorRepository.findById(distributorId);
        if (byId.isPresent()) {
            Distributor distributor = byId.get();
            distributor.setApproved(true);
            distributorRepository.save(distributor);
            return true;
        }
        return false;

    }

    @Override
    public DistributorDtoResponse getById(Long distributorId) {
        Distributor distributor = distributorRepository.findById(distributorId).orElse(new Distributor());
        return distributorToDistributorDtoResponseTransformer.transform(distributor);
    }

    @Override
    public boolean disapproved(Long distributorId) {
        Optional<Distributor> byId = distributorRepository.findById(distributorId);
        if (byId.isPresent()) {
            Distributor distributor = byId.get();
            distributor.setApproved(false);
            distributorRepository.save(distributor);
            return true;
        }
        return false;
    }


}
