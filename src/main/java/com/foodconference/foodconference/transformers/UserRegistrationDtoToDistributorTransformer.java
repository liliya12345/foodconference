package com.foodconference.foodconference.transformers;
import com.foodconference.foodconference.dto.UserRegistrationDto;
import com.foodconference.foodconference.models.Distributor;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationDtoToDistributorTransformer extends Transformer<Distributor, UserRegistrationDto> {
    @Override
    public Distributor transform(UserRegistrationDto distributorDtoRequest) {
        Distributor newDistributor = new Distributor();
        newDistributor.setId(distributorDtoRequest.getId());
        newDistributor.setPassword(distributorDtoRequest.getPassword());
        newDistributor.setUsername(distributorDtoRequest.getUsername());
        newDistributor.setName(distributorDtoRequest.getName());
        return newDistributor;
    }
}
