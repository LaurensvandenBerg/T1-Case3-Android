package com.kantilever.t1c3android.rest.services;

import com.kantilever.t1c3android.rest.apis.CustomerAPI;
import com.kantilever.t1c3android.rest.services.abs.AbsClient;

/**
 * The type Customer service.
 */
public final class CustomerService extends AbsClient {
    private static CustomerAPI restClient;

    static {
        setupRestClient();
    }

    private CustomerService() {
        super();
    }

    /**
     * Get customer api.
     *
     * @return the customer api
     */
    public static CustomerAPI get() {
        return restClient;
    }

    protected static void setupRestClient() {
        AbsClient.setupRestClient();
        restClient = restAdapter.create(CustomerAPI.class);
    }
}
