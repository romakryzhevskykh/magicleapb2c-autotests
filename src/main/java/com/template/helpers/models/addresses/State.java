package com.template.helpers.models.addresses;

import java.util.stream.Stream;

public enum State {
    CA(Country.UNITED_STATES, "California"),
    UT(Country.UNITED_STATES, "Utah");

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

    public static State getStateByFullName(String fullName) {
        return Stream.of(values())
                .filter(state -> state.getFullName().equals(fullName))
                .findAny()
                .orElseGet(() -> {
                    throw new NullPointerException("No State: " + fullName + " in the list.");
                });
    }
}
