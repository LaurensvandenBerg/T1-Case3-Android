package com.kantilever.t1c3android.domain.rest;

import com.kantilever.t1c3android.domain.abs.PersistenceEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Customer order.
 *
 * @author peaseloxes
 */
public class CustomerOrder extends PersistenceEntity {
    private static final long serialVersionUID = -359500118765361885L;

    private String orderId;
    private String customerId;
    private String orderStatus;
    private String deliveryStatus;
    private double totalPrice;

    private List<CustomerProduct> products = new ArrayList<>();

    /**
     * Instantiates a new Customer order.
     *
     * @param orderId        the order id
     * @param customerId     the customer id
     * @param orderStatus    the order status
     * @param deliveryStatus the delivery status
     * @param totalPrice     the total price
     * @param products       the products
     */
    public CustomerOrder(String orderId, String customerId, String orderStatus,
                         String deliveryStatus, double totalPrice,
                         List<CustomerProduct> products) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderStatus = orderStatus;
        this.deliveryStatus = deliveryStatus;
        this.totalPrice = totalPrice;
        this.products = products;
    }

    /**
     * Instantiates a new Customer order.
     */
    public CustomerOrder() {
        //Empty constructor
    }

    /**
     * Builder customer order builder.
     *
     * @return the customer order builder
     */
    public static CustomerOrderBuilder builder() {
        return new CustomerOrderBuilder();
    }

    /**
     * Gets order id.
     *
     * @return the order id
     */
    public String getOrderId() {
        return this.orderId;
    }

    /**
     * Gets customer id.
     *
     * @return the customer id
     */
    public String getCustomerId() {
        return this.customerId;
    }

    /**
     * Gets order status.
     *
     * @return the order status
     */
    public String getOrderStatus() {
        return this.orderStatus;
    }

    /**
     * Gets delivery status.
     *
     * @return the delivery status
     */
    public String getDeliveryStatus() {
        return this.deliveryStatus;
    }

    /**
     * Gets total price.
     *
     * @return the total price
     */
    public double getTotalPrice() {
        return this.totalPrice;
    }

    /**
     * Gets products.
     *
     * @return the products
     */
    public List<CustomerProduct> getProducts() {
        return this.products;
    }

    /**
     * Sets order id.
     *
     * @param orderId the order id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * Sets customer id.
     *
     * @param customerId the customer id
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Sets order status.
     *
     * @param orderStatus the order status
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * Sets delivery status.
     *
     * @param deliveryStatus the delivery status
     */
    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    /**
     * Sets total price.
     *
     * @param totalPrice the total price
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Sets products.
     *
     * @param products the products
     */
    public void setProducts(List<CustomerProduct> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "com.kantilever.t1c3android.domain.rest.CustomerOrder(orderId=" + this.orderId
               + ", customerId=" + this.customerId + ", orderStatus=" + this.orderStatus
               + ", deliveryStatus=" + this.deliveryStatus + ", totalPrice=" + this.totalPrice
               + ", products=" + this.products + ")";
    }

    /**
     * The type Customer order builder.
     */
    public static class CustomerOrderBuilder {
        private String orderId;
        private String customerId;
        private String orderStatus;
        private String deliveryStatus;
        private double totalPrice;
        private List<CustomerProduct> products;

        /**
         * Instantiates a new Customer order builder.
         */
        CustomerOrderBuilder() {
        }

        /**
         * Order id customer order . customer order builder.
         *
         * @param orderId the order id
         * @return the customer order . customer order builder
         */
        public CustomerOrder.CustomerOrderBuilder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        /**
         * Customer id customer order . customer order builder.
         *
         * @param customerId the customer id
         * @return the customer order . customer order builder
         */
        public CustomerOrder.CustomerOrderBuilder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        /**
         * Order status customer order . customer order builder.
         *
         * @param orderStatus the order status
         * @return the customer order . customer order builder
         */
        public CustomerOrder.CustomerOrderBuilder orderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        /**
         * Delivery status customer order . customer order builder.
         *
         * @param deliveryStatus the delivery status
         * @return the customer order . customer order builder
         */
        public CustomerOrder.CustomerOrderBuilder deliveryStatus(String deliveryStatus) {
            this.deliveryStatus = deliveryStatus;
            return this;
        }

        /**
         * Total price customer order . customer order builder.
         *
         * @param totalPrice the total price
         * @return the customer order . customer order builder
         */
        public CustomerOrder.CustomerOrderBuilder totalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        /**
         * Products customer order . customer order builder.
         *
         * @param products the products
         * @return the customer order . customer order builder
         */
        public CustomerOrder.CustomerOrderBuilder products(List<CustomerProduct> products) {
            this.products = products;
            return this;
        }

        /**
         * Build customer order.
         *
         * @return the customer order
         */
        public CustomerOrder build() {
            return new CustomerOrder(orderId, customerId, orderStatus, deliveryStatus, totalPrice, products);
        }

        @Override
        public String toString() {
            return "com.kantilever.t1c3android.domain.rest.CustomerOrder.CustomerOrderBuilder(orderId=" + this.orderId
                   + ", customerId=" + this.customerId + ", orderStatus=" + this.orderStatus
                   + ", deliveryStatus=" + this.deliveryStatus + ", totalPrice=" + this.totalPrice + ", products=" + this.products
                   + ")";
        }
    }
}
