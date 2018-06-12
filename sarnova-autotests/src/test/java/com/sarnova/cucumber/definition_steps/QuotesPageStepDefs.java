package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.QuotesPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class QuotesPageStepDefs extends AbstractStepDefs {

    @Autowired QuotesPage quotesPage;

    @Then("^Check that Quotes page is opened.$")
    public void checkThatQuotesPageIsOpened() {
        assertTrue(quotesPage.isOpened());
    }
}
