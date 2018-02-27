package com.geempower.helpers.managers;

import com.geempower.helpers.models.Region;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class RegionsManager {

    private ArrayList<Region> regions = new ArrayList<>();

    public void createInstance(String regionType) {
        Region newRegion = new Region(regionType);
        regions.add(newRegion);
    }

    public void createInstance(String regionType, ArrayList<String> accounts) {
        Region newRegion = new Region(regionType);
        newRegion.addAccounts(accounts);
        regions.add(newRegion);
    }

    public Region getRegionByName(String regionName) {
        return regions.stream()
                .filter(region -> region.getRegionType().toString().equalsIgnoreCase(regionName))
                .findAny()
                .orElse(null);
    }
}
