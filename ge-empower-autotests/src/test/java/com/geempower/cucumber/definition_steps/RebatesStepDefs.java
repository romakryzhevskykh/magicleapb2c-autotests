package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.managers.RebateManager;
import com.geempower.helpers.models.Rebate;
import com.geempower.storefront.pages.Rebate.RebatesPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RebatesStepDefs extends AbstractStepDefs {
    @Autowired private RebatesPage rebatesPage;
    @Autowired private RebateManager rebateManager;

    @Then("^(.*) title is displayed on Rebates page.$")
    public void checkAllRebatesTitle(String allRebatesTitle) {
        assertEquals(rebatesPage.getRebatesTitle(), allRebatesTitle);
    }

    @When("Users click on the Create Rebate button on the All Rebates page.$")
    public void clickOnCreateRebateButton(){
        rebatesPage.clickOnCreateRebateButton();
    }

    @Then("^Created rebate is appeared on the All Rebates page.$")
    public void createdRebateIsAppearedOnTheAllRebatesPage() {
        Rebate rebate = rebateManager.getRebateBySpaQuoteNo((long) threadVarsHashMap.get(TestKeyword.REBATE_SPA_NO));
        assertTrue(rebatesPage.isRebateDisplayed(rebate.getId()));
    }
}
