package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.managers.SavedCartsManager;
import com.sarnova.helpers.models.saved_carts.SavedCart;
import com.sarnova.storefront.pages.SavedCartsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class SavedCartsPageStepDefs extends AbstractStepDefs {
    @Autowired SavedCartsPage savedCartsPage;
    @Autowired SavedCartsManager savedCartsManager;

    @Then("^Check that Saved Carts header title is present on Saved Carts page.$")
    public void checkThatSavedCartsTitleIsVisible() {
        assertTrue(savedCartsPage.isSavedCartsTitleVisible());
    }

    @When("^Open Saved Carts page.$")
    public void openSavedCartsPage() {
        savedCartsPage.open();
    }

    @Then("^Check that Saved Carts page is opened.$")
    public void checkThatSavedCartsPageIsOpened() {
        assertTrue(savedCartsPage.isOpened());
    }

    @Then("^Check that Saved cart is visible on Saved Carts page.$")
    public void checkThatSavedCartIsVisibleOnSavedCartsPage() {
        String savedCartId = threadVarsHashMap.getString(TestKeyword.SAVED_CART_ID);
        assertTrue(savedCartsPage.getSavedCartsIds().contains(savedCartId));
    }

    @And("^Check that Saved cart Restore button is visible on Saved Carts page.$")
    public void checkThatSavedCartRestoreButtonIsVisibleOnSavedCartsPage() {
        String savedCartId = threadVarsHashMap.getString(TestKeyword.SAVED_CART_ID);
        SavedCart savedCart = savedCartsManager.getCartById(savedCartId);
        assertTrue(savedCartsPage.isSavedCartRestoreButtonVisible(savedCart));
    }

    @And("^Check that Saved cart Remove button is visible on Saved Carts page.$")
    public void checkThatSavedCartRemoveButtonIsVisibleOnSavedCartsPage() {
        String savedCartId = threadVarsHashMap.getString(TestKeyword.SAVED_CART_ID);
        SavedCart savedCart = savedCartsManager.getCartById(savedCartId);
        assertTrue(savedCartsPage.isSavedCartRemoveButtonVisible(savedCart));
    }
}
