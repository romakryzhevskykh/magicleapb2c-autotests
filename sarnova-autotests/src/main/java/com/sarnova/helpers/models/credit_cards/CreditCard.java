package com.sarnova.helpers.models.credit_cards;

public class CreditCard {
    private final String cardNumber;
    private final String expiryMonth;
    private final String expiryYear;
    private final String nameOnCard;
    private final String cvv;

    public CreditCard(String cardNumber, String expiryMonth, String expiryYear, String nameOnCard, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryMonth = expiryMonth.length() == 1 ? "0" + expiryMonth : expiryMonth;
        this.expiryYear = expiryYear;
        this.nameOnCard = nameOnCard;
        this.cvv = cvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public String getShortExpiryYear() {
        return getExpiryYear().substring(2);
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public String getCvv() {
        return cvv;
    }
}
