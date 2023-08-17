package com.foodconference.foodconference.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category_menu")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryMenu {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "category_name")
    private String categoryName;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
    private List<Product> productList= new ArrayList<>();

}
