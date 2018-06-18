package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.models.credit_cards.CreditCard;
import com.sarnova.pay_fabric.models.CustomerWallet;
import com.sarnova.pay_fabric.pages.CustomerWalletsPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PayFabricWalletsPageStepDefs extends AbstractStepDefs {
    @Autowired CustomerWalletsPage customerWalletsPage;

    @Then("^Check that Credit card is displayed on Pay Fabric Wallets page.$")
    public void checkThatCreditCardIsDisplayed() {
        CreditCard creditCard = (CreditCard) threadVarsHashMap.get(TestKeyword.CREDIT_CARD);
        CustomerWallet customerWallet = customerWalletsPage.getLastWalletInTheList();
        LocalDateTime timeOfAction = (LocalDateTime) threadVarsHashMap.get(TestKeyword.LOCAL_DATE_TIME_OF_ACTION);
        assertEquals(creditCard.getNameOnCard(), customerWallet.getFirstName() + " " + customerWallet.getLastName());
        assertEquals(creditCard.getCardNumber().substring(12), customerWallet.getAccount().substring(12));
        assertTrue(Math.abs(ChronoUnit.SECONDS.between(timeOfAction, customerWallet.getTransactionDateTime())) < 10);
    }
}
