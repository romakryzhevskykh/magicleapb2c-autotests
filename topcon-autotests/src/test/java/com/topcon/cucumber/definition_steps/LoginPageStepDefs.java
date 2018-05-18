package com.topcon.cucumber.definition_steps;

import com.topcon.helpers.user_engine.UserSessions;
import com.topcon.storefront.page_blocks.HeaderRowPageBlock;
import com.topcon.storefront.pages.LoginPage;
import com.topcon.storefront.pages.StartPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginPageStepDefs extends AbstractStepDefs {

    @Autowired private StartPage startPage;
    @Autowired private LoginPage loginPage;
    @Autowired private HeaderRowPageBlock headerRowPageBlock;

    @Given("Opened Login page.")
    public void openLoginPage() {
        if (!loginPage.isOpened()) {
            if(headerRowPageBlock.isUserLoggedIn()) {
                headerRowPageBlock.logoutFromStorefront();
            } else if (!startPage.isOpened()) {
                startPage.open();
            }
            startPage.clickOnSignInButton();
        }
    }

    @When("Login to Storefront.")
    public void loginToStorefront() {
        loginPage.loginToStorefront(userSessions.getActiveUserSession());
    }
}
