package com.magicleap.cucumber.definition_steps;

import com.magicleap.helpers.managers.users.UserSessions;
import com.magicleap.storefront.page_blocks.HeaderRowPageBlock;
import com.magicleap.storefront.pages.LoginPage;
import com.magicleap.storefront.pages.StartPage;
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
