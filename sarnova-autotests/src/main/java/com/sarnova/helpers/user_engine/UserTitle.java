package com.sarnova.helpers.user_engine;

public enum UserTitle {
    MISS("Miss"),
    MR("Mr"),
    REV("Rev."),
    MRS("Mrs"),
    DR("Dr."),
    MS("Ms");

    private final String titleText;

    UserTitle(String titleText) {
        this.titleText = titleText;
    }

    public String getTitleText() {
        return titleText;
    }
}
