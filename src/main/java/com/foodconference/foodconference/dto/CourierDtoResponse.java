package com.foodconference.foodconference.dto;

import com.foodconference.foodconference.models.UserContact;
import com.foodconference.foodconference.models.UserRole;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class CourierDtoResponse {
    private Long id;
    private String name;
    private String username;
    private Boolean approved;
    private Set<UserRole> roleSet = new HashSet<>();
    private List<UserContact> userContactList = new ArrayList<>();
}
