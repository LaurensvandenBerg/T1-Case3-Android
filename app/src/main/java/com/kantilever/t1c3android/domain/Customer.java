package com.kantilever.t1c3android.domain;

import com.kantilever.t1c3android.domain.abs.PersistenceEntity;

import java.util.List;

/**
 * Created by Tom on 5-1-2016.
 */
public class Customer extends PersistenceEntity {
    private static final long serialVersionUID = 2987510524408242766L;
    private String firstName;
    private String lastName;
    private String initials;
    private Address address;
    private Address deliveryAddress;
    private List<PurchaseOrder> orders;

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getInitials() {
        return this.initials;
    }

    public Address getAddress() {
        return this.address;
    }

    public Address getDeliveryAddress() {
        return this.deliveryAddress;
    }

    public List<PurchaseOrder> getOrders() {
        return this.orders;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setOrders(List<PurchaseOrder> orders) {
        this.orders = orders;
    }
}
