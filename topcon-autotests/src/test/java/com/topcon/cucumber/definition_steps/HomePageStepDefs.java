package com.topcon.cucumber.definition_steps;

import com.topcon.helpers.user_engine.UserSessions;
import com.topcon.storefront.page_blocks.HeaderRowPageBlock;
import com.topcon.storefront.pages.HomePage;
import com.topcon.storefront.pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class HomePageStepDefs extends AbstractStepDefs {
    @Autowired UserSessions userSessions;

    @Autowired HomePage homePage;
    @Autowired LoginPage loginPage;
    @Autowired HeaderRowPageBlock headerRowPageBlock;

    @Given("Home page opened.")
    public void openHomePage() {
        if (!homePage.isOpened()) {
            if (headerRowPageBlock.isUserLoggedOut()) {
                loginPage.open();
                loginPage.loginToStorefront(userSessions.getActiveUserSession());
            } else {
                homePage.open();
            }
        }
    }

    @When("Click on My Account menu.")
    public void clickOnMyAccountMenu() {
        headerRowPageBlock.clickOnMyAccountMenu();
    }

    @And("Click on Address Book item in My Account drop down.")
    public void clickOnAddressBookItemInMyAccountDropDown() {
        headerRowPageBlock.clickOnAddressBookItemInMyAccount();
    }

    @Then("Check that Home page is opened.")
    public void checkThatHomePageIsOpened() {
        assertTrue(homePage.isOpened());
    }
}
