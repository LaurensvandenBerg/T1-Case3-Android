package com.kantilever.t1c3android.converter.deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.kantilever.t1c3android.converter.GsonConverter;
import com.kantilever.t1c3android.domain.Customer;
import com.kantilever.t1c3android.domain.OrderState;
import com.kantilever.t1c3android.domain.PurchaseOrder;

import java.lang.reflect.Type;

/**
 * The type Order deserializer.
 */
public class OrderDeserializer implements JsonDeserializer<PurchaseOrder> {
    @Override
    public PurchaseOrder deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        //getting the right object
        final JsonObject hateoasJson = json.getAsJsonObject();
        final JsonObject jsonObject = hateoasJson.getAsJsonObject("content");
        //getting the good objects
        String id = jsonObject.get("id").getAsString();
        int version = jsonObject.get("version").getAsInt();
        Customer customer = GsonConverter.convert(jsonObject.get("customer").getAsJsonObject(), Customer.class);
        OrderState orderState = OrderState.valueOf(jsonObject.get("orderState").getAsString());
        //filling the object
        final PurchaseOrder order = new PurchaseOrder();
        order.setId(id);
        order.setVersion(version);
        order.setCustomer(customer);
        order.setOrderState(orderState);
        return order;
    }
}
