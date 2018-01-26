package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.user_engine.UserSessions;
import com.sarnova.storefront.page_blocks.HeaderRowPageBlock;
import com.sarnova.storefront.pages.LoginPage;
import com.sarnova.storefront.pages.StartPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPageStepDefs extends AbstractStepDefs {

    @Autowired UserSessions userSessions;

    @Autowired StartPage startPage;
    @Autowired LoginPage loginPage;
    @Autowired HeaderRowPageBlock headerRowPageBlock;

    @Given("^Opened Login page.$")
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

    @When("^Login to Storefront.$")
    public void loginToStorefront() {
        loginPage.loginToStorefront(userSessions.getActiveUserSession());
    }

    @Then("^Check that Username label is present.$")
    public void checkUsernameLabelIsPresent() {
        assertTrue(loginPage.checkUsernameLabelIsPresent());
    }

    @Then("^Check that Username label text equals to (.*).$")
    public void checkUsernameLabelTextEqualsTo(String usernameLabelText) {
        assertEquals(loginPage.getUsernameLabelText(), usernameLabelText);
    }

    @Then("^Check that Username field is present.$")
    public void checkUsernameFieldIsPresent() {
        assertTrue(loginPage.checkUsernameFieldIsPresent());
    }

    @Then("^Check that Password label is present.$")
    public void checkPasswordLabelIsPresent() {
        assertTrue(loginPage.checkPasswordLabelIsPresent());
    }

    @Then("^Check that Password label text equals to (.*).$")
    public void checkPasswordLabelTextEqualsTo(String passwordLabelText) {
        assertEquals(loginPage.getPasswordLabelText(), passwordLabelText);
    }

    @Then("^Check that Password field is present.$")
    public void checkPasswordFieldIsPresent() {
        assertTrue(loginPage.checkPasswordFieldIsPresent());
    }
}
