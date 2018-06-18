package com.sarnova.helpers.models.shipping_addresses;

public class ShippingAddress {
    private String firstName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private State state;
    private Town town;
    private String postcode;
    private String phoneNumber;
    private Country country;

    public ShippingAddress(String firstName, String lastName, String addressLine1, Town town, State state, Country country, String postcode, String addressLine2, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.state = state;
        this.town = town;
        this.postcode = postcode;
        this.phoneNumber = phoneNumber;
        this.country = country;
    }

    public ShippingAddress(String firstName, String lastName, String addressLine1, Town town, State state, Country country, String postcode) {
        this(firstName, lastName, addressLine1, town, state, country, postcode, "", "");
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public State getState() {
        return state;
    }

    public Town getTown() {
        return town;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Country getCountry() {
        return country;
    }
}
