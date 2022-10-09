package com.pharmacy.model;

import java.io.Serializable;
import java.util.Objects;

public class StockId implements Serializable {

    private long productId;

    private long pharmacyId;

    public StockId() {}

    public StockId(long productId, long pharmacyId) {
        this.productId = productId;
        this.pharmacyId = pharmacyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockId stockId = (StockId) o;
        return productId == stockId.productId &&
                pharmacyId == stockId.pharmacyId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, pharmacyId);
    }
}
