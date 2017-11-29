package com.template.cucumber.definition_steps;

import com.template.helpers.user_engine.UsersPool;
import com.template.storefront.pages.HomePage;
import com.template.storefront.pages.LoginPage;
import com.template.storefront.pages.StartPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class HomePageStepDefs extends AbstractStepDefs {

    @Autowired UsersPool usersPool;

    @Autowired HomePage homePage;
    @Autowired LoginPage loginPage;
    @Autowired StartPage startPage;

    @Given("^Home page opened.$")
    public void openHomePage() {
        if (!usersPool.getActiveUser().isLoggedIn()) {
            if (!loginPage.isOpened()) {
                startPage.open();
                startPage.openLoginPage();
            }
            loginPage.loginAs(usersPool.getActiveUser());
        } else if (!homePage.isOpened()) {
            homePage.open();
        }
    }

    @When("^Open Address book page$")
    public void openAddressBookPage() {
        homePage.moveCursorToMyAccountDropDown();
        homePage.waitUntilShippingAddressBookItemIsVisible();
        homePage.clickOnShippingAddressBookItem();
    }

    @And("^Move cursor to my account drop down.$")
    public void moveCursorToMyAccountDropDown() {
        homePage.moveCursorToMyAccountDropDown();
    }

    @And("^Wait until Shipping Address Book item is visible in My Account drop down.$")
    public void waitUntilShippingAddressBookItemIsVisible() {
        homePage.waitUntilShippingAddressBookItemIsVisible();
    }

    @And("^Click on Shipping Address Book item in My Account drop down.$")
    public void clickOnShippingAddressBookItem() {
        homePage.clickOnShippingAddressBookItem();
    }

    @Then("^Check that Home page is opened.$")
    public void checkHomePageIsOpened() {
        assertTrue(usersPool.getActiveUser().isLoggedIn() && homePage.isOpened());
    }
}
