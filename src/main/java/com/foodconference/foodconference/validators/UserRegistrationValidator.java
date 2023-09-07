package com.foodconference.foodconference.validators;

import com.foodconference.foodconference.dto.UserRegistrationDto;
import com.foodconference.foodconference.models.User;
import com.foodconference.foodconference.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserRegistrationValidator implements Validator {
private final UserRepository userRepository;
    @Override
    public boolean supports(Class<?> clazz) {
        return UserRegistrationDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserRegistrationDto userRegistrationDto= (UserRegistrationDto) target;
        Optional<User> byUsername = userRepository.findByUsername(userRegistrationDto.getUsername());
        if(byUsername.isPresent()){
            errors.rejectValue("username","NOT DIFFERENT","This username is exist!");
        }


    }
}
