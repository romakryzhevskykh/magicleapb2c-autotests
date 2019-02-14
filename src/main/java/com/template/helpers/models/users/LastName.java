package com.template.helpers.models.users;

import java.util.Random;

public enum LastName {
    SMITH("Smith"),
    JOHNSON("Johnson"),
    WILLIAMS("Williams"),
    BROWN("Brown"),
    JONES("Jones"),
    MILLER("Miller"),
    DAVIS("Davis"),
    GARCIA("Garcia"),
    RODRIGUEZ("Rodriguez"),
    WILSON("Wilson"),
    MARTINEZ("Martinez"),
    ANDERSON("Anderson"),
    TAYLOR("Taylor"),
    THOMAS("Thomas"),
    HERNANDEZ("Hernandez"),
    MOORE("Moore"),
    MARTIN("Martin"),
    JACKSON("Jackson"),
    THOMPSON("Thompson"),
    WHITE("White"),
    LOPEZ("Lopez"),
    LEE("Lee"),
    GONZALEZ("Gonzalez"),
    HARRIS("Harris"),
    CLARK("Clark"),
    LEWIS("Lewis"),
    ROBINSON("Robinson"),
    WALKER("Walker"),
    PEREZ("Perez"),
    HALL("Hall"),
    ALLEN("Allen"),
    YOUNG("Young"),
    SANCHEZ("Sanchez"),
    WRIGHT("Wright"),
    KING("King"),
    SCOTT("Scott"),
    GREEN("Green"),
    BAKER("Baker"),
    ADAMS("Adams"),
    NELSON("Nelson"),
    HILL("Hill"),
    RAMIREZ("Ramirez"),
    CAMPBELL("Campbell"),
    MITCHELL("Mitchell"),
    ROBERTS("Roberts"),
    CARTER("Carter"),
    PHILLIPS("Phillips"),
    EVANS("Evans"),
    TURNER("Turner");

    private final String lastName;

    LastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastNameText() {
        return lastName;
    }

    public static LastName getAny() {
        int rnd = new Random().nextInt(values().length);
        return values()[rnd];
    }
}
