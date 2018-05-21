package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.QuotasAndParLevelsPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class QuotasAndParLevelsPageStepDefs extends AbstractStepDefs {

    @Autowired private QuotasAndParLevelsPage quotasAndParLevelsPage;

    @Then("^Check that Quotas and Par Levels page is opened.$")
    public void checkThatQuotasAndParLevelsPageIsOpened() {
        assertTrue(quotasAndParLevelsPage.isOpened());
    }
}
