package com.kantilever.t1c3android.domain;

/**
 * Created by Tom on 5-1-2016.
 */
public enum OrderState {
    /**
     * Running order state.
     */
    RUNNING("Openstaand"),
    PACKAGED("Verpakt"),
    SHIPPED("Verscheept");

    private String name;

    /**
     * Instantiates a new Order state.
     *
     * @param name the name
     */
    OrderState(final String name) {
        this.name = name;
    }

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
