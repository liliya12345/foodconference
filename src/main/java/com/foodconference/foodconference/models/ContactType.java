package com.foodconference.foodconference.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contact_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type_contact")
    private String typeContact;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactType")
    private List<UserContact> userContactList = new ArrayList<>();


}
