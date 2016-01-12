package com.kantilever.t1c3android.domain;

import com.kantilever.t1c3android.domain.abs.PersistenceEntity;

/**
 * Created by Tom on 5-1-2016.
 */
public class OrderItem extends PersistenceEntity {
    private static final long serialVersionUID = 2430048350928299321L;
    private Product product;

    private PurchaseOrder order;
    private int amount;

    public Product getProduct() {
        return this.product;
    }

    public PurchaseOrder getOrder() {
        return this.order;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setOrder(PurchaseOrder order) {
        this.order = order;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
