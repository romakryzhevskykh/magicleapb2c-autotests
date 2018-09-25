package com.sarnova.helpers.models.users;

import java.util.stream.Stream;

public enum Title {
    FIRE_EMS_PRIVATE("doctor", "Doctor"),
    GOVERNMENT_MILITARY("ems_i", "EMS-I"),
    INTERNATIONAL("ems_b", "EMS-B"),
    DEALERS_RESELLERS("ems_administrator", "EMS Administrator"),
    FIRE_EMS_PUBLIC("ems_director", "EMS Director"),
    INDIVIDUALS_CONSUMERS("captain", "Captain"),
    AIR_MEDICAL_TRANSPORT("lieutenant", "Lieutenant"),
    LAW_ENFORCEMENT_CORRECTIONS("ems_p", "EMS-P"),
    OTHER_HEALTHCARE("lpn", "LPN"),
    UNIVERSITY("other", "Other"),
    TRAINING("chief", "Chief"),
    OTHER("assistant_chief", "Assistant Chief");

    private String identificator;
    private String titleText;

    Title(String identificator, String titleText) {
        this.identificator = identificator;
        this.titleText = titleText;
    }

    public static Title getAny() {
        return Stream.of(values()).findAny().get();
    }

    public String getIdentificator() {
        return identificator;
    }

    public String getTitleText() {
        return titleText;
    }
}
