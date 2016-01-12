package com.kantilever.t1c3android.rest;

import android.util.Log;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Tom on 12-1-2016.
 */
public class HateoasCallback implements Callback<HateoasResponse> {

    private static HateoasResponse result;

    @Override
    public void success(HateoasResponse hateoasResponse, Response response) {
        result = hateoasResponse;
    }

    @Override
    public void failure(RetrofitError error) {
        Log.i("HateoasCallback", error.getMessage());
        result = new HateoasResponse("Fail");
    }

    public HateoasResponse getResult(){
        return result;
    }
}
