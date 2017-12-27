package com.template.cucumber.definition_steps;

import com.template.helpers.user_engine.UsersPool;
import com.template.storefront.page_blocks.HeaderRowPageBlock;
import com.template.storefront.pages.LoginPage;
import com.template.storefront.pages.StartPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginPageStepDefs extends AbstractStepDefs {

    @Autowired UsersPool usersPool;

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
        loginPage.loginToStorefront(usersPool.getActiveUser());
    }
}
