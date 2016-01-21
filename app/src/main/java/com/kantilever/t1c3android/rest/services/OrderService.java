package com.kantilever.t1c3android.rest.services;

import com.kantilever.t1c3android.rest.apis.OrderAPI;
import com.kantilever.t1c3android.rest.services.abs.AbsClient;

/**
 * The type Order service.
 */
public final class OrderService extends AbsClient {
    private static OrderAPI restClient;

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
        return restClient;
    }

    protected static void setupRestClient() {
        AbsClient.setupRestClient();
        restClient = restAdapter.create(OrderAPI.class);
    }
}
