package com.template.storefront.models;

public class UserAddress {
    private String fullName;
    private String street;
    private String cityState;
    private String zipCode;
    private String practiceName;

    public UserAddress(String addressFromPage) {
        String[] splittedAddress = addressFromPage.split("\n");
        this.fullName = splittedAddress[0].trim();
        this.street = splittedAddress[1].trim();
        this.cityState = splittedAddress[2].trim();
        this.zipCode = splittedAddress[3].trim();
        if (splittedAddress.length > 4) {
            this.practiceName = splittedAddress[4].replaceFirst("Practice name: ", "").trim();
        }
    }

    public String getFullName() {
        return fullName;
    }

    public String getStreet() {
        return street;
    }

    public String getCityState() {
        return cityState;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPracticeName() {
        return practiceName;
    }
}
