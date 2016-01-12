package com.kantilever.t1c3android.domain;

import com.kantilever.t1c3android.domain.abs.PersistenceEntity;

import java.util.List;

/**
 * Created by Tom on 5-1-2016.
 */
public class Address extends PersistenceEntity {
    private static final long serialVersionUID = -6059929196973281627L;
    private String city;
    private String streetname;
    private String number;
    private String zipcode;
    private List<Customer> customersAddress;
    private List<Customer> customersDeliveryAddress;

    public String getCity() {
        return this.city;
    }

    public String getStreetname() {
        return this.streetname;
    }

    public String getNumber() {
        return this.number;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public List<Customer> getCustomersAddress() {
        return this.customersAddress;
    }

    public List<Customer> getCustomersDeliveryAddress() {
        return this.customersDeliveryAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setCustomersAddress(List<Customer> customersAddress) {
        this.customersAddress = customersAddress;
    }

    public void setCustomersDeliveryAddress(List<Customer> customersDeliveryAddress) {
        this.customersDeliveryAddress = customersDeliveryAddress;
    }
}
