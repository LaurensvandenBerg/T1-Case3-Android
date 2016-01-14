package com.kantilever.t1c3android.converter.deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.kantilever.t1c3android.domain.rest.CustomerOrder;

import java.lang.reflect.Type;

/**
 * The type Order deserializer.
 */
public class OrderDeserializer implements JsonDeserializer<CustomerOrder> {
    @Override
    public CustomerOrder deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        //getting the right object
        final JsonObject hateoasJson = json.getAsJsonObject();
        final JsonObject jsonObject = hateoasJson.getAsJsonObject("content");
        //getting the good objects
        String id = jsonObject.get("id").getAsString();
        int version = jsonObject.get("version").getAsInt();
        String orderId = jsonObject.get("orderId").getAsString();
        String customerId = jsonObject.get("customerId").getAsString();
        String orderStatus = jsonObject.get("orderStatus").getAsString();
        String deliveryStatus = jsonObject.get("deliveryStatus").getAsString();
        //filling the object
        final CustomerOrder customerOrder = CustomerOrder.builder()
                .customerId(customerId)
                .orderId(orderId)
                .orderStatus(orderStatus)
                .deliveryStatus(deliveryStatus)
                .build();

        customerOrder.setId(id);
        customerOrder.setVersion(version);

        return customerOrder;
    }
}
