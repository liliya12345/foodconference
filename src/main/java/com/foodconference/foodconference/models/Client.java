package com.foodconference.foodconference.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client extends User {
    @Column (name = "is_private")
    private Boolean isPrivate;
    @Column (name = "surname")
    private String surname;
    @Column (name = "address")
    private String address;
    @Column (name = "zipcode")
    private Integer zipcode;
    @Column
    private String name;
    @OneToMany(mappedBy = "client")
    private List<DeliveryPlace> deliveryPlaceList = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Order> orderList = new ArrayList<>();
}
