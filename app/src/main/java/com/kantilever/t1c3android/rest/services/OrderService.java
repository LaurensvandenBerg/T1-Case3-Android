package com.kantilever.t1c3android.rest.services;

import com.kantilever.t1c3android.rest.apis.OrderAPI;
import com.kantilever.t1c3android.rest.services.abs.AbsClient;
import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * The type Order service.
 */
public class OrderService extends AbsClient {
    private static OrderAPI REST_CLIENT;

    static {
        setupRestClient();
    }

    private OrderService() {}

    /**
     * Get order api.
     *
     * @return the order api
     */
    public static OrderAPI get() {
        return REST_CLIENT;
    }

    private static void setupRestClient() {
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setClient(new OkClient(new OkHttpClient()))
                .setLogLevel(RestAdapter.LogLevel.FULL);

        RestAdapter restAdapter = builder.build();
        REST_CLIENT = restAdapter.create(OrderAPI.class);
    }
}