package com.kantilever.t1c3android.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.kantilever.t1c3android.converter.deserializers.CustomerDeserializer;
import com.kantilever.t1c3android.converter.deserializers.OrderDeserializer;
import com.kantilever.t1c3android.domain.Customer;
import com.kantilever.t1c3android.domain.rest.CustomerOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Gson converter.
 */
public class GsonConverter {

    private static Gson gson = new GsonBuilder().registerTypeAdapter(Customer.class, new CustomerDeserializer())
                                                .registerTypeAdapter(CustomerOrder.class, new OrderDeserializer())
                                                .setPrettyPrinting()
                                                .create();

    private GsonConverter() {
    }

    /**
     * Convert t.
     *
     * @param <T>     the type parameter
     * @param content the content
     * @param clazz   the clazz
     * @return the t
     */
    public static <T> T convert(JsonElement content, Class clazz) {
        return (T) gson.fromJson(content, clazz);
    }

    /**
     * Convert t.
     *
     * @param <T>     the type parameter
     * @param clazz   the clazz
     * @return the t
     */
    public static <T> List<T> convertArray(JsonArray array, Class clazz) {
        List convertable = new ArrayList();
        for(JsonElement element : array){
            convertable.add(convert(element, clazz));
        }
        return convertable;
    }
}
