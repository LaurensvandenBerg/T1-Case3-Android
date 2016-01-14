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
    public CustomerOrder(String orderId, String customerId, String orderStatus, String deliveryStatus, double totalPrice, List<CustomerProduct> products) {
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

    public String toString() {
        return "com.kantilever.t1c3android.domain.rest.CustomerOrder(orderId=" + this.orderId + ", customerId=" + this.customerId + ", orderStatus=" + this.orderStatus + ", deliveryStatus=" + this.deliveryStatus + ", totalPrice=" + this.totalPrice + ", products=" + this.products + ")";
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof CustomerOrder)) return false;
        final CustomerOrder other = (CustomerOrder) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$orderId = this.getOrderId();
        final Object other$orderId = other.getOrderId();
        if (this$orderId == null ? other$orderId != null : !this$orderId.equals(other$orderId))
            return false;
        final Object this$customerId = this.getCustomerId();
        final Object other$customerId = other.getCustomerId();
        if (this$customerId == null ? other$customerId != null : !this$customerId.equals(other$customerId))
            return false;
        final Object this$orderStatus = this.getOrderStatus();
        final Object other$orderStatus = other.getOrderStatus();
        if (this$orderStatus == null ? other$orderStatus != null : !this$orderStatus.equals(other$orderStatus))
            return false;
        final Object this$deliveryStatus = this.getDeliveryStatus();
        final Object other$deliveryStatus = other.getDeliveryStatus();
        if (this$deliveryStatus == null ? other$deliveryStatus != null : !this$deliveryStatus.equals(other$deliveryStatus))
            return false;
        if (Double.compare(this.getTotalPrice(), other.getTotalPrice()) != 0) return false;
        final Object this$products = this.getProducts();
        final Object other$products = other.getProducts();
        if (this$products == null ? other$products != null : !this$products.equals(other$products))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $orderId = this.getOrderId();
        result = result * PRIME + ($orderId == null ? 0 : $orderId.hashCode());
        final Object $customerId = this.getCustomerId();
        result = result * PRIME + ($customerId == null ? 0 : $customerId.hashCode());
        final Object $orderStatus = this.getOrderStatus();
        result = result * PRIME + ($orderStatus == null ? 0 : $orderStatus.hashCode());
        final Object $deliveryStatus = this.getDeliveryStatus();
        result = result * PRIME + ($deliveryStatus == null ? 0 : $deliveryStatus.hashCode());
        final long $totalPrice = Double.doubleToLongBits(this.getTotalPrice());
        result = result * PRIME + (int) ($totalPrice >>> 32 ^ $totalPrice);
        final Object $products = this.getProducts();
        result = result * PRIME + ($products == null ? 0 : $products.hashCode());
        return result;
    }

    /**
     * Can equal boolean.
     *
     * @param other the other
     * @return the boolean
     */
    protected boolean canEqual(Object other) {
        return other instanceof CustomerOrder;
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

        public String toString() {
            return "com.kantilever.t1c3android.domain.rest.CustomerOrder.CustomerOrderBuilder(orderId=" + this.orderId + ", customerId=" + this.customerId + ", orderStatus=" + this.orderStatus + ", deliveryStatus=" + this.deliveryStatus + ", totalPrice=" + this.totalPrice + ", products=" + this.products + ")";
        }
    }
}
