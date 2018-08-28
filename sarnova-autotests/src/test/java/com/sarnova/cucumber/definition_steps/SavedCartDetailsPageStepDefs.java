package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.SavedCartDetailsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class SavedCartDetailsPageStepDefs extends AbstractStepDefs {

    @Autowired private SavedCartDetailsPage savedCartDetailsPage;

    @When("^Open Saved Cart details page.$")
    public void openSavedCartDetailsPage() {
        String savedCartId = threadVarsHashMap.getString(TestKeyword.SAVED_CART_ID);
        savedCartDetailsPage.open(savedCartId);
    }

    @Then("^Check that Label is visible on Saved Cart Details page.$")
    public void checkThatSavedCartDetailsPageLabelIsVisible() {
        assertTrue(savedCartDetailsPage.isLabelVisible());
    }

    @Then("^Check that Saved cart details page is opened.$")
    public void checkThatSavedCartDetailsPageIsOpened() {
        String savedCartId = threadVarsHashMap.getString(TestKeyword.SAVED_CART_ID);
        assertTrue(savedCartDetailsPage.isOpened(savedCartId));
    }

    @Then("^Check that Restore button is visible on Saved Cart details page.$")
    public void checkThatRestoreButtonIsVisibleOnSavedCartDetailsPage() {
        assertTrue(savedCartDetailsPage.isRestoreButtonVisible());
    }

    @And("^Check that Edit button is visible on Saved Cart details page.$")
    public void checkThatEditButtonIsVisibleOnSavedCartDetailsPage() {
        assertTrue(savedCartDetailsPage.isEditButtonVisible());
    }

    @And("^Check that Delete cart button is visible on Saved Cart details page.$")
    public void checkThatDeleteCartButtonIsVisibleOnSavedCartDetailsPage() {
        assertTrue(savedCartDetailsPage.isDeleteCartButtonVisible());
    }

    @And("^Check that Products are visible on Saved Cart details page.$")
    public void checkThatProductsAreVisibleOnSavedCartDetailsPage() {
        assertTrue(savedCartDetailsPage.isUnitsOfMeasureItemsVisible());
    }
}
