package com.foodconference.foodconference.services;
import com.foodconference.foodconference.dto.DistributorDtoResponse;
import com.foodconference.foodconference.dto.UserRegistrationDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface DistributorService {

    DistributorDtoResponse createDistributor(UserRegistrationDto distributor);

    Page<DistributorDtoResponse> getAllDistributors(Pageable pageable);

    Boolean approved(Long distributorId);

    DistributorDtoResponse getById(Long distributorId);

    boolean disapproved(Long distributorId);
}
