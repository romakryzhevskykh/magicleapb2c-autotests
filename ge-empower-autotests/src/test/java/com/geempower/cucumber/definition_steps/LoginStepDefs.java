package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.LoginPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class LoginStepDefs extends AbstractStepDefs {
    @Autowired
    private LoginPage loginPage;

    @Then("^Login page is opened.$")
    public void checkManageUsersTitle() {
        assertTrue(loginPage.isOpened());
    }
}
