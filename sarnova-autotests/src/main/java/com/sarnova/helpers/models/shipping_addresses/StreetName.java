package com.sarnova.helpers.models.shipping_addresses;

import java.util.Random;

public enum StreetName {
    SECOND("Second"),
    THIRD("Third"),
    FIRST("First"),
    FOURTH("Fourth"),
    PARK("Park"),
    FIFTH("Fifth"),
    MAIN("Main"),
    SIXTH("Sixth"),
    OAK("Oak"),
    SEVENTH("Seventh"),
    PINE("Pine"),
    MAPLE("Maple"),
    CEDAR("Cedar"),
    EIGHTH("Eighth"),
    ELM("Elm"),
    VIEW("View"),
    WASHINGTON("Washington"),
    NINTH("Ninth"),
    LAKE("Lake"),
    HILL("Hill"),
    HIGH_STREET("High Street"),
    STATION_ROAD("Station Road"),
    MAIN_STREET("Main Street"),
    PARK_ROAD("Park Road"),
    CHURCH_ROAD("Church Road"),
    CHURCH_STREET("Church Street"),
    LONDON_ROAD("London Road"),
    VICTORIA_ROAD("Victoria Road"),
    GREEN_LANE("Green Lane"),
    MANOR_ROAD("Manor Road"),
    CHURCH_LANE("Church Lane"),
    PARK_AVENUE("Park Avenue"),
    THE_AVENUE("The Avenue"),
    QUEENS_ROAD("Queens Road"),
    THE_CRESCENT("The Crescent"),
    NEW_ROAD("New Road"),
    GRANGE("Grange Road"),
    KINGS_ROAD("Kings Road"),
    KINGSWAY("Kingsway"),
    WINDSOR("Windsor Road");

    public final String streetName;

    StreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNameText() {
        return streetName;
    }

    public static StreetName getRandom() {
        int rnd = new Random().nextInt(values().length);
        return values()[rnd];
    }
}
