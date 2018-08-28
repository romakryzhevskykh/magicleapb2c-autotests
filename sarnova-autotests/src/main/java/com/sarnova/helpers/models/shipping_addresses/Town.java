package com.sarnova.helpers.models.shipping_addresses;

import java.util.ArrayList;
import java.util.Random;

public enum Town {
    BURLINGTON(State.MA, "Burlington", new ArrayList<String>() {{
        add("01803");
    }}),
    MARLBOROUGH(State.MA, "Marlborough", new ArrayList<String>() {{
        add("01752");
    }}),
    TAUNTON(State.MA, "Taunton", new ArrayList<String>() {{
        add("02780");
    }}),
    VERNON_ROCKVILLE(State.CT, "Vernon Rockville", new ArrayList<String>() {{
        add("06066");
    }}),
    PAWTUCKET(State.RI, "Pawtucket", new ArrayList<String>() {{
        add("02860");
    }}),
    BRISTOL(State.CT, "Bristol", new ArrayList<String>() {{
        add("06010");
    }}),
    GLOUCESTER(State.MA, "Gloucester", new ArrayList<String>() {{
        add("01930");
    }});

    private final State state;
    private final String fullName;
    private final ArrayList<String> zipCodes;

    Town(State state, String fullName, ArrayList<String> zipCodes) {
        this.state = state;
        this.fullName = fullName;
        this.zipCodes = zipCodes;
    }

    public State getState() {
        return state;
    }

    public String getFullName() {
        return fullName;
    }

    public ArrayList<String> getZipCodes() {
        return zipCodes;
    }

    public static Town getAnyTown() {
        int rnd = new Random().nextInt(values().length);
        return values()[rnd];
    }
}
