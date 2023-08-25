package com.foodconference.foodconference.dto;

import com.foodconference.foodconference.models.UserContact;
import com.foodconference.foodconference.models.UserRole;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class ClientDtoRequest {
    private Long id;
    @Size(min = 3, message = "The name must be more than 3 letters")
    private String name;
    @Size(min = 5, message = "The password must be more than 5 letters")
    private String password;
    @Size(min = 5, message = "The username must be more than 5 letters")
    private String username;


}
