package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.page_blocks.PriceAndAvailabilityBlock;
import com.geempower.storefront.pages.DashboardPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;


public class DashboardStepDefs extends AbstractStepDefs {
    @Autowired
    private DashboardPage dashboardPage;
    @Autowired
    private PriceAndAvailabilityBlock priceAndAvailabilityBlock;

    @And("^Dashboard page is opened.$")
    public void dashboardPageIsOpened() {
        dashboardPage.waitUntilPageIsFullyLoaded();
        if (!dashboardPage.isOpened()) {
            dashboardPage.open();
        }
    }

    @And("^Order Status widget is displayed.$")
    public void orderStatusWidgetIsDisplayed() {
        assertTrue(dashboardPage.orderStatusWidgetIsDisplayed());
    }

    @And("^Featured Updates widget is displayed.$")
    public void featuredUpdatesWidgetIsDisplayed() {
        assertTrue(dashboardPage.featuredUpdatesWidgetIsDisplayed());
    }

    @And("^Order Search widget is displayed.$")
    public void orderSearchWidgetIsDisplayed() {
        assertTrue(dashboardPage.orderSearchWidgetIsDisplayed());
    }

    @And("^Price and Availability widget is displayed.$")
    public void priceAndAvailabilityWidgetIsDisplayed() {
        assertTrue(dashboardPage.priceAndAvailabilityWidgetIsDisplayed());
    }

    @And("^Recent Orders widget is displayed.$")
    public void recentOrdersWidgetIsDisplayed() {
        assertTrue(dashboardPage.recentOrdersWidgetIsDisplayed());
    }

    @Then("^Recent Lists widget is displayed.$")
    public void recentListWidgetIsDisplayed() {
        assertTrue(dashboardPage.recentListWidgetIsDisplayed());
    }

    @When("^Click on Skip button.$")
    public void clickOnSkipButton() {
        dashboardPage.skipTrainingLevel();
    }

    @Then("^Check that Dashboard page is opened.")
    public void isDashboardPageOpened() {
        assertTrue(dashboardPage.isOpened());
    }

    @Then("^Chosen account is displayed in account box on Dashboard page.$")
    public void chosenAccountIsDisplayedInAccountsBoxOnDashboardPage() {
        String chosenAccount = threadVarsHashMap.getString(TestKeyword.CHOSEN_ACCOUNT);
        assertTrue(dashboardPage.isSelectedAccountIsDisplayed().contains(chosenAccount));
    }

    @And("^Click on P&A button.$")
    public void clickOnPAButton() throws Throwable {
        priceAndAvailabilityBlock.clickOnCheckPAButton();
    }

    @When("^User set catalogueNo to Copy & Paste field.$")
    public void userSetCatalogueNoToCopyPasteField() throws Throwable {
        threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        String catalogueNo = getSelectedProducts().keySet().stream().findAny().get().getCatalogueNo();
        priceAndAvailabilityBlock.setCatalogueNoToTheCopyAndPasteField(catalogueNo);
    }
}