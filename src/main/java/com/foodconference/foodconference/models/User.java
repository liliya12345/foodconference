package com.foodconference.foodconference.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;
    @Column(unique = true)
    private String username;
    @Column
    private String password;
    @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    private Set<UserRole> userRoles = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserContact> userContactList = new ArrayList<>();


}
