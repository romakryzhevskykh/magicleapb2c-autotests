package com.geempower.cucumber.definition_steps.returns;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.storefront.pages.returns.ReturnCreation2Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.TestCase.assertTrue;
import static org.testng.Assert.assertEquals;

public class ReturnCreation2StepDefs extends AbstractStepDefs {

    @Autowired
    ReturnCreation2Page returnCreation2Page;

    @Then("^Return Creation 2 page is displayed.$")
    public void returnCreation2pageIsDisplayed() {
        assertTrue(returnCreation2Page.returnCreation2pageIsDisplayed());
    }

    @Then ("^Correct catalog No is displayed on Return Creation 2 page.$")
    public void correctCatalogNoIsDispalyed(){
        String catalogNo = (String) threadVarsHashMap.get(TestKeyword.CATALOG_NO);
        assertEquals(catalogNo, returnCreation2Page.getCatalogNo());
    }

    @And("^Select (.*) Reason for Request on Return Creation 2 page.$")
    public void selectReasonForRequest(String reason) {
        returnCreation2Page.selectReasonForRequest(reason);
        threadVarsHashMap.put(TestKeyword.REASON_FOR_REQUEST, returnCreation2Page.getReasonForRequest());
    }

    @And("^Select (.*) Requested Action on Return Creation 2 page.$")
    public void selectRequestedAction(String action) {
        returnCreation2Page.selectRequestedAction(action);
        threadVarsHashMap.put(TestKeyword.REQUESTED_ACTION, returnCreation2Page.getRequestedAction());
    }

    @And("^Set value (.*) to the Qty. field on Return Creation 2 page.$")
    public void SetQtyValue(String qty) {
        returnCreation2Page.setQtyValue(qty);
    }

    @And ("^Click on Next button on Return Creation 2 page.$")
    public void clickOnNextButton() {
        returnCreation2Page.clickOnNextButton();
    }
}
