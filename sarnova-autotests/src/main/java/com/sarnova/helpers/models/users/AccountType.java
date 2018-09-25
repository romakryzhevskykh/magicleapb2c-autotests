package com.sarnova.helpers.models.users;

import java.util.stream.Stream;

public enum AccountType {
    FIRE_EMS_PRIVATE("fire_ems_private", "Fire/EMS -Private"),
    GOVERNMENT_MILITARY("government_military", "Government/Military"),
    INTERNATIONAL("international", "International"),
    DEALERS_RESELLERS("business_industry", "Dealers/Resellers"),
    FIRE_EMS_PUBLIC("fire_ems_public", "Fire/EMS -Public"),
    INDIVIDUALS_CONSUMERS("individuals_consumers", "Individuals/Consumers"),
    AIR_MEDICAL_TRANSPORT("air_medical_transport", "Air Medical/Transport"),
    LAW_ENFORCEMENT_CORRECTIONS("law_enforcement_corrections", "Law Enforcement/Corrections"),
    OTHER_HEALTHCARE("other_healthcare", "Other Healthcare"),
    UNIVERSITY("university", "University"),
    TRAINING("training", "Training"),
    OTHER("other", "Other");

    private String identificator;
    private String accountTypeText;

    AccountType(String identificator, String accountTypeText) {
        this.identificator = identificator;
        this.accountTypeText = accountTypeText;
    }

    public static AccountType getAny() {
        return Stream.of(values()).findAny().get();
    }

    public String getIdentificator() {
        return identificator;
    }

    public String getAccountTypeText() {
        return accountTypeText;
    }
}
