package com.sarnova.helpers.models.shipping_addresses;

public enum State {
    MA(Country.UNITED_STATES, "Massachusetts"),
    RI(Country.UNITED_STATES, "Rhode Island"),
    CT(Country.UNITED_STATES, "Connecticut");

    private final Country country;
    private final String fullName;

    State(Country country, String fullName) {
        this.country = country;
        this.fullName = fullName;
    }

    public Country getCountry() {
        return country;
    }

    public String getFullName() {
        return fullName;
    }

    public String getWithCountryAbbreviation() {
        return getCountry().getAbbreviation() + "-" + name();
    }
}
