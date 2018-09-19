package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.PurchaseSummaryPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PurchaseSummaryStepDefs extends AbstractStepDefs {

    @Autowired private PurchaseSummaryPage purchaseSummaryPage;

    @Given("^Check that Purchase Summary page is opened.$")
    public void checkThatPurchaseRequestsPageIsOpened() {
        assertTrue(purchaseSummaryPage.isOpened());
    }

    @Then("^Add quick Order block is collapsed on purchase summary page.$")
    public void isFieldAddProductsBySkuInQuickAddProductVisible() {
        assertFalse(purchaseSummaryPage.isFieldAddProductsBySkuInQuickAddProductVisible());
    }

    @When("^Click on quick add product checkbox on purchase summary page.$")
    public void clickOnQuickAddProductCheckBox() {
        purchaseSummaryPage.clickOnAddProductCheckBox();
    }

    @Then("^Check that checkBox is expanded on purchase summary page.$")
    public void checkisFieldAddProductsBySkuInQuickAddProductVisible() {
        assertTrue(purchaseSummaryPage.isFieldAddProductsBySkuInQuickAddProductVisible());
    }
}
