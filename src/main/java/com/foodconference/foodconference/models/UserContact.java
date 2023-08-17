package com.foodconference.foodconference.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_contacts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "contact_info")
    private String contactInfo;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private User user;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private ContactType contactType;
}
