package com.sarnova.helpers.models.users;

import java.util.stream.Stream;

public enum SecurityQuestion {
    STREET_WHERE_YOU_GREW_UP("sq1_grew_up_street", "Street where you grew up?"),
    MOTHERS_MAIDEN_NAME("sq5_mothers_maiden_name", "Mother's maiden name?"),
    FAVOURITE_MOVIE_CHARACTER("sq4_fav_movie_character", "Favorite movie character?"),
    FIRST_PETS_NAME("sq2_first_pet_name", "First pet's name?"),
    FAVOURITE_SPORTS_TEAM("sq3_fav_sport_team", "Favorite sports team?");

    private String identificator;
    private String questionText;

    SecurityQuestion(String identificator, String questionText) {
        this.identificator = identificator;
        this.questionText = questionText;
    }

    public static SecurityQuestion getAny() {
        return Stream.of(values()).findAny().get();
    }

    public String getIdentificator() {
        return identificator;
    }

    public String getQuestionText() {
        return questionText;
    }
}
