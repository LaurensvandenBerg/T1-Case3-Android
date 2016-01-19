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

    @GET("/customerorders")
    Call<JsonElement> getAll();

    /**
     * Gets by id.
     *
     * @param id       the id
     */
    @GET("/customerorders/{id}")
    Call<JsonElement> getById(@Path("id") String id);

    /**
     * Save.
     *
     * @param entity   the entity
     */
    @POST("/customerorders")
    Call<JsonElement> save(@Body CustomerOrder entity);

    /**
     * Update.
     *
     * @param id       the id
     * @param entity   the entity
     */
    @PUT("/customerorders/{id}")
    Call<JsonElement> update(@Path("id") String id, @Body CustomerOrder entity);

    /**
     * Delete.
     *
     * @param id       the id
     */
    @DELETE("/customerorders/{id}")
    Call<JsonElement> delete(@Path("id") String id);
}
