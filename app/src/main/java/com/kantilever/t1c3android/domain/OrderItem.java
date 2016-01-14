package com.kantilever.t1c3android.domain;

import com.kantilever.t1c3android.domain.abs.PersistenceEntity;

/**
 * The type Order item.
 */
public class OrderItem extends PersistenceEntity {
    private static final long serialVersionUID = 2430048350928299321L;
    private Product product;

    private PurchaseOrder order;
    private int amount;

    /**
     * Gets product.
     *
     * @return the product
     */
    public Product getProduct() {
        return this.product;
    }

    /**
     * Gets order.
     *
     * @return the order
     */
    public PurchaseOrder getOrder() {
        return this.order;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public int getAmount() {
        return this.amount;
    }

    /**
     * Sets product.
     *
     * @param product the product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Sets order.
     *
     * @param order the order
     */
    public void setOrder(PurchaseOrder order) {
        this.order = order;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
