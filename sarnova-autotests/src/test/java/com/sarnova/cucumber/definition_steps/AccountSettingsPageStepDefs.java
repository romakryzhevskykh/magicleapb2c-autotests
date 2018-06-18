package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.AccountSettingsPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class AccountSettingsPageStepDefs extends AbstractStepDefs {

    @Autowired private AccountSettingsPage accountSettingsPage;

    @Then("^Check that Account Settings page is opened.$")
    public void checkThatAccountSettingsPageIsOpened() {
        assertTrue(accountSettingsPage.isOpened());
    }
}
