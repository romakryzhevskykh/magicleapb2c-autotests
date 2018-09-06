package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.QuickOrderPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.*;

public class QuickOrderStepDefs extends AbstractStepDefs {
    @Autowired QuickOrderPage quickOrderPage;

    @Given("^Quick order page is opened.$")
    public void quickOrderPageIsOpened() {
        if(!quickOrderPage.isOpened()) {
            quickOrderPage.open();
        }
    }

    @Then("^Check that Add to Supply list button is visible on Quick order page.$")
    public void checkThatAddToSupplyListButtonIsVisible() {
        assertTrue(quickOrderPage.isAddToSupplyListButtonVisible());
    }

    @Then("^Check that Add to Supply list button is enabled on Quick order page.$")
    public void checkThatAddToSupplyListButtonIsEnabled() {
        assertTrue(quickOrderPage.isAddToSupplyListButtonEnabled());
    }

    @Then("^Check that Add to Supply list button is not visible on Quick order page.$")
    public void checkThatAddToSupplyListButtonIsNotVisibleOnQuickOrderPage() {
        assertFalse(quickOrderPage.isAddToSupplyListButtonVisible());
    }
}
