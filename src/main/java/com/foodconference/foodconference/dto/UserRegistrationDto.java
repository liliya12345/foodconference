package com.foodconference.foodconference.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserRegistrationDto {
    private Long id;
    @Size(min = 3, message = "The name must be more than 2 letters")
    private String name;
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%&?*]).{6,20})", message = "The password must contains : one digit from 0-9,one " +
            "lowercase characters, one lowercase characters" + "one uppercase characters" + " one special symbols in the list !@#$%&?*" +
            "  and  length at least 6 characters and maximum of 20")
    private String password;
    @Size(min = 5, message = "The username must be more than 4 letters")
    private String username;
    private String address;
    private Integer zipcode;
    private String city;
    private String contact_person_name;
    private String contact_person_surname;
    private String email;
    private Integer phone;
    private Boolean isCompany;
//    private MultipartFile multipartFile;

}
