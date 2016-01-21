package com.kantilever.t1c3android.domain;

import com.kantilever.t1c3android.domain.abs.PersistenceEntity;

import java.util.List;

/**
 * The type Customer.
 */
public class Customer extends PersistenceEntity {
    private static final long serialVersionUID = 2987510524408242766L;
    private String firstName;
    private String lastName;
    private String initials;
    private Address address;
    private Address deliveryAddress;
    private List<PurchaseOrder> orders;

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Gets initials.
     *
     * @return the initials
     */
    public String getInitials() {
        return this.initials;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public Address getAddress() {
        return this.address;
    }

    /**
     * Gets delivery address.
     *
     * @return the delivery address
     */
    public Address getDeliveryAddress() {
        return this.deliveryAddress;
    }

    /**
     * Gets orders.
     *
     * @return the orders
     */
    public List<PurchaseOrder> getOrders() {
        return this.orders;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets initials.
     *
     * @param initials the initials
     */
    public void setInitials(String initials) {
        this.initials = initials;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Sets delivery address.
     *
     * @param deliveryAddress the delivery address
     */
    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    /**
     * Sets orders.
     *
     * @param orders the orders
     */
    public void setOrders(List<PurchaseOrder> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
