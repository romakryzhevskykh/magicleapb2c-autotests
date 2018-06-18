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
    public void accountDashboardPageIsOpened() {
        if (!accountDashboardPage.isOpened()) {
            accountDashboardPage.open();
        }
    }

    @When("^Open Account Dashboard page.$")
    public void openAccountDashboard() {
        accountDashboardPage.open();
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

    @Then("^Check that Purchase Summary item is visible on Account Dashboard page.$")
    public void checkThatPurchaseSummaryItemIsVisible() {
        assertTrue(accountDashboardPage.isPurchaseSummaryItemVisible());
    }

    @Then("^Check that Saved Carts item is visible on Account Dashboard page.$")
    public void checkThatSavedCartsItemIsVisible() {
        assertTrue(accountDashboardPage.isSavedCartsItemVisible());
    }

    @Then("^Check that Supply Lists item is visible on Account Dashboard page.$")
    public void checkThatSupplyListsItemIsVisible() {
        assertTrue(accountDashboardPage.isSupplyListsItemVisible());
    }

    @Then("^Check that Purchases Per Month item is visible on Account Dashboard page.$")
    public void checkThatPurchasesPerMonthItemIsVisible() {
        assertTrue(accountDashboardPage.isPurchasesPerMonthItemVisible());
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

    @Then("^Check that Account Settings item is visible on Account Dashboard page.$")
    public void checkThatAccountSettingsItemIsVisible() {
        assertTrue(accountDashboardPage.isAccountSettingsItemVisible());
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

    @Then("^Check that Replenishment Orders item is visible on Account Dashboard page.$")
    public void checkThatReplenishmentOrdersItemIsVisibleOnAccountDashboardPage() {
        assertTrue(accountDashboardPage.isReplenishmentOrdersItemVisible());
    }

    @Then("^Check that Backordered Items item is visible on Account Dashboard page.$")
    public void checkThatBackorderedItemsItemIsVisibleOnAccountDashboardPage() {
        assertTrue(accountDashboardPage.isBackorderedItemsItemVisible());
    }

    @Then("^Check that Discontinued Items item is visible on Account Dashboard page.$")
    public void checkThatDiscontinuedItemsItemIsVisibleOnAccountDashboardPage() {
        assertTrue(accountDashboardPage.isDiscontinuedItemsItemVisible());
    }

    @Then("^Check that DSCSA Transactions item is visible on Account Dashboard page.$")
    public void checkThatDSCSATransactionsItemIsVisibleOnAccountDashboardPage() {
        assertTrue(accountDashboardPage.isDSCSATransactionsItemVisible());
    }

    @Then("^Check that Pharmaceutical Backorder item is visible on Account Dashboard page.$")
    public void checkThatPharmaceuticalBackorderItemIsVisibleOnAccountDashboardPage() {
        assertTrue(accountDashboardPage.isPharmaceuticalBackorderItemVisible());
    }

    @When("^Click on Order History item on Account Dashboard page.$")
    public void clickOnOrderHistoryItem() {
        accountDashboardPage.clickOnOrderHistoryItem();
    }

    @When("^Click on Previously Ordered Items item on Account Dashboard page.$")
    public void clickOnPreviouslyOrderedItemsItem() {
        accountDashboardPage.clickOnPreviouslyOrderedItemsItem();
    }

    @When("^Click on Purchase Requests item on Account Dashboard page.$")
    public void clickOnPurchaseRequestsItem() {
        accountDashboardPage.clickOnPurchaseRequestsItem();
    }

    @When("^Click on Quotes item on Account Dashboard page.$")
    public void clickOnQuotesItem() {
        accountDashboardPage.clickOnQuotesItem();
    }

    @When("^Click on Purchase Summary item on Account Dashboard page.$")
    public void clickOnPurchaseSummaryItem() {
        accountDashboardPage.clickOnPurchaseSummaryItem();
    }

    @When("^Click on Saved Carts item on Account Dashboard page.$")
    public void clickOnSavedCartsItem() {
        accountDashboardPage.clickOnSavedCartsItem();
    }

    @When("^Click on Supply Lists item on Account Dashboard page.$")
    public void clickOnSupplyListsItem() {
        accountDashboardPage.clickOnSupplyListsItem();
    }

    @When("^Click on Purchases Per Month item on Account Dashboard page.$")
    public void clickOnPurchasesPerMonthItem() {
        accountDashboardPage.clickOnPurchasesPerMonthItem();
    }

    @When("^Click on Users item on Account Dashboard page.$")
    public void ClickOnUsersItem() {
        accountDashboardPage.clickOnUsersItem();
    }

    @When("^Click on Custom Category item on Account Dashboard page.$")
    public void clickOnCustomCategoryItem() {
        accountDashboardPage.clickOnCustomCategoryItem();
    }

    @When("^Click on User Groups item on Account Dashboard page.$")
    public void clickOnUserGroupsItem() {
        accountDashboardPage.clickOnUserGroupsItem();
    }

    @When("^Click on Account Settings item on Account Dashboard page.$")
    public void clickOnAccountSettingsItem() {
        accountDashboardPage.clickOnAccountSettingsItem();
    }

    @When("^Click on Help/New To Boundtree\\? item on Account Dashboard page.$")
    public void clickOnHelpItem() {
        accountDashboardPage.clickOnHelpItem();
    }

    @When("^Click on Saved Credit Cards item on Account Dashboard page.$")
    public void clickOnSavedCreditCardsItem() {
        accountDashboardPage.clickOnSavedCreditCardsItem();
    }

    @When("^Click on Quotas And Par Levels item on Account Dashboard page.$")
    public void clickOnQuotasAndParLevelsItem() {
        accountDashboardPage.clickOnQuotasAndParLevelsItem();
    }

    @When("^Click on Replenishment Orders item on Account Dashboard page.$")
    public void clickOnReplenishmentOrdersItemOnAccountDashboardPage() {
        accountDashboardPage.clickOnReplenishmentOrdersItem();
    }

    @When("^Click on Backordered Items item on Account Dashboard page.$")
    public void clickOnBackorderedItemsItemOnAccountDashboardPage() {
        accountDashboardPage.clickOnBackorderedItemsItem();
    }

    @When("^Click on Discontinued Products item on Account Dashboard page.$")
    public void clickOnDiscontinuedProductsItemOnAccountDashboardPage() {
        accountDashboardPage.clickOnDiscontinuedProductsItem();
    }

    @When("^Click on DSCSA Transactions item on Account Dashboard page.$")
    public void clickOnDSCSATransactionsItemOnAccountDashboardPage() {
        accountDashboardPage.clickOnDSCSATransactionsItem();
    }

    @When("^Click on Pharmaceutical Backorder Report item on Account Dashboard page.$")
    public void clickOnPharmaceuticalBackorderReportItemOnAccountDashboardPage() {
        accountDashboardPage.clickOnPharmaceuticalBackorderReportItem();
    }
}
