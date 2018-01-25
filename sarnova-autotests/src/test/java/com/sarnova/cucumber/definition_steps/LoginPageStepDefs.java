package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.user_engine.UserSessions;
import com.sarnova.storefront.page_blocks.HeaderRowPageBlock;
import com.sarnova.storefront.pages.LoginPage;
import com.sarnova.storefront.pages.StartPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginPageStepDefs extends AbstractStepDefs {

    @Autowired UserSessions userSessions;

    @Autowired StartPage startPage;
    @Autowired LoginPage loginPage;
    @Autowired HeaderRowPageBlock headerRowPageBlock;

    @Given("Opened Login page.")
    public void openLoginPage() {
        if (!loginPage.isLoginPageOpened()) {
            if(headerRowPageBlock.isUserLoggedIn()) {
                headerRowPageBlock.logoutFromStorefront();
            } else if (!startPage.isStartPageOpened()) {
                startPage.openStartPage();
            }
            startPage.clickOnSignInButton();
        }
    }

    @When("Login to Storefront.")
    public void loginToStorefront() {
        loginPage.loginToStorefront(userSessions.getActiveUserSession());
    }
}
