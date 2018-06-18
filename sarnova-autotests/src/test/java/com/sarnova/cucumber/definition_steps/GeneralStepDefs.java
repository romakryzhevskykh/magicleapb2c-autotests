package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.GeneralPageActivities;
import com.sarnova.storefront.page_blocks.HeaderRowPageBlock;
import com.sarnova.storefront.pages.StartPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GeneralStepDefs extends AbstractStepDefs {
    @Autowired private GeneralPageActivities generalPageActivities;
    @Autowired private HeaderRowPageBlock headerRowPageBlock;
    @Autowired private StartPage startPage;

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

    @When("^Click on Order History item in My Account menu.$")
    public void clickOnOrderHistoryItemInMyAccountMenu() {
        headerRowPageBlock.clickOnOrderHistoryItemInMyAccountMenu();
    }

    @When("^Click on Supply Lists item in My Account menu.$")
    public void clickOnSupplyListsItemInMyAccountMenu() {
        headerRowPageBlock.clickOnSupplyListsItemInMyAccountMenu();
    }

    @When("^Click on Purchase Requests item in My Account menu.$")
    public void clickOnPurchaseRequestsItemInMyAccountMenu() {
        headerRowPageBlock.clickOnPurchaseRequestsItemInMyAccountMenu();
    }

    @When("^Click on Saved Carts item in My Account menu.$")
    public void clickOnSavedCartsItemInMyAccountMenu() {
        headerRowPageBlock.clickOnSavedCartsItemInMyAccountMenu();
    }

    @When("^Click on Saved Credit Cards item in My Account menu.$")
    public void clickOnSavedCreditCardsItemInMyAccountMenu() {
        headerRowPageBlock.clickOnSavedCreditCardsItemInMyAccountMenu();
    }

    @When("^Click on Previously Ordered Items item in My Account menu.$")
    public void clickOnPreviouslyOrderedItemsItemInMyAccountMenu() {
        headerRowPageBlock.clickOnPreviouslyOrderedItemsItemInMyAccountMenu();
    }

    @When("^Click on Quotes item in My Account menu.$")
    public void clickOnQuotesItemInMyAccountMenu() {
        headerRowPageBlock.clickOnQuotesItemInMyAccountMenu();
    }

    @When("^Click on Reports item in My Account menu.$")
    public void clickOnReportsItemInMyAccountMenu() {
        headerRowPageBlock.clickOnReportsItemInMyAccountMenu();
    }

    @When("^Click on Account Information item in My Account menu.$")
    public void clickOnAccountInformationItemInMyAccountMenu() {
        headerRowPageBlock.clickOnAccountInformationItemInMyAccountMenu();
    }

    @When("^Click on Custom Category item in My Account menu.$")
    public void clickOnCustomCategoryItemInMyAccountMenu() {
        headerRowPageBlock.clickOnCustomCategoryItemInMyAccountMenu();
    }

    @When("^Click on Quotas and Par Levels item in My Account menu.$")
    public void clickOnQuotasAndParLevelsItemInMyAccountMenu() {
        headerRowPageBlock.clickOnQuotasAndParLevelsItemInMyAccountMenu();
    }

    @When("^Click on Business Info item in My Account menu.$")
    public void clickOnBusinessInfoItemInMyAccountMenu() {
        headerRowPageBlock.clickOnBusinessInfoItemInMyAccountMenu();
    }

    @When("^Click on Help/New To Boundtree\\? item in My Account menu.$")
    public void clickOnHelpNewToBoundtreeItemInMyAccountMenu() {
        headerRowPageBlock.clickOnHelpNewToBoundtreeItemInMyAccountMenu();
    }

    @When("^Click on Users item in My Account menu.$")
    public void clickOnUsersItemInMyAccountMenu() {
        headerRowPageBlock.clickOnUsersItemInMyAccountMenu();
    }

    @When("^Click on User Groups item in My Account menu.$")
    public void clickOnUserGroupsItemInMyAccountMenu() {
        headerRowPageBlock.clickOnUserGroupsItemInMyAccountMenu();
    }

    @When("^Click on Sign Out item in My Account menu.$")
    public void clickOnSignOutItemInMyAccountMenu() {
        headerRowPageBlock.clickOnSignOutItemInMyAccountMenu(userSessions.getActiveUserSession());
    }

    @And("^Check that current Supply list is displayed in favorite Supply lists drop-down in page header.$")
    public void checkThatCurrentSupplyListIsDisplayedInFavoriteSupplyListsDropDownOnSupplyListDetailsPage() {
        List<String> favoriteSupplyListNames = headerRowPageBlock.getSupplyListNamesFromFavoriteSupplyListsDropDown();
        String testSupplyListName = threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME);
        assertTrue(favoriteSupplyListNames.stream()
                .anyMatch(supplyListName -> supplyListName.equals(StringUtils.capitalize(testSupplyListName))));
    }

    @And("^Check that current Supply list is not displayed in favorite Supply lists drop-down in page header.$")
    public void checkThatCurrentSupplyListIsNotDisplayedInFavoriteSupplyListsDropDownOnSupplyListDetailsPage() {
        List<String> favoriteSupplyListNames = headerRowPageBlock.getSupplyListNamesFromFavoriteSupplyListsDropDown();
        String testSupplyListName = threadVarsHashMap.getString(TestKeyword.SUPPLY_LIST_NAME);
        assertTrue(favoriteSupplyListNames.stream()
                .noneMatch(supplyListName -> supplyListName.equals(StringUtils.capitalize(testSupplyListName))));
    }

    @Then("^Click on Supply lists drop-down in Header.$")
    public void clickOnSupplyListsDropDownInHeader() {
        headerRowPageBlock.clickOnFavoriteSupplyListsDropDown();
    }

    @Then("^Check that Supply lists drop-down is present in Header.$")
    public void checkThatSupplyListsDropDownIsPresentInHeader() {
        assertTrue(headerRowPageBlock.isFavoriteSupplyListsDropDownPresent());
    }
}
