package com.kantilever.t1c3android.domain;

import com.kantilever.t1c3android.domain.abs.PersistenceEntity;

import java.util.List;

/**
 * Created by Tom on 5-1-2016.
 */
public class PurchaseOrder extends PersistenceEntity {

    private static final long serialVersionUID = 5720989074397364426L;
    private OrderState orderState;

    private List<OrderItem> orderItems;

    private Customer customer;

    public OrderState getOrderState() {
        return this.orderState;
    }

    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
