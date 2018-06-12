package com.sarnova.helpers.managers;

import com.sarnova.helpers.models.credit_cards.CreditCard;
import org.springframework.stereotype.Component;

@Component
public class CreditCardsManager {

    public CreditCard createInstance(String cardNumber, String expiryMonth, String expiryYear, String nameOnCard, String cvv) {
        return new CreditCard(cardNumber, expiryMonth, expiryYear, nameOnCard, cvv);
    }
}
