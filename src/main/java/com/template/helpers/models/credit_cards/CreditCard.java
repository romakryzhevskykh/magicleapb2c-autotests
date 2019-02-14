package com.template.helpers.models.credit_cards;

import com.template.helpers.models.addresses.BillingAddress;
import lombok.Getter;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class CreditCard {
    @Getter private BillingAddress billingAddress;
    @Getter private CardType cardType;
    @Getter private String cardNumber;
    @Getter private String expirationMonth;
    @Getter private String expirationYear;
    @Getter private String cvv;

    public CreditCard(CardType cardType, String cardNumber, String expirationMonth, String expirationYear, String cvv, BillingAddress billingAddress) {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.expirationMonth = expirationMonth.length() == 1 ? "0" + expirationMonth : expirationMonth;
        this.expirationYear = expirationYear;
        this.cvv = cvv;
        this.billingAddress = billingAddress;
    }

    @Override
    public boolean equals(Object other) {
        if ((other == null) || !((this instanceof CreditCard))) {
            return false;
        }

        CreditCard compareObj = (CreditCard) other;
        return new EqualsBuilder()
                .append(this.cardType, compareObj.cardType)
                .append(this.cardNumber.substring(this.cardNumber.length() - 4), compareObj.cardNumber.substring(compareObj.cardNumber.length() - 4))
                .append(this.expirationMonth, compareObj.expirationMonth)
                .append(this.expirationYear, compareObj.expirationYear)
                .append(this.billingAddress, compareObj.billingAddress)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(cardNumber)
                .append(expirationMonth)
                .append(expirationYear)
                .append(billingAddress)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "cardNum: " + cardNumber + ", Billing address: " + billingAddress;
    }
}
