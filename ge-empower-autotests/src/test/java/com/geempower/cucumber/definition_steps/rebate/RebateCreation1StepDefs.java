package com.geempower.cucumber.definition_steps.rebate;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.helpers.models.Product;
import com.geempower.storefront.pages.rebate.RebateCreation1Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

import static org.testng.Assert.assertTrue;

public class RebateCreation1StepDefs extends AbstractStepDefs {

    @Autowired
    private RebateCreation1Page rebateCreation1Page;

    @Then("^First step of rebate creation process is opened.$")
    public void firstStepOfRebateCreationProcessIsOpened() {
        assertTrue(rebateCreation1Page.firstStepIsOpened());
        assertTrue(rebateCreation1Page.isOpened());
    }
}
