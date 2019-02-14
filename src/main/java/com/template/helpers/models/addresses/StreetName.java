package com.template.helpers.models.addresses;

import lombok.Getter;

import java.util.Random;

public enum StreetName {
    GOLDEN_HILL_RD(City.PASO_ROBLES, "1925 Golden Hill Rd Ste 300", "93446-7192"),
    HEADQUARTERS_STREET(City.SACRAMENTO, "Headquarters 1120 N Street", "94273-0001"),
    SPRING_STREET(City.LOS_ANGELES, "200 N Spring St", "90012-4801"),
    UNIVERSITY_BLVD(City.SALT_LAKE_CITY, "117 University Vlg", "84108-3401"),
    WASHINGTON_STREET(City.SALT_LAKE_CITY, "640 S Washington St", "84101-2728");

    @Getter public final City city;
    @Getter private final String streetNameText;
    @Getter private final String zipCode;

    StreetName(City city, String streetNameText, String zipCode) {
        this.city = city;
        this.streetNameText = streetNameText;
        this.zipCode = zipCode;
    }

    public static StreetName getAny() {
        int rnd = new Random().nextInt(values().length);
        return values()[rnd];
    }
}
