package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.Rebate.RebatesPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RebatesStepDefs extends AbstractStepDefs {
    @Autowired private RebatesPage rebatesPage;

    @Then("^(.*) title is displayed on Rebates page.$")
    public void checkAllRebatesTitle(String allRebatesTitle) {
        assertEquals(rebatesPage.getRebatesTitle(), allRebatesTitle);
    }

    @When("Users click on the Create Rebate button on the All Rebates page.$")
    public void clickOnCreateRebateButton(){
        rebatesPage.clickOnCreateRebateButton();
    }

}
