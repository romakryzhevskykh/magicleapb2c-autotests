package com.geempower.cucumber.definition_steps.returns;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.storefront.pages.returns.ReturnCreation3Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.TestCase.assertTrue;
import static org.testng.Assert.assertEquals;

public class ReturnCreation3StepDefs extends AbstractStepDefs {

    @Autowired
    private ReturnCreation3Page returnCreation3Page;

    @Then("^Return Creation 3 page is opened.$")
    public void returnCreation3pageIsOpened() {
        assertTrue(returnCreation3Page.isOpened() && returnCreation3Page.returnCreation3pageIsOpened());
    }

    @When("^Click on Additional Info button on Return Creation 3 page.$")
    public void clickOnAdditionalInfoButton() {
        returnCreation3Page.clickOnAdditionalInfoButton();
    }

    @And("^Set color of shrink field on Return Creation 3 page.$")
    public void setColorOfShrinkField() {
        threadVarsHashMap.put(TestKeyword.RETURN_COLOR_OF_SHRINK, returnCreation3Page.setColorOfShrinkField());
    }

    @And("^Set Additional Information field on Return Creation 3 page.$")
    public void setAdditionalInformationField() {
        threadVarsHashMap.put(TestKeyword.RETURN_ADDITIONAL_INFO, returnCreation3Page.setAdditionalInformationField());

    }

    @And("^Click on Save button on Return Creation 3 page.$")
    public void clickOnSaveButton() {
        returnCreation3Page.clickOnSaveButton();
    }

    @And("^Click on Next button on Return Creation 3 page.$")
    public void clickOnNextButton() {
        returnCreation3Page.clickOnNextButton();
    }

    @Then("^Correct Сatalog No, Reason for request and Requested action are displayed on Return Creation 3 page.$")
    public void correctReasonForRequestAndRequestedActionAreDisplayedOnReturnCreationPage() {
        String reasonForRequest = (String) threadVarsHashMap.get(TestKeyword.RETURN_REASON_FOR_REQUEST);
        String requestedAction = (String) threadVarsHashMap.get(TestKeyword.RETURN_REQUESTED_ACTION);
        String catalogNo = (String) threadVarsHashMap.get(TestKeyword.RETURN_CATALOG_NO);
        assertEquals(reasonForRequest, returnCreation3Page.getReasonForRequest());
        assertEquals(requestedAction, returnCreation3Page.getRequestedAction());
        assertEquals(catalogNo, returnCreation3Page.getCatalogNo());
    }
}