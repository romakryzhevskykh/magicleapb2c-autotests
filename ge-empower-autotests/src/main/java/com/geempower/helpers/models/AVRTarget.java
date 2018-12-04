package com.geempower.helpers.models;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum AVRTarget {
    NO_LIMIT("No Limit"),
    NEXT_TARGET("Next Target"),
    TOP_TARGET_MET("Top Target Met");

    private final String avrTargetDescription;

    AVRTarget(String avrTargetDescription) {
        this.avrTargetDescription = avrTargetDescription;
    }

    public String getAvrTargetDescription() {
        return avrTargetDescription;
    }

    public static List<AVRTarget> getAVRTargets() {
        return Arrays.stream(values()).collect(Collectors.toList());
    }
}
