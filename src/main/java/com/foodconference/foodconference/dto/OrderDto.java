package com.foodconference.foodconference.dto;

import com.foodconference.foodconference.models.Client;
import com.foodconference.foodconference.models.DeliveryPlace;
import com.foodconference.foodconference.models.OrderDetails;
import com.foodconference.foodconference.models.OrderStatus;
import com.foodconference.foodconference.models.enums.LifeStatusOfOrder;
import com.foodconference.foodconference.models.enums.PaymentForm;
import com.foodconference.foodconference.models.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private LocalDateTime createDateOfOrder;
    private LocalDateTime deliveryDateOfOrder;
    private List<OrderDetailsDto> orderDetailsList = new ArrayList<>();
    private DeliveryPlaceDto deliveryPlace;
    private LocalDate paymentDateFact;
    private LocalDate paymentDateOnSchedule;
    private LifeStatusOfOrder lifeStatusOfOrder;
    private PaymentForm paymentForm;
    private PaymentStatus paymentStatus;
    private List<OrderStatus> orderStatusList = new ArrayList<>();
}
