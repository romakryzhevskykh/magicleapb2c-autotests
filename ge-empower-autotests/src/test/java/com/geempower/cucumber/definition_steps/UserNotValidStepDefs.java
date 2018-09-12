package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.UserNotValidPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserNotValidStepDefs extends AbstractStepDefs {

    @Autowired
    private UserNotValidPage userNotValidPage;


    @Then("^User sees User not valid page.$")
    public void isUserNotValidPageOpened() {
        assertTrue(userNotValidPage.isOpened());
    }

}