package com.kantilever.t1c3android.rest.services;

import com.kantilever.t1c3android.rest.apis.CustomerAPI;
import com.kantilever.t1c3android.rest.services.abs.AbsClient;

/**
 * The type Customer service.
 */
public class CustomerService<T> extends AbsClient {
    private static CustomerAPI REST_CLIENT;

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
    public static CustomerAPI get(Class clazz) {

        return REST_CLIENT;
    }

    protected static void setupRestClient() {
        AbsClient.setupRestClient();
        REST_CLIENT = REST_ADAPTER.create(CustomerAPI.class);
    }
}
