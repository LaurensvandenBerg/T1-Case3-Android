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
     * Gets all.
     *
     */
    @GET("/customers")
    Call<JsonElement> getAll();

    /**
     * Gets by id.
     *
     * @param id       the id
     */
    @GET("/customers/{id}")
    Call<JsonElement> getById(@Path("id") String id);

    /**
     * Save.
     *
     * @param entity   the entity
     */
    @POST("/customers")
    Call<JsonElement> save(@Body Customer entity);

    /**
     * Update.
     *
     * @param id       the id
     * @param entity   the entity
     */
    @PUT("/customers/{id}")
    Call<JsonElement> update(@Path("id") String id, @Body Customer entity);

    /**
     * Delete.
     *
     * @param id       the id
     */
    @DELETE("/customers/{id}")
    Call<JsonElement> delete(@Path("id") String id);
}
