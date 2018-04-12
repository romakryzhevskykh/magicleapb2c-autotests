package com.geempower.cucumber.definition_steps.returnCreationStepDefs;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.storefront.pages.returnsPages.ReturnCreation4Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.TestCase.assertTrue;
import static org.testng.Assert.assertEquals;

public class ReturnCreation4StepDefs extends AbstractStepDefs {

    @Autowired
    ReturnCreation4Page returnCreation4Page;

    @Then("^Return Creation 4 page is displayed.$")
    public void returnCreation4pageIsDisplayed() {
        assertTrue(returnCreation4Page.returnCreation4pageIsDisplayed());
    }

    @Then ("^Correct Reason for request and Requested action are displayed on Return Creation 4 page.$")
    public void checkReasonForRequestAndRequestedActionAreDisplayedCorrectly(){
        String reasonForRequest = (String) threadVarsHashMap.get(TestKeyword.REASON_FOR_REQUEST);
        String invoiceNo = (String) threadVarsHashMap.get(TestKeyword.INVOICE_NO);
        assertEquals(reasonForRequest, returnCreation4Page.getReasonForRequest());
        assertEquals(invoiceNo, returnCreation4Page.getInvoiceNo());
    }
    @When("^Expand return row on Return Creation 4 page.$")
    public void clickExpandRowButton(){
        returnCreation4Page.clickExpandRowButton();
    }

    @Then ("^Correct Requested Action, Column of Shrink Wrap and Additional Info are displayed on Return Creation 4 page.$")
    public void checkRequestActionShrinkAndAdditionalInfo(){
        String requestedAction = (String) threadVarsHashMap.get(TestKeyword.REQUESTED_ACTION);
        String colorOfShrink = (String) threadVarsHashMap.get(TestKeyword.COLOR_OF_SHRINK);
        String additionalInfo = (String) threadVarsHashMap.get(TestKeyword.ADDITIONAL_INFO);
        assertEquals(requestedAction, returnCreation4Page.getRequestedAction());
        assertEquals(colorOfShrink, returnCreation4Page.getColorOfShrink());
        assertEquals(additionalInfo, returnCreation4Page.getAdditionalInfo());
    }

    @When ("^Click on Submit Request button on Return Creation 4 page.$")
    public void clickOnSubmitRequestButton(){
        returnCreation4Page.clickOnSubmitRequestButton();
    }

    @And("^Submit (.*) pop-up on Return Creation 4 page.$")
    public void submitTermsPopUp(String popUpTitle){
        returnCreation4Page.submitTermsPopUp(popUpTitle);
    }
}
