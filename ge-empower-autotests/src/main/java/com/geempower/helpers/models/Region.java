package com.geempower.helpers.models;

import java.util.Arrays;

public class Region {
    private final RegionType regionType;

    public Region(String regionType) {
        this.regionType = Arrays.stream(RegionType.values())
                .filter(regionType1 -> regionType1.toString().equalsIgnoreCase(regionType))
                .findAny()
                .orElseGet(() -> {
                    throw new NullPointerException("No such region - " + regionType + " in Enum list!");
                });
    }

    public RegionType getRegionType() {
        return regionType;
    }
}
