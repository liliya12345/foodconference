package com.foodconference.foodconference.services;

import com.foodconference.foodconference.dto.DistributorDtoResponse;
import com.foodconference.foodconference.models.Distributor;

public interface DistributorService {
    DistributorDtoResponse createDistributor(Distributor distributor);
}
