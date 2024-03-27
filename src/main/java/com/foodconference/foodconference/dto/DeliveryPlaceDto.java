package com.foodconference.foodconference.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryPlaceDto {
    private Long id;
    private String city;
    private String street;
    private String building;
    private String postcode;
    private String description;
}
