package com.foodconference.foodconference.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column(name = "unit_measure")
    private Double unitMeasure;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private CategoryProduct category;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Distributor distributor;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "product")
    private List<Price> priceList = new ArrayList<>();

}
