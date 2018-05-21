package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.AccountDashboardPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class AccountDashboardPageStepDefs extends AbstractStepDefs {
    @Autowired AccountDashboardPage accountDashboardPage;

    @Given("^Account Dashboard page is opened.$")
    public void openAccountDashboardOpen() {
        if (!accountDashboardPage.isOpened()) {
            accountDashboardPage.open();
        }
    }

    @Then("^Check that Account Dashboard page is opened.$")
    public void checkThatAccountDashboardPageIsOpened() {
        assertTrue(accountDashboardPage.isOpened());
    }

    @Then("^Check that Order History item is visible on Account Dashboard page.$")
    public void checkThatOrderHistoryItemIsVisible() {
        assertTrue(accountDashboardPage.isOrderHistoryItemVisible());
    }

    @Then("^Check that Previously Ordered Items item is visible on Account Dashboard page.$")
    public void checkThatPreviouslyOrderedItemsItemIsVisible() {
        assertTrue(accountDashboardPage.isPreviouslyOrderedItemsItemVisible());
    }

    @Then("^Check that Purchase Requests item is visible on Account Dashboard page.$")
    public void checkThatPurchaseRequestsItemIsVisible() {
        assertTrue(accountDashboardPage.isPurchaseRequestsItemVisible());
    }

    @Then("^Check that Quotes item is visible on Account Dashboard page.$")
    public void checkThatQuotesItemIsVisible() {
        assertTrue(accountDashboardPage.isQuotesItemVisible());
    }

    @Then("^Check that Reports item is visible on Account Dashboard page.$")
    public void checkThatReportsItemIsVisible() {
        assertTrue(accountDashboardPage.isReportsItemVisible());
    }

    @Then("^Check that Saved Carts item is visible on Account Dashboard page.$")
    public void checkThatSavedCartsItemIsVisible() {
        assertTrue(accountDashboardPage.isSavedCartsItemVisible());
    }

    @Then("^Check that Supply Lists item is visible on Account Dashboard page.$")
    public void checkThatSupplyListsItemIsVisible() {
        assertTrue(accountDashboardPage.isSupplyListsItemVisible());
    }

    @Then("^Check that Business info item is visible on Account Dashboard page.$")
    public void checkThatBusinessInfoItemIsVisible() {
        assertTrue(accountDashboardPage.isBusinessInfoItemVisible());
    }

    @Then("^Check that Users item is visible on Account Dashboard page.$")
    public void checkThatUsersItemIsVisible() {
        assertTrue(accountDashboardPage.isUsersItemVisible());
    }

    @Then("^Check that Custom Category item is visible on Account Dashboard page.$")
    public void checkThatCustomCategoryItemIsVisible() {
        assertTrue(accountDashboardPage.isCustomCategoryItemVisible());
    }

    @Then("^Check that User Groups item is visible on Account Dashboard page.$")
    public void checkThatUserGroupsItemIsVisible() {
        assertTrue(accountDashboardPage.isUserGroupsItemVisible());
    }

    @Then("^Check that Account Information item is visible on Account Dashboard page.$")
    public void checkThatAccountInformationItemIsVisible() {
        assertTrue(accountDashboardPage.isAccountInformationItemVisible());
    }

    @Then("^Check that Help/New To Boundtree\\? item is visible on Account Dashboard page.$")
    public void checkThatHelpItemIsVisible() {
        assertTrue(accountDashboardPage.isHelpItemVisible());
    }

    @Then("^Check that Saved Credit Cards item is visible on Account Dashboard page.$")
    public void checkThatSavedCreditCardsItemIsVisible() {
        assertTrue(accountDashboardPage.isSavedCreditCardsItemVisible());
    }

    @Then("^Check that Quotas And Par Levels item is visible on Account Dashboard page.$")
    public void checkThatQuotasAndParLevelsItemIsVisible() {
        assertTrue(accountDashboardPage.isQuotasAndParLevelsItemVisible());
    }

    @Then("^Click on Order History item on Account Dashboard page.$")
    public void clickOnOrderHistoryItem() {
        accountDashboardPage.clickOnOrderHistoryItem();
    }

    @Then("^Click on Previously Ordered Items item on Account Dashboard page.$")
    public void clickOnPreviouslyOrderedItemsItem() {
        accountDashboardPage.clickOnPreviouslyOrderedItemsItem();
    }

    @Then("^Click on Purchase Requests item on Account Dashboard page.$")
    public void clickOnPurchaseRequestsItem() {
        accountDashboardPage.clickOnPurchaseRequestsItem();
    }

    @Then("^Click on Quotes item on Account Dashboard page.$")
    public void clickOnQuotesItem() {
        accountDashboardPage.clickOnQuotesItem();
    }

    @Then("^Click on Reports item on Account Dashboard page.$")
    public void clickOnReportsItem() {
        accountDashboardPage.clickOnReportsItem();
    }

    @Then("^Click on Saved Carts item on Account Dashboard page.$")
    public void clickOnSavedCartsItem() {
        accountDashboardPage.clickOnSavedCartsItem();
    }

    @Then("^Click on Supply Lists item on Account Dashboard page.$")
    public void clickOnSupplyListsItem() {
        accountDashboardPage.clickOnSupplyListsItem();
    }

    @Then("^Click on Business info item on Account Dashboard page.$")
    public void clickOnBusinessInfoItem() {
        accountDashboardPage.clickOnBusinessInfoItem();
    }

    @Then("^Click on Users item on Account Dashboard page.$")
    public void ClickOnUsersItem() {
        accountDashboardPage.clickOnUsersItem();
    }

    @Then("^Click on Custom Category item on Account Dashboard page.$")
    public void clickOnCustomCategoryItem() {
        accountDashboardPage.clickOnCustomCategoryItem();
    }

    @Then("^Click on User Groups item on Account Dashboard page.$")
    public void clickOnUserGroupsItem() {
        accountDashboardPage.clickOnUserGroupsItem();
    }

    @Then("^Click on Account Information item on Account Dashboard page.$")
    public void clickOnAccountInformationItem() {
        accountDashboardPage.clickOnAccountInformationItem();
    }

    @Then("^Click on Help/New To Boundtree\\? item on Account Dashboard page.$")
    public void clickOnHelpItem() {
        accountDashboardPage.clickOnHelpItem();
    }

    @Then("^Click on Saved Credit Cards item on Account Dashboard page.$")
    public void clickOnSavedCreditCardsItem() {
        accountDashboardPage.clickOnSavedCreditCardsItem();
    }

    @When("^Click on Quotas And Par Levels item on Account Dashboard page.$")
    public void clickOnQuotasAndParLevelsItem() {
        accountDashboardPage.clickOnQuotasAndParLevelsItem();
    }
}
