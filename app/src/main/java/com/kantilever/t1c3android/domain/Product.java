package com.kantilever.t1c3android.domain;

import com.kantilever.t1c3android.domain.abs.PersistenceEntity;

/**
 * The type Product.
 */
public class Product extends PersistenceEntity {
    private static final long serialVersionUID = -6842446943022957399L;
    private String name;
    private double price;
    private int stock;

    /**
     * Instantiates a new Product.
     *
     * @param id    the id
     * @param name  the name
     * @param price the price
     * @param stock the stock
     */
    public Product(final String id, final String name, final double price, final int stock) {
        this.setId(id);
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Instantiates a new Product.
     *
     * @param name  the name
     * @param price the price
     * @param stock the stock
     */
    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Instantiates a new Product.
     */
    public Product() {
        //empty constructor
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Gets stock.
     *
     * @return the stock
     */
    public int getStock() {
        return this.stock;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets stock.
     *
     * @param stock the stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "com.kantilever.t1c3android.domain.Product(name=" + this.name + ", price=" + this.price + ", stock=" + this.stock + ")";
    }
}
