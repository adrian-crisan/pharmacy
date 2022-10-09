package com.pharmacy.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id", unique = true)
    private Integer id;

    @Column(name = "street", length = 45)
    private String street;

    @Column(name = "number")
    private int number;

    @Column(name = "building", length = 45)
    private String building;

    @Column(name = "apartment", length = 45)
    private String apartment;

    @Column(name = "city", length = 45)
    private String city;

    @Column(name = "county", length = 45)
    private String county;

    @Column(name = "country", length = 45)
    private String country;

    @Column(name = "postal_code")
    private int postalCode;

    @OneToMany(
            mappedBy = "address",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference(value = "user-address")
    private List<User> users = new ArrayList<>();

    @OneToMany(
            mappedBy = "address",
            cascade = CascadeType.ALL,
             orphanRemoval = true
    )
    @JsonManagedReference(value = "pharmacy-address")
    private List<Pharmacy> pharmacies = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
        user.setAddress(this);
    }
}
