package com.kantilever.t1c3android.rest.apis;

import com.google.gson.JsonElement;
import com.kantilever.t1c3android.domain.Customer;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * The interface Customer api.
 */
public interface CustomerAPI {
    /**
     * Gets all Customers.
     *
     * @return All Customers
     */
    @GET("/customers")
    Call<JsonElement> getAll();

    /**
     * Gets Customer by id.
     *
     * @param id the id Customer
     * @return the Customer by id
     */
    @GET("/customers/{id}")
    Call<JsonElement> getById(@Path("id") String id);

    /**
     * Save Customer call.
     *
     * @param customer the Customer
     * @return the call
     */
    @POST("/customers")
    Call<JsonElement> save(@Body Customer customer);

    /**
     * Update customer call.
     *
     * @param id     the id
     * @param customer the customer
     * @return the call
     */
    @PUT("/customers/{id}")
    Call<JsonElement> update(@Path("id") String id, @Body Customer customer);

    /**
     * Delete call.
     *
     * @param id the customer id
     * @return the customer call
     */
    @DELETE("/customers/{id}")
    Call<JsonElement> delete(@Path("id") String id);
}
