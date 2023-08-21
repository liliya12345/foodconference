package com.foodconference.foodconference.transformers;

import com.foodconference.foodconference.dto.DistributorDtoResponse;
import com.foodconference.foodconference.models.Distributor;
import org.springframework.stereotype.Component;

@Component
public class DistributorToDistributorDtoResponseTransformer {
    public DistributorDtoResponse transformDistributor(Distributor distributor) {
        DistributorDtoResponse distributorDtoResponse = new DistributorDtoResponse();
        distributorDtoResponse.setId(distributor.getId());
        distributorDtoResponse.setName(distributor.getName());
        distributorDtoResponse.setUsername(distributor.getUsername());
        distributorDtoResponse.setRoleSet(distributor.getUserRoles());
        distributorDtoResponse.setUserContactList(distributor.getUserContactList());
        return distributorDtoResponse;
    }
}
