package com.kantilever.t1c3android.rest.apis;

import com.kantilever.t1c3android.domain.abs.PersistenceEntity;
import com.kantilever.t1c3android.rest.HateoasResponse;

import retrofit.Callback;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;


/**
 * Created by Tom on 12-1-2016.
 */
public interface CustomerAPI {
    @GET("/customers")
    void getAll(Callback<HateoasResponse> callback);

    @GET("/customers/{id}")
    void getById(@Path("id") String id, Callback<HateoasResponse> callback);

    @POST("/customers")
    void save(PersistenceEntity entity, Callback<HateoasResponse> callback);

    @PUT("/customers/{id}")
    void update(@Path("id") String id, PersistenceEntity entity, Callback<HateoasResponse> callback);

    @DELETE("/customers/{id}")
    void delete(@Path("id") String id, Callback<HateoasResponse> callback);
}
