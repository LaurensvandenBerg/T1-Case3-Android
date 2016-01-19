package com.kantilever.t1c3android.rest.apis;

import com.google.gson.JsonElement;
import com.kantilever.t1c3android.domain.abs.PersistenceEntity;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;

/**
 * The interface Order api.
 */
public interface OrderAPI {

    /**
     * Gets all.
     *
     * @param callback the callback
     */
    @Headers("Authorization: godmode=true")
    @GET("/customerorders")
    void getAll(Callback<JsonElement> callback);

    /**
     * Gets by id.
     *
     * @param id       the id
     * @param callback the callback
     */
    @Headers("Authorization: godmode=true")
    @GET("/customerorders/{id}")
    void getById(@Path("id") String id, Callback<JsonElement> callback);

    /**
     * Save.
     *
     * @param entity   the entity
     * @param callback the callback
     */
    @Headers("Authorization: godmode=true")
    @POST("/customerorders")
    void save(@Body PersistenceEntity entity, Callback<JsonElement> callback);

    /**
     * Update.
     *
     * @param id       the id
     * @param entity   the entity
     * @param callback the callback
     */
    @Headers("Authorization: godmode=true")
    @PUT("/customerorders/{id}")
    void update(@Path("id") String id, @Body PersistenceEntity entity, Callback<JsonElement> callback);

    /**
     * Delete.
     *
     * @param id       the id
     * @param callback the callback
     */
    @Headers("Authorization: godmode=true")
    @DELETE("/customerorders/{id}")
    void delete(@Path("id") String id, Callback<JsonElement> callback);
}