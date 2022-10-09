package com.pharmacy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", unique = true)
    private Integer id;

    @Column(name = "email", length = 45, unique = true)
    private String email;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "name", length = 60)
    private String name;

    @Column(name = "role", length = 45)
    private String role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    @JsonBackReference(value = "user-address")
    private Address address;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference(value = "user-orders")
    private List<Order> orders = new ArrayList<>();

}
