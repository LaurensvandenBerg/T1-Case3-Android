package com.kantilever.t1c3android.rest.services.abs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kantilever.t1c3android.converter.deserializers.AddressDeserializer;
import com.kantilever.t1c3android.converter.deserializers.CustomerDeserializer;
import com.kantilever.t1c3android.converter.deserializers.OrderDeserializer;
import com.kantilever.t1c3android.domain.Address;
import com.kantilever.t1c3android.domain.Customer;
import com.kantilever.t1c3android.domain.rest.CustomerOrder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * The type Abs client.
 */
public abstract class AbsClient {

    private static final Gson GSON = new GsonBuilder().registerTypeAdapter(Customer.class, new CustomerDeserializer())
                                                      .registerTypeAdapter(CustomerOrder.class, new OrderDeserializer())
                                                      .registerTypeAdapter(Address.class, new AddressDeserializer())
                                                      .setPrettyPrinting()
                                                      .create();

    /**
     * The constant BASE_URL.
     */
    protected static final String BASE_URL = "http://10.32.40.234:6789";

    protected static OkHttpClient client;
    /**
     * The constant REST_ADAPTER.
     */
    protected static Retrofit REST_ADAPTER;

    protected AbsClient(){
    }

    protected static void setupRestClient() {
        client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .addHeader("Authorization", "godmode=true")
                        .build();
                return chain.proceed(request);
            }
        }).build();

        REST_ADAPTER = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GSON))
                .client(client)
                .build();
    }
}
