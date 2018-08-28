package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.ReplenishmentOrdersPage;
import cucumber.api.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class ReplenishmentOrdersPageStepDefs extends AbstractStepDefs {

    @Autowired private ReplenishmentOrdersPage replenishmentOrdersPage;

    @And("^Check that Replenishment Orders page is opened.$")
    public void checkThatReplenishmentOrdersPageIsOpened() {
        assertTrue(replenishmentOrdersPage.isOpened());
    }
}
