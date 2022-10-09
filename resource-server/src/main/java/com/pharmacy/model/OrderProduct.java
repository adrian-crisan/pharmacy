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
@Table(name = "order_product")
@IdClass(OrderProductId.class)
public class OrderProduct {

    @Id
    @Column(name = "id_order")
    private long orderId;

    @Id
    @Column(name = "id_product")
    private long productId;

    @Column(name = "quantity")
    private long quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderId")
    @JoinColumn(name = "id_order")
    @JsonBackReference(value = "order-product")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "id_product")
    @JsonBackReference(value = "product-order")
    private Product product;

}
