package com.foodconference.foodconference.services;

import com.foodconference.foodconference.models.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);

}
