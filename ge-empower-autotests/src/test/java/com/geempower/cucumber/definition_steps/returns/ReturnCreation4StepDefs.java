package com.geempower.cucumber.definition_steps.returns;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.helpers.managers.ReturnManager;
import com.geempower.storefront.pages.returns.ReturnCreation4Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static com.geempower.cucumber.definition_steps.TestKeyword.*;
import static junit.framework.TestCase.assertTrue;
import static org.testng.Assert.assertEquals;

public class ReturnCreation4StepDefs extends AbstractStepDefs {

    @Autowired
    private ReturnCreation4Page returnCreation4Page;
    @Autowired
    private ReturnManager returnManager;

    @Then("^Return Creation 4 page is opened.$")
    public void returnCreation4pageIsOpened() {
        assertTrue(returnCreation4Page.isOpened() && returnCreation4Page.returnCreation4pageIsOpened());
    }

    @Then("^Correct Сatalog No, Reason for request and Requested action are displayed on Return Creation 4 page.$")
    public void checkReasonForRequestAndRequestedActionAreDisplayedCorrectly() {
        String reasonForRequest = (String) threadVarsHashMap.get(RETURN_REASON_FOR_REQUEST);
        long invoiceNo = (long) threadVarsHashMap.get(RETURN_INVOICE_NO);
        String catalogNo = (String) threadVarsHashMap.get(RETURN_CATALOG_NO);
        assertEquals(reasonForRequest, returnCreation4Page.getReasonForRequest());
        assertEquals(invoiceNo, returnCreation4Page.getInvoiceNo());
        assertEquals(catalogNo, returnCreation4Page.getCatalogNo());
    }

    @When("^Expand return row on Return Creation 4 page.$")
    public void clickExpandRowButton() {
        returnCreation4Page.clickExpandRowButton();
    }

    @Then("^Correct Requested Action, Column of Shrink Wrap and Additional Info are displayed on Return Creation 4 page.$")
    public void checkRequestActionShrinkAndAdditionalInfo() {
        String requestedAction = (String) threadVarsHashMap.get(RETURN_REQUESTED_ACTION);
        String colorOfShrink = (String) threadVarsHashMap.get(RETURN_COLOR_OF_SHRINK);
        String additionalInfo = (String) threadVarsHashMap.get(RETURN_ADDITIONAL_INFO);
        assertEquals(requestedAction, returnCreation4Page.getRequestedAction());
        assertEquals(colorOfShrink, returnCreation4Page.getColorOfShrink());
        assertEquals(additionalInfo, returnCreation4Page.getAdditionalInfo());
    }

    @When("^Click on Submit Request button on Return Creation 4 page.$")
    public void clickOnSubmitRequestButton() {
        returnCreation4Page.clickOnSubmitRequestButton();
    }

    @And("^Submit (.*) pop-up on Return Creation 4 page.$")
    public void submitTermsPopUp(String popUpTitle) {
        returnCreation4Page.submitTermsPopUp(popUpTitle);
    }

    @Then("^(.*) pop-up is displayed on Return Creation 4 page.$")
    public void requestPopUpIsDisplayed(String popUpTitle) {
        returnCreation4Page.requestPopUpIsDisplayed(popUpTitle);
        threadVarsHashMap.put(RETURN_REQUEST_CONFIRM_N0, returnCreation4Page.getRequestConfirmNo());
    }

    @When("^Return is created on Return Creation 4 page.$")
    public void returnIsCreated() {
        returnManager.createReturnInstance(returnCreation4Page.getRequestConfirmNo(),
                threadVarsHashMap.getString(RETURN_CATALOG_NO),
                (long) threadVarsHashMap.get(RETURN_INVOICE_NO),
                threadVarsHashMap.getString(RETURN_REASON_FOR_REQUEST),
                threadVarsHashMap.getString(RETURN_REQUESTED_ACTION));
        returnCreation4Page.closeRequestPopUp();
    }
}