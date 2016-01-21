package com.kantilever.t1c3android.rest.services.abs;

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

    /**
     * The constant BASE_URL.
     */
    protected static final String BASE_URL = "http://10.32.40.234:6789";
    /**
     * The constant HttpClient.
     */
    protected static OkHttpClient client;
    /**
     * The constant rest.
     */
    protected static Retrofit restAdapter;

    /**
     * The constant JSON_VERSION.
     */
    public static final String JSON_VERSION = "6.0";

    /**
     * Instantiates a new Abs client.
     */
    protected AbsClient() {
    }

    /**
     * Sets rest client.
     */
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

        restAdapter = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    /**
     * Gets json version.
     *
     * @return the json version
     */
    public static String getJsonVersion() {
        return JSON_VERSION;
    }
}
