package com.kantilever.t1c3android.domain;

/**
 * Created by Tom on 5-1-2016.
 */
public enum OrderState {
    /**
     * Running order state.
     */
    RUNNING("Openstaand");

    private String name;

    /**
     * Instantiates a new Order state.
     *
     * @param name the name
     */
    OrderState(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
