package com.foodconference.foodconference.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusDto {
    private Long id;
    private LocalDateTime dateChangeStatus;
}
