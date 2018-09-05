package com.sarnova.helpers.managers;

import com.sarnova.helpers.models.shipping_addresses.Country;
import com.sarnova.helpers.models.shipping_addresses.ShippingAddress;
import com.sarnova.helpers.models.shipping_addresses.State;
import com.sarnova.helpers.models.shipping_addresses.Town;
import org.springframework.stereotype.Component;

@Component
public class ShippingAddressesManager {

    public ShippingAddress createInstance(String firstName, String lastName, String addressLine1, Town town, State state, Country country, String postcode, String addressLine2, String phoneNumber) {
        return new ShippingAddress(firstName, lastName, addressLine1, town, state, country, postcode, addressLine2, phoneNumber);
    }

    public ShippingAddress createInstance(String firstName, String lastName, String addressLine1, Town town, State state, Country country, String postcode, String phoneNumber) {
        return new ShippingAddress(firstName, lastName, addressLine1, town, state, country, postcode, phoneNumber);
    }
}
