package com.kantilever.t1c3android.domain;

import com.kantilever.t1c3android.domain.abs.PersistenceEntity;

import java.util.List;

/**
 * The type Purchase order.
 */
public class PurchaseOrder extends PersistenceEntity {

    private static final long serialVersionUID = 5720989074397364426L;
    private OrderState orderState;
    private List<OrderItem> orderItems;
    private Customer customer;

    /**
     * Gets order state.
     *
     * @return the order state
     */
    public OrderState getOrderState() {
        return this.orderState;
    }

    /**
     * Gets order items.
     *
     * @return the order items
     */
    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    /**
     * Gets customer.
     *
     * @return the customer
     */
    public Customer getCustomer() {
        return this.customer;
    }

    /**
     * Sets order state.
     *
     * @param orderState the order state
     */
    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    /**
     * Sets order items.
     *
     * @param orderItems the order items
     */
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    /**
     * Sets customer.
     *
     * @param customer the customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
