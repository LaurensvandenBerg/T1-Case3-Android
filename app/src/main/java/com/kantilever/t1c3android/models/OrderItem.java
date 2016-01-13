package com.kantilever.t1c3android.models;

/**
 * Created by laurensoomen on 13/01/16.
 */
public class OrderItem {

    public int orderID;
    public String state;

    public OrderItem(int OrderId, String state){

        this.orderID = orderID;
        this.state = state;
    }
}
