package com.template.helpers.models.addresses;

import lombok.Getter;

import java.util.Random;

public enum City {
    PASO_ROBLES(State.CA, "Paso Robles"),
    SACRAMENTO(State.CA, "SACRAMENTO"),
    LOS_ANGELES(State.CA, "Los Angeles"),
    SALT_LAKE_CITY(State.UT, "Salt Lake City");

    @Getter private final State state;
    @Getter private final String fullName;

    City(State state, String fullName) {
        this.state = state;
        this.fullName = fullName;
    }

    public static City getAny() {
        int rnd = new Random().nextInt(values().length);
        return values()[rnd];
    }
}