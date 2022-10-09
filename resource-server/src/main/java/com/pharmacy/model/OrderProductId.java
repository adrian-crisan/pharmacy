package com.pharmacy.model;

import java.io.Serializable;
import java.util.Objects;

public class OrderProductId implements Serializable {

    private long orderId;

    private long productId;

    public OrderProductId() {}

    public OrderProductId(long orderId, long productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProductId that = (OrderProductId) o;
        return orderId == that.orderId &&
                productId == that.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId);
    }
}
