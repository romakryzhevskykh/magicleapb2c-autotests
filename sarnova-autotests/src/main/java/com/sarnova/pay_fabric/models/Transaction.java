package com.sarnova.pay_fabric.models;

import java.time.LocalDateTime;

public class Transaction {
    private final LocalDateTime transactionDateTime;
    private final String accountNumber;
    private final String expDate;
    private final String amountUSD;
    private final String customerName;

    public Transaction(LocalDateTime transactionDateTime, String accountNumber, String expDate, String amountUSD, String customerName) {
        this.transactionDateTime = transactionDateTime;
        this.accountNumber = accountNumber;
        this.expDate = expDate;
        this.amountUSD = amountUSD;
        this.customerName = customerName;
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getExpDate() {
        return expDate;
    }

    public String getAmountUSD() {
        return amountUSD;
    }

    public String getCustomerName() {
        return customerName;
    }
}
