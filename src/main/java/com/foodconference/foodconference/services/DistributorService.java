package com.foodconference.foodconference.services;

import com.foodconference.foodconference.dto.DistributorDtoResponse;
import com.foodconference.foodconference.dto.UserRegistrationDto;
import com.foodconference.foodconference.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface DistributorService {

    DistributorDtoResponse createDistributor(UserRegistrationDto distributor);

    Page<DistributorDtoResponse> getAllDistributors(Pageable pageable);
    List<DistributorDtoResponse> getAllDistributors();

    Boolean approved(Long distributorId);

    DistributorDtoResponse getById(Long distributorId);

    boolean disapproved(Long distributorId);

    Boolean checkDistributorApprovedAndExist(Optional<User> user);
}
