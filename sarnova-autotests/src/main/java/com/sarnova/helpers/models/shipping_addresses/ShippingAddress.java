package com.sarnova.helpers.models.shipping_addresses;

public class ShippingAddress {
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String town;
    private String postcode;
    private String phoneNumber;

    public ShippingAddress(String addressLine1, String town, String state, String postcode, String addressLine2, String phoneNumber) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.state = state;
        this.town = town;
        this.postcode = postcode;
        this.phoneNumber = phoneNumber;
    }

    public ShippingAddress(String addressLine1, String town, String state, String postcode) {
        this(addressLine1, town, state, postcode, "", "");
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getState() {
        return state;
    }

    public String getTown() {
        return town;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
