package com.template.cucumber.definition_steps;

import com.template.helpers.user_engine.UserSessions;
import com.template.storefront.page_blocks.HeaderRowPageBlock;
import com.template.storefront.pages.HomePage;
import com.template.storefront.pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;

public class HomePageStepDefs extends AbstractStepDefs {
    
	final static Logger logger = Logger.getLogger(HomePageStepDefs.class);
	
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
    	logger.info("Check Homepage is opened");
        assertTrue(homePage.pageIsOpened(), "Home page is not opened");
    }
    
    @Then("Verify current page is Home page.")
    public void isCurrentURLDashboardURL(){
    	homePage.isCurrentURLDashboardPageURL();
    }
    
    @Then("Check that user is logged in ESAB.")
    public void checkThatUserIsLOggedIn() {
    	logger.info("Check User is logged in");
        assertTrue(homePage.userIsLoggedIn(), "User is not logged in");
    }
    
    @Then ("^Navigate to Shopping Cart by icon in the header.$")
    public void navigateToShoppingCartByIcon(){
    	homePage.navigateToShoppingCartByIcon();
    }
    
}
