package com.geempower.cucumber.definition_steps.rebate;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.helpers.models.Product;
import com.geempower.storefront.pages.rebate.RebateCreation2Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RebateCreation2StepDefs extends AbstractStepDefs {

    @Autowired private RebateCreation2Page rebateCreation2Page;

    @Then("^Second step is opened.$")
    public void secondStepIsOpened() {
        assertTrue(rebateCreation2Page.isOpened());
        assertTrue(rebateCreation2Page.secondStepIsOpened());
    }

    @SuppressWarnings("unchecked")
    @Then("^All data has been replaced correctly from first to second step.$")
    public void allDataHasBeenReplacedCorrectlyFromFirstToSecondStep() {
        String accountNo = (String) threadVarsHashMap.get(TestKeyword.CHOSEN_ACCOUNT);
        long spaNo = (long) threadVarsHashMap.get(TestKeyword.REBATE_SPA_NO);
        String catalogNo = getSelectedProducts().keySet().stream().findAny().get().getCatalogueNo();
        String endCustomerAccountNo = (String) threadVarsHashMap.get(TestKeyword.REBATE_END_CUSTOMER_NO);
        String distributorInvoiceNo = threadVarsHashMap.getString(TestKeyword.REBATE_DISTRIBUTOR_INVOICE_NO);
        HashMap<Product, Integer> selectedProducts = (HashMap<Product, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        selectedProducts.keySet().forEach(product -> assertTrue(rebateCreation2Page.isAllDataReplacedCorrectly(accountNo, spaNo, catalogNo, endCustomerAccountNo, distributorInvoiceNo, (long) selectedProducts.get(product))));

    }

    @When("^User clicks on the Next top button on the second rebate creation step.$")
    public void userClicksOnTheNextTopButtonOnTheSecondRebateCreationStep() {
        rebateCreation2Page.clickOnNextButtonOnSecondPage();
    }

    @And("^Spa No. and Catalog No. are stored to the threadVarsHashMap.$")
    public void spaNoAndCatalogNoAreStoredToTheThreadVarsHashMap() {
        threadVarsHashMap.put(TestKeyword.REBATE_SPA_NO,rebateCreation2Page.getSpaNo());
        threadVarsHashMap.put(TestKeyword.REBATE_CATALOG_NO, rebateCreation2Page.getCatalogNo());
    }

    @Then("^Validation message (.*) is displayed under the End Customer Invoice Date field.$")
    public void validationMessageIsDisplayedUnderTheEndCustomerInvoiceDateField(String validationMessage) {
        assertEquals(validationMessage, rebateCreation2Page.getValidationMessageForEndCustomerInvoiceDate());
    }

    @Then("^Error message is displayed (.*) in the top of Rebate Second step page.$")
    public void errorMessageIsDisplayedInvalidInvoiceDatesInTheTopOfRebateSecondStepPage(String errorMessage) {
        assertEquals(errorMessage, rebateCreation2Page.getErrorMessageOnTheTopRebatePage());
    }
}
