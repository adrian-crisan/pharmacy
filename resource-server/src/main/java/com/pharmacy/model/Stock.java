package com.pharmacy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "stock")
@IdClass(StockId.class)
public class Stock {

    @Id
    @Column(name = "product_id")
    private long productId;

    @Id
    @Column(name = "pharmacy_id")
    private long pharmacyId;

    @Column(name = "quantity")
    private long quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    @JsonBackReference(value = "product-stock")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("pharmacyId")
    @JoinColumn(name = "pharmacy_id")
    @JsonBackReference(value = "pharmacy-stock")
    private Pharmacy pharmacy;

}
