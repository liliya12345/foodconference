package com.foodconference.foodconference.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDto {
    private Long id;
    private ProductDtoResponse product;
    private Double quantity;
    private CourierDtoResponse courier;
}
