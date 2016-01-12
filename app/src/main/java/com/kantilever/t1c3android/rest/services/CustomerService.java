package com.kantilever.t1c3android.rest.services;

import com.kantilever.t1c3android.rest.apis.CustomerAPI;
import com.kantilever.t1c3android.rest.services.abs.AbsClient;
import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by Tom on 12-1-2016.
 */
public class CustomerService extends AbsClient {
    private static CustomerAPI REST_CLIENT;

    static {
        setupRestClient();
    }

    private CustomerService() {}

    public static CustomerAPI get() {
        return REST_CLIENT;
    }

    private static void setupRestClient() {
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setClient(new OkClient(new OkHttpClient()))
                .setLogLevel(RestAdapter.LogLevel.FULL);

        RestAdapter restAdapter = builder.build();
        REST_CLIENT = restAdapter.create(CustomerAPI.class);
    }
}
