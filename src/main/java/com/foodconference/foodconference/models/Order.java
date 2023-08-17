package com.foodconference.foodconference.models;

import com.foodconference.foodconference.models.enums.LifeStatusOfOrder;
import com.foodconference.foodconference.models.enums.PaymentForm;
import com.foodconference.foodconference.models.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Client client;
    private LocalDateTime createDateOfOrder;
    private LocalDateTime deliveryDateOfOrder;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderDetails> orderDetailsList = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.REFRESH)
    private DeliveryPlace deliveryPlace;
    private LocalDate paymentDateFact;
    private LocalDate paymentDateOnSchedule;
    private LifeStatusOfOrder lifeStatusOfOrder;
    private PaymentForm paymentForm;
    private PaymentStatus paymentStatus;

}
