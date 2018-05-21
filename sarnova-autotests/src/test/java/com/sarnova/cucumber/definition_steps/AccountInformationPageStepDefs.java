package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.AccountInformationPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class AccountInformationPageStepDefs extends AbstractStepDefs {

    @Autowired private AccountInformationPage accountInformationPage;

    @Then("^Check that Account Information page is opened.$")
    public void checkThatAccountInformationPageIsOpened() {
        assertTrue(accountInformationPage.isOpened());
    }
}
