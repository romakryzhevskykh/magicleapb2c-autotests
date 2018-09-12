package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.UserNotActivePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserNotActiveStepDefs extends AbstractStepDefs {
    @Autowired
    private UserNotActivePage userNotActivePage;

    @Then("^User sees User not active page.$")
    public void isUserNotActivePageOpened() {
        assertTrue(userNotActivePage.isOpened());
    }

}