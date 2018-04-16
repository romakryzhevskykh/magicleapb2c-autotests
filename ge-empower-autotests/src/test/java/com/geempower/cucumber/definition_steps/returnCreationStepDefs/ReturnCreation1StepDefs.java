package com.geempower.cucumber.definition_steps.returnCreationStepDefs;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.storefront.pages.returnsPages.ReturnCreation1Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.TestCase.assertTrue;

public class ReturnCreation1StepDefs extends AbstractStepDefs {

    @Autowired
    ReturnCreation1Page returnCreation1Page;

    @Then("Return Creation 1 page is displayed.$")
    public void returnCreation1pageIsDisplayed() {
        assertTrue(returnCreation1Page.returnCreation1pageIsDisplayed());
    }

    @When("Search All PO No. in the Search field on Return Creation 1 page.$")
    public void searchAllPoNo() {
        returnCreation1Page.searchAllPoNo();
    }

    @And("Select First Invoice No. in the Search Result table on Return Creation 1 page.$")
    public void selectFirstInvoiceNo(){
        returnCreation1Page.selectFirstInvoiceNo();
        threadVarsHashMap.put(TestKeyword.INVOICE_NO, returnCreation1Page.getInvoiceNo());
    }

    @And("Select First Product in the Product List table on Return Creation 1 page.$")
    public void selectFirstProduct() {
        returnCreation1Page.selectFirstProduct();
        threadVarsHashMap.put(TestKeyword.CATALOG_NO, returnCreation1Page.getCatalogueNo());
    }

    @And ("Click on the Next button Return Creation 1 page.$")
    public void clickOnNextButton() {
        returnCreation1Page.clickOnNextButton();
    }

}
