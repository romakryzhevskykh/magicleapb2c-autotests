package com.template.helpers.models.addresses;

import java.util.Arrays;

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

    public static Country getCountryByName(String name){
        return Arrays.stream(Country.values()).filter(country -> country.getName().equalsIgnoreCase(name)).findAny().orElseGet(()->{
            throw new NullPointerException("Country enum doesn't have " + name);
        });
    }
}
