package com.geempower.cucumber.definition_steps.returns;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.helpers.Utils;
import com.geempower.storefront.pages.returns.ReturnCreation2Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.testng.Assert.assertEquals;

public class ReturnCreation2StepDefs extends AbstractStepDefs {

    @Autowired
    private ReturnCreation2Page returnCreation2Page;
    @Autowired
    private Utils utils;

    @Then("^Return Creation 2 page is opened.$")
    public void returnCreation2pageIsOpened() {
        if(!returnCreation2Page.reasonForRequestTitleIsDisplayed()) {
            utils.refreshCurrentPage();
        }
        assertTrue(returnCreation2Page.isOpened() && returnCreation2Page.reasonForRequestTitleIsDisplayed());
    }

    @Then("^Correct catalog No is displayed on Return Creation 2 page.$")
    public void correctCatalogNoIsDispalyed() {
        String catalogNo = (String) threadVarsHashMap.get(TestKeyword.RETURN_CATALOG_NO);
        assertEquals(catalogNo, returnCreation2Page.getCatalogNo());
    }

    @And("^Select (.*) Reason for Request on Return Creation 2 page.$")
    public void selectReasonForRequest(String reason) {
        returnCreation2Page.selectReasonForRequest(reason);
        threadVarsHashMap.put(TestKeyword.RETURN_REASON_FOR_REQUEST, returnCreation2Page.getReasonForRequest());
    }

    @And("^Select (.*) Requested Action on Return Creation 2 page.$")
    public void selectRequestedAction(String action) {
        returnCreation2Page.selectRequestedAction(action);
        threadVarsHashMap.put(TestKeyword.RETURN_REQUESTED_ACTION, returnCreation2Page.getRequestedAction());
    }

    @And("^Set value (.*) to the Qty. field on Return Creation 2 page.$")
    public void setQtyValue(String qty) {
        returnCreation2Page.setQtyValue(qty);
    }

    @And("^Click on Next button on Return Creation 2 page.$")
    public void clickOnNextButton() {
        returnCreation2Page.clickOnNextButton();
    }

    @Then("^Correct list of catalogNumbers (.*) is displayed on Return Creation 2 page.$")
    public void correctListOfCatalogNumbersIsDisplayed(List<String> catalogNumbers) {
        List<String> returnCatalogNoList = returnCreation2Page.getAllCatalogNo();
        assertTrue(returnCatalogNoList.containsAll(catalogNumbers));
        threadVarsHashMap.put(TestKeyword.RETURN_CATALOG_NO_LIST, returnCatalogNoList);
    }

    @And("^Select random reason for request for each product.$")
    public void selectRandomReasonForRequestForEachProduct() {
        ArrayList catalogList = (ArrayList) threadVarsHashMap.get(TestKeyword.RETURN_CATALOG_NO_LIST);
        returnCreation2Page.setRandomReasonsForListOfProductsInRequest(catalogList.size());
    }

    @And("^Select (.*) Request type on Return Creation 2 page.$")
    public void selectCosmeticRequestTypeOnReturnCreationPage(String type) {
        returnCreation2Page.selectRequestTypeForRequest(type);
    }

    @And("^Select (.*) Request sub-type on Return Creation 2 page.$")
    public void selectPaintRequestSubTypeOnReturnCreationPage(String subType) {
        returnCreation2Page.selectRequestSubTypeForRequest(subType);
    }
}