package com.geempower.cucumber.definition_steps.returns;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.helpers.Utils;
import com.geempower.storefront.pages.returns.ReturnCreation2Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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
        if (!returnCreation2Page.reasonForRequestTitleIsDisplayed()) {
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
        threadVarsHashMap.put(TestKeyword.RETURN_QUANTITY, qty);
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
    public void selectCosmeticRequestTypeOnReturnCreation2Page(String type) {
        returnCreation2Page.selectRequestTypeForRequest(type);
    }

    @And("^Select (.*) Request sub-type on Return Creation 2 page.$")
    public void selectPaintRequestSubTypeOnReturnCreation2Page(String subType) {
        returnCreation2Page.selectRequestSubTypeForRequest(subType);
    }

    @When("^User clicks on Save for later button on Return Creation 2 page.$")
    public void userClicksOnSaveForLaterButtonOnReturnCreation2Page() {
        returnCreation2Page.clickOnSaveForLaterButton();
    }

    @When("^User hover mouse over bottom Next button on Return Creation 2 page.$")
    public void userHoverMouseOverBottomNextButtonOnReturnCreation2Page() {
        returnCreation2Page.userHoverMouseOverBottomNextButtonOnReturnCreation2Page();
    }

    @Then("^Is (.*) text displayed in the Next button tooltip on Return Creation 2 page.$")
    public void isAppropriateTextDisplayedInTheNextButtonTooltipOnReturnCreation2Page(String toolTipText) {
        assertEquals(toolTipText, returnCreation2Page.getNextButtonToolTipText2Page());
    }

    @Then("^Save to Return List with title (.*) pop-up is appeared.$")
    public void saveForLaterPopUpAppearsWithTitle(String saveForLaterPopUpTitle) {
        assertEquals(saveForLaterPopUpTitle, returnCreation2Page.getSaveForLaterPopUpTitle());
    }

    @Then("^Save for later Return pop-up contains (.*) header.$")
    public void saveForLaterPopUpContainsCorrectHeader(String popUpHeader) {
        assertEquals(popUpHeader, returnCreation2Page.getSaveForLaterPopUpHeader());
    }

    @When("^User sets random name to the Return list name input.$")
    public void userSetsRandomNameToTheReturnListNameInput() {
        threadVarsHashMap.put(TestKeyword.RETURN_SAVE_FOR_LATER_LIST_NAME, returnCreation2Page.setNameForNewSavedReturnList());
    }

    @And("^User clicks on Save button in Save for later Return pop-up.$")
    public void userClicksOnSaveButtonInSaveForLaterReturnPopUp() {
        returnCreation2Page.clickSaveNewReturnList();
    }
}