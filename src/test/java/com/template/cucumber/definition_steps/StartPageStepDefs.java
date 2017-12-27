package com.template.cucumber.definition_steps;

import com.template.storefront.page_blocks.HeaderRowPageBlock;
import com.template.storefront.pages.StartPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class StartPageStepDefs extends AbstractStepDefs {

    @Autowired StartPage startPage;
    @Autowired HeaderRowPageBlock headerRowPageBlock;

    @Given("Opened Start page.")
    public void openLoginPage() {
        if (!startPage.isStartPageOpened()) {
            if(headerRowPageBlock.isUserLoggedIn()) {
                headerRowPageBlock.logoutFromStorefront();
            } else if (!startPage.isStartPageOpened()) {
                startPage.openStartPage();
            }
        }
    }

    @When("Click on Sign in button.")
    public void clickOnSignInButton() {
        startPage.clickOnSignInButton();
    }

}
