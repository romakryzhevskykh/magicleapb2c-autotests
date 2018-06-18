package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.PurchasesPerMonthPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class PurchasesPerMonthPageStepDefs extends AbstractStepDefs {

    @Autowired private PurchasesPerMonthPage businessInfoPage;

    @Then("^Check that Purchases Per Month page is opened.$")
    public void checkThatPurchasesPerMonthPageIsOpened() {
        assertTrue(businessInfoPage.isOpened());
    }
}
