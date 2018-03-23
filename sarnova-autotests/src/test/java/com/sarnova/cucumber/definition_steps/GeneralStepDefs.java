package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.GeneralPageActivities;
import com.sarnova.storefront.page_blocks.HeaderRowPageBlock;
import com.sarnova.storefront.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GeneralStepDefs extends AbstractStepDefs {
    @Autowired private GeneralPageActivities generalPageActivities;
    @Autowired HeaderRowPageBlock headerRowPageBlock;
    @Autowired StartPage startPage;
    @Autowired AccountDashboardPage accountDashboardPage;
    @Autowired OrderHistoryPage orderHistoryPage;
    @Autowired SupplyListsPage supplyListsPage;
    @Autowired SavedCartsPage savedCartsPage;
    @Autowired SavedCreditCardsPage savedCreditCardsPage;
    @Autowired QuotesPage quotesPage;
    @Autowired ReportsPage reportsPage;
    @Autowired AccountInformationPage accountInformationPage;
    @Autowired CustomCategoryPage customCategoryPage;
    @Autowired HelpNewToBoundtreePage helpNewToBoundtreePage;

    @And("^Refresh page.$")
    public void refreshPage() throws Throwable {
        generalPageActivities.refreshPage();
    }

    @Then("^Check that (.*) item is present in My Account menu.$")
    public void checkThatItemIsPresentInMyAccountMenu(String menuItemName) {
        List<String> myAccountItemNames = headerRowPageBlock.getMyAccountMenuNames();
        assertTrue(myAccountItemNames.contains(menuItemName));
    }

    @And("^Check that (.*) item index item is (\\d+).$")
    public void checkThatAccountDashboardItemIndexItemIs(String menuItemName, int itemIndexNumber) {
        int rowIndex = headerRowPageBlock.getIndexOfMyAccountMenuItemByName(menuItemName);
        assertEquals(rowIndex, itemIndexNumber);
    }

    @And("^My Account menu is opened.$")
    public void myAccountMenuIsOpened() {
        headerRowPageBlock.openMyAccountMenu();
    }

    @Then("^Check that My Account menu has only (\\d+) items.$")
    public void checkThatMyAccountMenuHasOnlyItems(int expectedNumberOfMyAccountItems) {
        assertEquals(headerRowPageBlock.getMyAccountMenuNames().size(), expectedNumberOfMyAccountItems);
    }

    @When("^Click on Account Dashboard item in My Account menu.$")
    public void clickOnAccountDashboardItemInMyAccountMenu() {
        headerRowPageBlock.clickOnAccountDashboardItemInMyAccountMenu();
    }

    @Then("^Check that Account Dashboard page is opened.$")
    public void checkThatAccountDashboardPageIsOpened() {
        assertTrue(accountDashboardPage.isOpened());
    }

    @When("^Click on Order History item in My Account menu.$")
    public void clickOnOrderHistoryItemInMyAccountMenu() {
        headerRowPageBlock.clickOnOrderHistoryItemInMyAccountMenu();
    }

    @Then("^Check that Order History page is opened.$")
    public void checkThatOrderHistoryPageIsOpened() {
        assertTrue(orderHistoryPage.isOpened());
    }

    @When("^Click on Supply Lists item in My Account menu.$")
    public void clickOnSupplyListsItemInMyAccountMenu() {
        headerRowPageBlock.clickOnSupplyListsItemInMyAccountMenu();
    }

    @Then("^Check that Supply Lists page is opened.$")
    public void checkThatSupplyListsPageIsOpened() {
        assertTrue(supplyListsPage.isOpened());
    }

    @When("^Click on Saved Carts item in My Account menu.$")
    public void clickOnSavedCartsItemInMyAccountMenu() {
        headerRowPageBlock.clickOnSavedCartsItemInMyAccountMenu();
    }

    @Then("^Check that Saved Carts page is opened.$")
    public void checkThatSavedCartsPageIsOpened() {
        assertTrue(savedCartsPage.isOpened());
    }

    @When("^Click on Saved Credit Cards item in My Account menu.$")
    public void clickOnSavedCreditCardsItemInMyAccountMenu() {
        headerRowPageBlock.clickOnSavedCreditCardsItemInMyAccountMenu();
    }

    @Then("^Check that Saved Credit Cards page is opened.$")
    public void checkThatSavedCreditCardsPageIsOpened() {
        assertTrue(savedCreditCardsPage.isOpened());
    }

    @When("^Click on Quotes item in My Account menu.$")
    public void clickOnQuotesItemInMyAccountMenu() {
        headerRowPageBlock.clickOnQuotesItemInMyAccountMenu();
    }

    @Then("^Check that Quotes page is opened.$")
    public void checkThatQuotesPageIsOpened() {
        assertTrue(quotesPage.isOpened());
    }

    @When("^Click on Reports item in My Account menu.$")
    public void clickOnReportsItemInMyAccountMenu() {
        headerRowPageBlock.clickOnReportsItemInMyAccountMenu();
    }

    @And("^Check that Reports page is opened.$")
    public void checkThatReportsPageIsOpened() {
        assertTrue(reportsPage.isOpened());
    }

    @When("^Click on Account Information item in My Account menu.$")
    public void clickOnAccountInformationItemInMyAccountMenu() {
        headerRowPageBlock.clickOnAccountInformationItemInMyAccountMenu();
    }

    @Then("^Check that Account Information page is opened.$")
    public void checkThatAccountInformationPageIsOpened() {
        assertTrue(accountInformationPage.isOpened());
    }

    @When("^Click on Custom Category item in My Account menu.$")
    public void clickOnCustomCategoryItemInMyAccountMenu() {
        headerRowPageBlock.clickOnCustomCategoryItemInMyAccountMenu();
    }

    @Then("^Check that Custom Category page is opened.$")
    public void checkThatCustomCategoryPageIsOpened() {
        assertTrue(customCategoryPage.isOpened());
    }

    @When("^Click on Help/New To Boundtree\\? item in My Account menu.$")
    public void clickOnHelpNewToBoundtreeItemInMyAccountMenu() {
        headerRowPageBlock.clickOnHelpNewToBoundtreeItemInMyAccountMenu();
    }

    @Then("^Check that Help/New To Boundtree\\? page is opened.$")
    public void checkThatHelpNewToBoundtreePageIsOpened() {
        assertTrue(helpNewToBoundtreePage.isOpened());
    }

    @When("^Click on Sign Out item in My Account menu.$")
    public void clickOnSignOutItemInMyAccountMenu() {
        headerRowPageBlock.clickOnSignOutItemInMyAccountMenu(userSessions.getActiveUserSession());
    }

    @Then("^Check that Start page is opened.$")
    public void checkThatStartPageIsOpened() {
        assertTrue(startPage.isOpened());
    }
}
