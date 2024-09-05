package com.foodconference.foodconference.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "delivery_places")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private City city;
    private String street;
    private String building;
    private String postcode;
    private String description;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Client client;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Courier courier;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "deliveryPlace")
    private List<Order> orderList= new ArrayList<>();

}
