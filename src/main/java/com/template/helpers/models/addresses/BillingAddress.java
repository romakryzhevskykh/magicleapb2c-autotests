package com.template.helpers.models.addresses;

import com.template.helpers.models.users.UserTitle;

public class BillingAddress extends Address {

    public BillingAddress(UserTitle userTitle, String firstName, String lastName, String address1, String city, String country, String zipCode) {
        super(userTitle, firstName, lastName, address1, city, country, zipCode);
    }
}
