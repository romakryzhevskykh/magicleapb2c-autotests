package com.topcon.cucumber.definition_steps;

import com.topcon.storefront.page_blocks.HeaderRowPageBlock;
import com.topcon.storefront.pages.LoginPage;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;


public class PreConditionsStepDefs extends AbstractStepDefs {
    @Autowired
    private
    HeaderRowPageBlock headerRowPageBlock;
    @Autowired
    private
    LoginPage loginPage;

    @Given("^User is logged in to Storefront.$")
    public void userIsLoggedInToStorefront() {
        if (!headerRowPageBlock.isUserLoggedIn()) {
            loginPage.open();
            loginPage.loginToStorefront(userSessions.getActiveUserSession());
        }
    }

}
