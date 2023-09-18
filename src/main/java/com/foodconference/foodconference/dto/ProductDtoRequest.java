package com.foodconference.foodconference.dto;

import lombok.Data;

@Data
public class ProductDtoRequest {
    private Long id;
    private String name;
    private String description;
    private Double unitMeasure;
    private Long categoryId;
    private Double price;
}
