package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.PurchaseSummaryPage;
import cucumber.api.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class PurchaseSummaryStepDefs extends AbstractStepDefs {

    @Autowired private PurchaseSummaryPage purchaseSummaryPage;

    @And("^Check that Purchase Summary page is opened.$")
    public void checkThatPurchaseSummaryPageIsOpened() {
        assertTrue(purchaseSummaryPage.isOpened());
    }
}
