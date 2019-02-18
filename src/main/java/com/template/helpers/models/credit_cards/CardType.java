package com.template.helpers.models.credit_cards;

import java.util.Random;
import java.util.stream.Stream;

public enum CardType {
    MASTERCARD("Mastercard"),
    VISA("Visa"),
    DISCOVER("Discover"),
    AMERICAN_EXPRESS("American Express");

    private String typeTextName;

    CardType(String typeTextName) {
        this.typeTextName = typeTextName;
    }

    public static CardType byTextName(String cardTypeName) {
        return Stream.of(values())
                .filter(cardType -> cardType.getTypeTextName().equalsIgnoreCase(cardTypeName))
                .findAny()
                .orElseGet(() -> {
                    throw new NullPointerException("Card type: " + cardTypeName + " is not existed.");
                });
    }

    private String getTypeTextName() {
        return typeTextName;
    }

    public static CardType cardTypeByTextMarker(String typeTextName) {
        return Stream.of(values()).filter(cardType -> cardType.getTypeTextName().equals(typeTextName)).findAny()
                .orElseGet(() -> {
                    throw new NullPointerException("Card with text type: " + typeTextName + " is not present in Types list.");
                });
    }

    public static CardType getAny() {
        Random rand = new Random();
        return values()[(rand.nextInt(values().length))];
    }

    public String getName() {
        return this.typeTextName;
    }
}
