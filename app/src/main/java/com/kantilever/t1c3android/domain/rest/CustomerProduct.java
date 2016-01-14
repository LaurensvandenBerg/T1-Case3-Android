package com.kantilever.t1c3android.domain.rest;

import com.kantilever.t1c3android.domain.Product;
import com.kantilever.t1c3android.domain.abs.PersistenceEntity;

/**
 * The type Customer product.
 *
 * @author peaseloxes
 */
public class CustomerProduct extends PersistenceEntity {
    private static final long serialVersionUID = -7699374375063811525L;
    private String name;
    private int amount;
    private double price;

    /**
     * CustomerProduct constructor.
     *
     * @param id     the product id.
     * @param name   the product name.
     * @param amount the amount in stock.
     * @param price  the product price.
     */
    public CustomerProduct(final String id, final String name, final int amount, final double price) {
        this.setId(id);
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    /**
     * CustomerProduct constructor.
     *
     * @param product the product to extract data from.
     */
    public CustomerProduct(final Product product) {
        this.setId(product.getId());
        this.name = product.getName();
        this.amount = product.getStock();
        this.price = product.getPrice();
    }

    /**
     * Instantiates a new Customer product.
     *
     * @param name   the name
     * @param amount the amount
     * @param price  the price
     */
    public CustomerProduct(String name, int amount, double price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    /**
     * Instantiates a new Customer product.
     */
    public CustomerProduct() {
    }

    /**
     * Builder customer product builder.
     *
     * @return the customer product builder
     */
    public static CustomerProductBuilder builder() {
        return new CustomerProductBuilder();
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
     * Gets amount.
     *
     * @return the amount
     */
    public int getAmount() {
        return this.amount;
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
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "com.kantilever.t1c3android.domain.rest.CustomerProduct(name=" + this.name + ", amount=" + this.amount + ", price=" + this.price + ")";
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof CustomerProduct)) return false;
        final CustomerProduct other = (CustomerProduct) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        if (this.getAmount() != other.getAmount()) return false;
        if (Double.compare(this.getPrice(), other.getPrice()) != 0) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 0 : $name.hashCode());
        result = result * PRIME + this.getAmount();
        final long $price = Double.doubleToLongBits(this.getPrice());
        result = result * PRIME + (int) ($price >>> 32 ^ $price);
        return result;
    }

    /**
     * Can equal boolean.
     *
     * @param other the other
     * @return the boolean
     */
    protected boolean canEqual(Object other) {
        return other instanceof CustomerProduct;
    }

    /**
     * The type Customer product builder.
     */
    public static class CustomerProductBuilder {
        private String name;
        private int amount;
        private double price;

        /**
         * Instantiates a new Customer product builder.
         */
        CustomerProductBuilder() {
        }

        /**
         * Name customer product . customer product builder.
         *
         * @param name the name
         * @return the customer product . customer product builder
         */
        public CustomerProduct.CustomerProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Amount customer product . customer product builder.
         *
         * @param amount the amount
         * @return the customer product . customer product builder
         */
        public CustomerProduct.CustomerProductBuilder amount(int amount) {
            this.amount = amount;
            return this;
        }

        /**
         * Price customer product . customer product builder.
         *
         * @param price the price
         * @return the customer product . customer product builder
         */
        public CustomerProduct.CustomerProductBuilder price(double price) {
            this.price = price;
            return this;
        }

        /**
         * Build customer product.
         *
         * @return the customer product
         */
        public CustomerProduct build() {
            return new CustomerProduct(name, amount, price);
        }

        public String toString() {
            return "com.kantilever.t1c3android.domain.rest.CustomerProduct.CustomerProductBuilder(name=" + this.name + ", amount=" + this.amount + ", price=" + this.price + ")";
        }
    }
}
