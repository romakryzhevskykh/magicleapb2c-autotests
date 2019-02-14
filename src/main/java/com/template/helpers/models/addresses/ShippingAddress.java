package com.template.helpers.models.addresses;

import com.template.helpers.models.users.UserTitle;

public class ShippingAddress extends Address {

    public ShippingAddress(UserTitle userTitle, String firstName, String lastName, String address1, String city, String state, String zipCode) {
        super(userTitle, firstName, lastName, address1, city, state, zipCode);
    }
}
