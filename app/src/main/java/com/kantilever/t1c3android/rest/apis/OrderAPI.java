package com.kantilever.t1c3android.rest.apis;

import com.google.gson.JsonElement;
import com.kantilever.t1c3android.domain.rest.CustomerOrder;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * The interface Order api.
 */
public interface OrderAPI {

    /**
     * Gets Orders all.
     *
     * @return the all
     */
    @GET("/customerorders")
    Call<JsonElement> getAll();

    /**
     * Gets Order by id.
     *
     * @param id the id
     * @return the Order by id
     */
    @GET("/customerorders/{id}")
    Call<JsonElement> getById(@Path("id") String id);

    /**
     * Save Order call.
     *
     * @param order the Order
     * @return the call
     */
    @POST("/customerorders")
    Call<JsonElement> save(@Body CustomerOrder order);

    /**
     * Update Order call.
     *
     * @param id     the id
     * @param order the Order
     * @return the call
     */
    @PUT("/customerorders/{id}")
    Call<JsonElement> update(@Path("id") String id, @Body CustomerOrder order);

    /**
     * Delete Order call.
     *
     * @param id the id
     * @return the call
     */
    @DELETE("/customerorders/{id}")
    Call<JsonElement> delete(@Path("id") String id);
}
