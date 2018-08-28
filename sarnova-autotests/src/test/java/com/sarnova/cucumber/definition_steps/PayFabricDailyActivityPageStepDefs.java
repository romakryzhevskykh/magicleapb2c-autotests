package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.models.credit_cards.CreditCard;
import com.sarnova.pay_fabric.models.Transaction;
import com.sarnova.pay_fabric.pages.DailyActivityPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PayFabricDailyActivityPageStepDefs extends AbstractStepDefs {
    @Autowired DailyActivityPage dailyActivityPage;

    @When("^Click on Run report on Pay Fabric Daily activity page.$")
    public void clickOnRunReport() {
        dailyActivityPage.clickOnRunReportButton();
    }

    @Then("^Check that transaction is displayed on Pay Fabric Daily activity page.$")
    public void checkThatTransactionIsDisplayedOnPayFabricDailyActivityPage() {
        LocalDateTime timeOfAction = (LocalDateTime) threadVarsHashMap.get(TestKeyword.LOCAL_DATE_TIME_OF_ACTION);
        CreditCard creditCard = (CreditCard) threadVarsHashMap.get(TestKeyword.CREDIT_CARD);
        Transaction transaction = dailyActivityPage.getLastTransactionInTheList();

        assertEquals(creditCard.getCardNumber().substring(12), transaction.getAccountNumber().substring(12));
        assertEquals(creditCard.getExpiryMonth() + creditCard.getShortExpiryYear(), transaction.getExpDate());
        assertTrue(Math.abs(ChronoUnit.SECONDS.between(timeOfAction, transaction.getTransactionDateTime())) < 10);
    }
}
