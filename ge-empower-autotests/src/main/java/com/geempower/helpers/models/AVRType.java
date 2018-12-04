package com.geempower.helpers.models;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum AVRType {
    VOLUME("All product no exclusion"),
    GUARANTEED("Guaranteed - All product no exclusion"),
    PROMO("Marketing Budget"),
    VOLUME_VS_GUARANTEED("All product no exclusion inclusive of Guarantee");

    private final String avrTypeDescription;

    AVRType(String avrTypeDescription) {
        this.avrTypeDescription = avrTypeDescription;
    }

    public String getAvrTypeDescription() {
        return avrTypeDescription;
    }

    public static List<AVRType> getAVRTypes() {
        return Arrays.stream(values()).collect(Collectors.toList());
    }
}
