package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.RebatesPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;

public class RebatesStepDefs extends AbstractStepDefs {
    @Autowired
    RebatesPage rebatesPage;

    @Then("^(.*) title is displayed on Rebates page.$")
    public void checkAllRebatesTitle(String allRebatesTitle) {
        assertEquals(rebatesPage.getRebatesTitle(), allRebatesTitle);
    }
}
