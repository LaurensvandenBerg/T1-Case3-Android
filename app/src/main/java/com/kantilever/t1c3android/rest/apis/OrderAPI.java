package com.kantilever.t1c3android.rest.apis;

import com.kantilever.t1c3android.domain.abs.PersistenceEntity;
import com.kantilever.t1c3android.rest.HateoasResponse;

import retrofit.Callback;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;

public interface OrderAPI {

    @GET("/customerorders")
    void getAll(Callback<HateoasResponse> callback);

    @GET("/customerorders/{id}")
    void getById(@Path("id") String id, Callback<HateoasResponse> callback);

    @POST("/customerorders")
    void save(PersistenceEntity entity, Callback<HateoasResponse> callback);

    @PUT("/customerorders/{id}")
    void update(@Path("id") String id, PersistenceEntity entity, Callback<HateoasResponse> callback);

    @DELETE("/customerorders/{id}")
    void delete(@Path("id") String id, Callback<HateoasResponse> callback);
}
