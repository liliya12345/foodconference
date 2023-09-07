package com.foodconference.foodconference.services;

import com.foodconference.foodconference.dto.DistributorDtoResponse;
import com.foodconference.foodconference.dto.UserRegistrationDto;
import com.foodconference.foodconference.models.Distributor;
import com.foodconference.foodconference.repositories.DistributorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DistributorService {

    DistributorDtoResponse createDistributor(UserRegistrationDto distributor);
    Page<DistributorDtoResponse> getAllDistributors(Pageable pageable);

    DistributorDtoResponse approved(Long distributorId);
}
