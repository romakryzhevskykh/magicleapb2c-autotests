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
        userNotValidPage.refreshCurrentPage();
        assertTrue(userNotValidPage.isOpened());
    }

    @Then("^Appropriate text is displayed on the page.$")
    public void appropriateTextIsDisplayedOnThePage() {
        assertEquals(userNotValidPage.getTitle(), "Customer Registration");
        assertEquals(userNotValidPage.getHelloMessage(), "It seems that your account is inactive.Please contact customer service.");
    }
}
