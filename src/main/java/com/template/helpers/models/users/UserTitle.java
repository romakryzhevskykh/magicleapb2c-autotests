package com.template.helpers.models.users;

import java.util.Random;
import java.util.stream.Stream;

public enum UserTitle {
    MISS("Miss"),
    MR("Mr."),
    REV("Rev."),
    MRS("Mrs."),
    MS("Ms."),
    DR("Dr.");

    private final String titleText;

    UserTitle(String titleText) {
        this.titleText = titleText;
    }

    public String getTitleText() {
        return titleText;
    }

    public static UserTitle getAny() {
        Random generator = new Random();
        int randomIndex = generator.nextInt(UserTitle.values().length);
        return UserTitle.values()[randomIndex];
    }

    public static UserTitle getAnyExcept(UserTitle ignoredTitle) {
        return Stream.of(UserTitle.values()).filter(title -> title != ignoredTitle).findAny().orElseGet(() -> {
            throw new IllegalArgumentException("All the titles equal provided title: " + ignoredTitle);
        });
    }

    public static UserTitle getUserTitleByTitleText(String titleText) {
        return Stream.of(UserTitle.values())
                .filter(title1 -> title1.getTitleText().equalsIgnoreCase(titleText) || (title1.getTitleText() + ".").equalsIgnoreCase(titleText))
                .findAny().orElseGet(() -> {
                            throw new NullPointerException("Such title is not added to the expected list: " + titleText);
                        }
                );
    }
}
