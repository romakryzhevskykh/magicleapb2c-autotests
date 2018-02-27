package com.geempower.helpers.models;

import java.util.ArrayList;
import java.util.Arrays;

public class Region {
    private final RegionType regionType;
    private ArrayList<String> accounts = new ArrayList<>();

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

    public void addAccount(String account) {
        accounts.add(account);
    }

    public ArrayList<String> getAccounts() {
        return accounts;
    }

    public void addAccounts(ArrayList<String> accounts) {
        this.accounts.addAll(accounts);
    }
}
