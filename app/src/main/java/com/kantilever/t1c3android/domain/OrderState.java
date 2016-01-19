package com.kantilever.t1c3android.domain;

/**
 * Created by Tom on 5-1-2016.
 */
public enum OrderState {
    /**
     * Running order state.
     */
    RUNNING("Open"),
    /**
     * Packaged order state.
     */
    PACKAGED("Verpakt"),
    /**
     * Shipped order state.
     */
    SHIPPED("Verscheept"),
    /**
     * Cancelled order state.
     */
    CANCELLED("Geannuleerd");

    private String name;

    /**
     * Instantiates a new Order state.
     *
     * @param name the name
     */
    OrderState(final String name) {
        this.name = name;
    }

    /**
     * Find order state order state.
     *
     * @param name the name
     * @return the order state
     */
    public static OrderState findOrderState(String name) {
        OrderState state = null;
        for(OrderState orderState : OrderState.values())
            if(orderState.name.equals(name))
                state = orderState;
        return state;
    }

    @Override
    public String toString() {
        return name;
    }

}
