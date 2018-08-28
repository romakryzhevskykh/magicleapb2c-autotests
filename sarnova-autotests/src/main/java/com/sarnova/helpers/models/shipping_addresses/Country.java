package com.sarnova.helpers.models.shipping_addresses;

public enum Country {
    UNITED_STATES("US", "United States");

    private final String abbreviation;
    private final String name;

    Country(String abbreviation, String name) {
        this.abbreviation = abbreviation;
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }
}
