package com.geempower.cucumber.definition_steps.returns;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.storefront.pages.returns.ReturnCreation1Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.TestCase.assertTrue;
import static org.testng.Assert.assertEquals;

public class ReturnCreation1StepDefs extends AbstractStepDefs {

    @Autowired
    private ReturnCreation1Page returnCreation1Page;

    @Then("Return Creation 1 page is opened.$")
    public void returnCreation1pageIsOpened() {
        assertTrue(returnCreation1Page.isOpened() && returnCreation1Page.returnCreation1pageIsOpened());
    }

    @When("Search All PO No. in the Search field on Return Creation 1 page.$")
    public void searchAllPoNo() {
        returnCreation1Page.searchAllPoNo();
    }

    @And("Select First Invoice No. in the Search Result table on Return Creation 1 page.$")
    public void selectFirstInvoiceNo() {
        threadVarsHashMap.put(TestKeyword.RETURN_INVOICE_NO, returnCreation1Page.selectFirstInvoiceNo());
    }

    @And("Select First Product in the Product List table on Return Creation 1 page.$")
    public void selectFirstProduct() {
        threadVarsHashMap.put(TestKeyword.RETURN_CATALOG_NO, returnCreation1Page.selectFirstProduct());
    }

    @And("Click on the Next button Return Creation 1 page.$")
    public void clickOnNextButton() {
        returnCreation1Page.clickOnNextButton();
    }

    @And("^Click on Manual entry option.$")
    public void selectManualEntryOption() {
        returnCreation1Page.clickManualEntryOption();
    }

    @And("^Upload test return file with name (.*).$")
    public void uploadReturnFile(String fileName) {
        returnCreation1Page.uploadReturnFile(fileName);
    }

    @Then("^Warning with correct message (.*) is displayed.$")
    public void warningWithCorrectMessageIsDisplayed(String warningMessage) {
        assertEquals(warningMessage, returnCreation1Page.getWarningMessage());
    }
}