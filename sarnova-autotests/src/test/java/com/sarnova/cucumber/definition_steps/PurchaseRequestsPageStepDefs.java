package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.PurchaseRequestsPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class PurchaseRequestsPageStepDefs extends AbstractStepDefs {

    @Autowired private PurchaseRequestsPage purchaseRequestsPage;

    @Then("^Check that Purchase Requests page is opened.$")
    public void checkThatPurchaseRequestsPageIsOpened() {
        assertTrue(purchaseRequestsPage.isOpened());
    }

}
