package com.foodconference.foodconference.dto;

import com.foodconference.foodconference.models.Courier;
import com.foodconference.foodconference.models.Order;
import com.foodconference.foodconference.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDto {
    private Long id;
    private ProductDtoResponse product;
    private Double quantity;
    private CourierDtoResponse courier;
}
