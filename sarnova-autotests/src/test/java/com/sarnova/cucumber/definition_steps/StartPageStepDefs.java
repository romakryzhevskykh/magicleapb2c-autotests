package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.page_blocks.HeaderRowPageBlock;
import com.sarnova.storefront.pages.StartPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class StartPageStepDefs extends AbstractStepDefs {

    @Autowired StartPage startPage;
    @Autowired HeaderRowPageBlock headerRowPageBlock;

    @Then("^Check that Start page is opened.$")
    public void checkThatStartPageIsOpened() {
        assertTrue(startPage.isOpened());
    }

    @Given("Opened Start page.")
    public void openLoginPage() {
        if (!startPage.isOpened()) {
            if(headerRowPageBlock.isUserLoggedIn()) {
                headerRowPageBlock.logoutFromStorefront(userSessions.getActiveUserSession());
            } else if (!startPage.isOpened()) {
                startPage.open();
            }
        }
    }

    @When("Click on Sign in button.")
    public void clickOnSignInButton() {
        startPage.clickOnSignInButton();
    }
}
