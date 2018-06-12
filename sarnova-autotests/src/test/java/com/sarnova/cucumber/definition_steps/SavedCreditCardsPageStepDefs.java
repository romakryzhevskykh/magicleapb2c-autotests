package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.SavedCreditCardsPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class SavedCreditCardsPageStepDefs extends AbstractStepDefs {
    @Autowired SavedCreditCardsPage savedCreditCardsPage;

    @Then("^Check that Saved Credit Cards page is opened.$")
    public void checkThatSavedCreditCardsPageIsOpened() {
        assertTrue(savedCreditCardsPage.isOpened());
    }
}
