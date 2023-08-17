package com.foodconference.foodconference.dto;

import com.foodconference.foodconference.models.UserContact;
import com.foodconference.foodconference.models.UserRole;
import lombok.Data;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
public class ClientDtoResponce {
    private Long id;
    private String name;
    private Set<UserRole> roleSet= new HashSet<>();
    private List<UserContact> userContactList= new ArrayList<>();

}
