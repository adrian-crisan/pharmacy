package com.pharmacy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id", unique = true)
    private long id;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "price")
    private double price;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference(value = "product-order")
    private Set<OrderProduct> quantity = new HashSet<>();

    @OneToMany(mappedBy = "product")
    @JsonManagedReference(value = "product-stock")
    private Set<Stock> stocks = new HashSet<>();

    @ManyToMany(mappedBy = "products")
    @JsonBackReference(value = "product-category-product")
    private Set<ProductCategory> productCategories = new HashSet<>();
}
