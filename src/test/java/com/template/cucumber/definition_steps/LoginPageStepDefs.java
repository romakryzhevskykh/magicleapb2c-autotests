package com.template.cucumber.definition_steps;

import com.template.helpers.user_engine.UserSessions;
import com.template.storefront.page_blocks.HeaderRowPageBlock;
import com.template.storefront.pages.LoginPageStorefront;
import com.template.storefront.pages.StartPage;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginPageStepDefs extends AbstractStepDefs {

    @Autowired UserSessions userSessions;

    @Autowired StartPage startPage;
    @Autowired LoginPageStorefront loginPageStorefront;
    @Autowired HeaderRowPageBlock headerRowPageBlock;

    @Given("Opened Login page.")
    public void openLoginPage() {
        if (!loginPageStorefront.isOpened()) {
            if(headerRowPageBlock.isUserLoggedIn()) {
                headerRowPageBlock.logoutFromStorefront();
            } else if (!startPage.isOpened()) {
                startPage.open();
            }
            startPage.clickOnSignInButton();
        }
    }

}
