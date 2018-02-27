package com.geempower.helpers.models;

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
}
