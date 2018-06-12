package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.BusinessInfoPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class BusinessInfoPageStepDefs extends AbstractStepDefs {

    @Autowired private BusinessInfoPage businessInfoPage;

    @Then("^Check that Business Info page is opened.$")
    public void checkThatBusinessInfoPageIsOpened() {
        assertTrue(businessInfoPage.isOpened());
    }
}
