package com.foodconference.foodconference.models;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMIN,
    ROLE_DISTRIBUTOR,
    ROLE_COURIER,
    ROLE_CLIENT;



    @Override
    public String getAuthority() {
        return name();
    }
}
