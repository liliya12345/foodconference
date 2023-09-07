package com.foodconference.foodconference.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courier")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Courier extends User {
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courier")
    private List<OrderDetails> orderDetailsList = new ArrayList<>();
    @OneToMany(mappedBy = "courier")
    private List<DeliveryPlace> deliveryPlaceList = new ArrayList<>();
    @Column(name = "approved")
    private Boolean approved;
}
