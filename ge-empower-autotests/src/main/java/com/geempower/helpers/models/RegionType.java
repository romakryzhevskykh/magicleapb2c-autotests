package com.geempower.helpers.models;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum RegionType {
    NORTH_AMERICA("North America"),
    LATIN_AMERICA("Latin America"),
    EMEA("EMEA"),
    ASIA("ASIA");

    private final String regionName;
    RegionType(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionName() {
        return regionName;
    }

    public static List<RegionType> getRegionTypes() {
        return Arrays.stream(values()).collect(Collectors.toList());
    }
}
