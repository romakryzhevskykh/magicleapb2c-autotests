package com.sarnova.helpers.models.users;

import java.util.stream.Stream;

public enum ProfileRole {
    FIRE_EMS_PRIVATE("executive", "Executive"),
    GOVERNMENT_MILITARY("medical", "Medical Directory"),
    INTERNATIONAL("logistic", "Operations/Logistics"),
    DEALERS_RESELLERS("officer", "Fire/EMS Officer"),
    FIRE_EMS_PUBLIC("payable", "Accounts Payable"),
    INDIVIDUALS_CONSUMERS("buyer", "Purchasing/Buyer"),
    AIR_MEDICAL_TRANSPORT("training", "Training");

    private String identificator;
    private String roleText;

    ProfileRole(String identificator, String roleText) {
        this.identificator = identificator;
        this.roleText = roleText;
    }

    public static ProfileRole getAny() {
        return Stream.of(values()).findAny().get();
    }

    public String getIdentificator() {
        return identificator;
    }

    public String getRoleText() {
        return roleText;
    }
}
