package com.sarnova.helpers.managers;

import com.sarnova.helpers.models.shipping_addresses.ShippingAddress;
import org.springframework.stereotype.Component;

@Component
public class ShippingAddressesManager {

    public ShippingAddress createInstance(String addressLine1, String town, String state, String postcode, String addressLine2, String phoneNumber) {
        return new ShippingAddress(addressLine1, town, state, postcode, addressLine2, phoneNumber);
    }

    public ShippingAddress createInstance(String addressLine1, String town, String state, String postcode) {
        return new ShippingAddress(addressLine1, town, state, postcode);
    }
}
