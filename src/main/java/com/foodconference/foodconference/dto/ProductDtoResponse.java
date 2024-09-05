package com.foodconference.foodconference.dto;

import lombok.Data;

@Data
public class ProductDtoResponse {
    private Long id;
    private String name;
    private String description;
    private Double unitMeasure;
    private CategoryProductsDtoResponse categoryProductsDtoResponse;
    private Double price;
}
