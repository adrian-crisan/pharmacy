package com.pharmacy.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "product_category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_category_id", unique = true)
    private long id;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "product_category_product",
            joinColumns = @JoinColumn(name = "product_category_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products = new HashSet<>();
}
