package com.magicleap.cucumber.definition_steps;

import com.magicleap.helpers.managers.users.UserSessions;
import com.magicleap.storefront.page_blocks.HeaderRowPageBlock;
import com.magicleap.storefront.page_blocks.MiniCartSidebarBlock;
import com.magicleap.storefront.pages.HomePage;
import com.magicleap.storefront.pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class HomePageStepDefs extends AbstractStepDefs {
    @Autowired UserSessions userSessions;

    @Autowired HomePage homePage;
    @Autowired LoginPage loginPage;
    @Autowired HeaderRowPageBlock headerRowPageBlock;
    @Autowired MiniCartSidebarBlock miniCartSidebarBlock;

    @Given("Home page opened.")
    public void openHomePage() {
        if (!homePage.isOpened()) {
            if (headerRowPageBlock.isUserLoggedOut()) {
                //loginPage.open();
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

    @When("^Hover on User Account icon.")
    public void hoverOnUserAccountIcon() throws Throwable {
        headerRowPageBlock.hoverOnUserAccountIcon();
    }

    @And("^Click on Account Settings item in My Account dropdown.")
    public void clickOnAccountSettingsItemInMyAccountDropdown() throws Throwable {
        headerRowPageBlock.clickOnAccountSettingsItemInMyAccountDropDown();
    }

    @And("^Click on Shopping Cart icon.")
    public void clickOnShoppingCartIcon() throws Throwable {
        headerRowPageBlock.clickOnShoppingCartIcon();
    }

    @Then("^Check that Mini Cart sidebar exposed.")
    public void checkThatMiniCartSidebarExposed() throws Throwable {
        assertTrue(miniCartSidebarBlock.isShown());
        assertTrue(homePage.isOverlayEnabled());
    }

    @Given("^Mini Cart sidebar opened.")
    public void openMiniCartSidebar() throws Throwable {
        if(!miniCartSidebarBlock.isShown()){
            if (headerRowPageBlock.isUserLoggedOut()) {
                loginPage.loginToStorefront(userSessions.getActiveUserSession());
            } else {
                headerRowPageBlock.clickOnShoppingCartIcon();
            }
        }
    }

    @Then("^Check that Mini Cart header equals to \"([^\"]*)\".$")
    public void checkThatMiniCartHeaderEqualsTo(String miniCartTitle) throws Throwable {
        assertTrue(miniCartSidebarBlock.getCartTitle().contains(miniCartTitle));
    }

    @Then("^Check that View Cart button is shown.$")
    public void checkThatButtonIsShown() throws Throwable {
        assertTrue(miniCartSidebarBlock.viewCartButtonIsShown());
    }

    @Then("^Check that content block with text \"([^\"]*)\" is shown.$")
    public void checkThatContentBlockWithTextIsShown(String contentBlockText) throws Throwable {
        assertTrue(miniCartSidebarBlock.getContentBlockText().trim().contains(contentBlockText));
    }

    @When("^Click on X button.$")
    public void clickOnXButton() throws Throwable {
        miniCartSidebarBlock.closeMiniCartSideBar();
        miniCartSidebarBlock.waitUntilClosed();
    }

    @Then("^Mini Cart sidebar is closed.$")
    public void miniCartSidebarIsClosed() throws Throwable {
        assertFalse((miniCartSidebarBlock.isShown()));
        assertFalse(homePage.isOverlayEnabled());
    }
}
