package com.pharmacy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "pharmacy")
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pharmacy_id")
    private long id;

    @OneToMany(mappedBy = "pharmacy")
    @JsonManagedReference(value = "pharmacy-stock")
    private Set<Stock> stocks = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    @JsonBackReference(value = "pharmacy-address")
    private Address address;
}
