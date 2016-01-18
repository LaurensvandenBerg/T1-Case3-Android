package com.kantilever.t1c3android.converter.deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.kantilever.t1c3android.converter.GsonConverter;
import com.kantilever.t1c3android.domain.Address;
import com.kantilever.t1c3android.domain.Customer;

import java.lang.reflect.Type;

/**
 * Customer Gson deserializer
 */
public class CustomerDeserializer implements JsonDeserializer<Customer> {
    @Override
    public Customer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        //getting the right object
        final JsonObject hateoasJson = json.getAsJsonObject();
        final JsonObject jsonObject = hateoasJson.getAsJsonObject("content");
        //getting the good objects
        String id = jsonObject.get("id").getAsString();
        int version = jsonObject.get("version").getAsInt();
        String firstName = jsonObject.get("firstName").getAsString();
        String initials = jsonObject.get("initials").getAsString();
        String lastName = jsonObject.get("lastName").getAsString();
        Address address = GsonConverter.convert(jsonObject.get("address"), Address.class);
        Address deliveryAddress = GsonConverter.convert(jsonObject.get("deliveryAddress"), Address.class);
        //filling the object
        final Customer customer = new Customer();
        customer.setId(id);
        customer.setVersion(version);
        customer.setFirstName(firstName);
        customer.setInitials(initials);
        customer.setLastName(lastName);
        customer.setAddress(address);
        customer.setDeliveryAddress(deliveryAddress);
        return customer;
    }
}
