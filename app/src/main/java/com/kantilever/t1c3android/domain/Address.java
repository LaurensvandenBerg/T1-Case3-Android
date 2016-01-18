package com.kantilever.t1c3android.domain;

import com.kantilever.t1c3android.domain.abs.PersistenceEntity;

import java.util.List;

/**
 * The type Address.
 */
public class Address extends PersistenceEntity {
    private static final long serialVersionUID = -6059929196973281627L;
    private String city;
    private String streetname;
    private String number;
    private String zipcode;
    private List<Customer> customersAddress;
    private List<Customer> customersDeliveryAddress;

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Gets streetname.
     *
     * @return the streetname
     */
    public String getStreetname() {
        return this.streetname;
    }

    /**
     * Gets number.
     *
     * @return the number
     */
    public String getNumber() {
        return this.number;
    }

    /**
     * Gets zipcode.
     *
     * @return the zipcode
     */
    public String getZipcode() {
        return this.zipcode;
    }

    /**
     * Gets customers address.
     *
     * @return the customers address
     */
    public List<Customer> getCustomersAddress() {
        return this.customersAddress;
    }

    /**
     * Gets customers delivery address.
     *
     * @return the customers delivery address
     */
    public List<Customer> getCustomersDeliveryAddress() {
        return this.customersDeliveryAddress;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Sets streetname.
     *
     * @param streetname the streetname
     */
    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    /**
     * Sets number.
     *
     * @param number the number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Sets zipcode.
     *
     * @param zipcode the zipcode
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * Sets customers address.
     *
     * @param customersAddress the customers address
     */
    public void setCustomersAddress(List<Customer> customersAddress) {
        this.customersAddress = customersAddress;
    }

    /**
     * Sets customers delivery address.
     *
     * @param customersDeliveryAddress the customers delivery address
     */
    public void setCustomersDeliveryAddress(List<Customer> customersDeliveryAddress) {
        this.customersDeliveryAddress = customersDeliveryAddress;
    }

    @Override
    public String toString() {
        return streetname + " " + number + ", " + city;
    }
}
