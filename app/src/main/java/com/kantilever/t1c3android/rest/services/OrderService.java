package com.kantilever.t1c3android.rest.services;

import com.kantilever.t1c3android.rest.apis.OrderAPI;
import com.kantilever.t1c3android.rest.services.abs.AbsClient;

/**
 * The type Order service.
 */
public class OrderService extends AbsClient {
    private static OrderAPI REST_CLIENT;

    static {
        setupRestClient();
    }

    private OrderService() {
    }

    /**
     * Get order api.
     *
     * @return the order api
     */
    public static OrderAPI get() {
        return REST_CLIENT;
    }

    protected static void setupRestClient() {
        AbsClient.setupRestClient();
        REST_CLIENT = REST_ADAPTER.create(OrderAPI.class);
    }
}
