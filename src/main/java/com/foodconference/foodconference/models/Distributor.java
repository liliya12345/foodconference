package com.foodconference.foodconference.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "distributors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Distributor extends User {
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "distributor")
    private List<Product> productList = new ArrayList<>();
    @Column(name="approved")
    private Boolean approved;
}
