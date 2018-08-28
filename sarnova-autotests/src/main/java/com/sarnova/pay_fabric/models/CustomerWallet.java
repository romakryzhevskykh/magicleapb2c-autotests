package com.sarnova.pay_fabric.models;

import java.time.LocalDateTime;

public class CustomerWallet {
    private final String customerId;
    private final String tender;
    private final String cardType;
    private final String account;
    private final String firstName;
    private final String lastName;
    private final LocalDateTime transactionDateTime;


    public CustomerWallet(String customerId, String tender, String cardType, String account, String firstName, String lastName, LocalDateTime transactionDateTime) {
        this.customerId = customerId;
        this.tender = tender;
        this.cardType = cardType;
        this.account = account;
        this.firstName = firstName;
        this.lastName = lastName;
        this.transactionDateTime = transactionDateTime;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getTender() {
        return tender;
    }

    public String getCardType() {
        return cardType;
    }

    public String getAccount() {
        return account;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }
}
