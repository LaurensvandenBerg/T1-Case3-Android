package com.kantilever.t1c3android.rest;

import android.util.Log;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * The type Hateoas callback.
 */
public class HateoasCallback implements Callback<JsonElement> {

    private static JsonObject result;

    @Override
    public void success(JsonElement hateoasResponse, Response response) {
        result = hateoasResponse.getAsJsonObject();
    }

    @Override
    public void failure(RetrofitError error) {
        Log.i("HateoasCallback", error.getMessage());
        result = new JsonObject();
    }

    /**
     * Get result json object.
     *
     * @return the json object
     */
    public JsonObject getResult(){
        return result;
    }
}
