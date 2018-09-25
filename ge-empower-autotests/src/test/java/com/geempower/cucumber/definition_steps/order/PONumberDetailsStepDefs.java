package com.geempower.cucumber.definition_steps.order;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.storefront.pages.order.PONumberDetailsPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.*;
import static org.testng.Assert.assertTrue;

public class PONumberDetailsStepDefs extends AbstractStepDefs {
    @Autowired
    private PONumberDetailsPage poNumberDetailsPage;

    @Then("^PO Number Details page is opened.$")
    public void orderDetailsPageIsOpened() {
        assertTrue(poNumberDetailsPage.isOpened(threadVarsHashMap.get(TestKeyword.PO_NO).toString()));
    }

    @Then("^Is (.*) title displayed on Details PO Number page.$")
    public void isPurchaseOrderTitleDisplayedOnDetailsPONumberPage(String title) {
        assertEquals(title, poNumberDetailsPage.getPurchaseOrderTitleOnDetailsPONumberPage());
    }
}
