package com.kantilever.t1c3android.converter.deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.kantilever.t1c3android.domain.Address;

import java.lang.reflect.Type;

/**
 * The type Address deserializer.
 */
public class AddressDeserializer implements JsonDeserializer<Address> {
    @Override
    public Address deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        //getting the right object
        final JsonObject jsonObject = json.getAsJsonObject();
        //getting the good objects
        String id = jsonObject.get("id").getAsString();
        int version = jsonObject.get("version").getAsInt();
        String city = jsonObject.get("city").getAsString();
        String streetname = jsonObject.get("streetname").getAsString();
        String number = jsonObject.get("number").getAsString();
        String zipcode = jsonObject.get("zipcode").getAsString();
        //filling the object
        final Address address = new Address();
        address.setId(id);
        address.setVersion(version);
        address.setCity(city);
        address.setStreetname(streetname);
        address.setNumber(number);
        address.setZipcode(zipcode);
        return address;
    }
}
