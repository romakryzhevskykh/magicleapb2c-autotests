package com.magicleap.cucumber.definition_steps;

import com.magicleap.storefront.pages.AccountSettingsPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.AssertJUnit.assertTrue;

public class AccountSettingsStepDefs extends AbstractStepDefs{
    @Autowired
    AccountSettingsPage accountSettingsPage;

    @Then("^Check that Account Settings page is opened.")
    public void checkThatAccountSettingsPageIsOpened() throws Throwable {
        assertTrue(accountSettingsPage.isOpened());

    }
}
