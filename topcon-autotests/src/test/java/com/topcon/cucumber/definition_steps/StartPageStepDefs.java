package com.topcon.cucumber.definition_steps;

import com.topcon.storefront.page_blocks.HeaderRowPageBlock;
import com.topcon.storefront.pages.StartPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class StartPageStepDefs extends AbstractStepDefs {

    @Autowired StartPage startPage;
    @Autowired HeaderRowPageBlock headerRowPageBlock;

    @Given("Opened Start page.")
    public void openLoginPage() {
        if (!startPage.isOpened()) {
            if(headerRowPageBlock.isUserLoggedIn()) {
                headerRowPageBlock.logoutFromStorefront();
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
