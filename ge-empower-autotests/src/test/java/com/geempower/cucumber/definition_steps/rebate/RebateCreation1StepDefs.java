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

    @When("^User chooses Manual Entry option.$")
    public void userChoosesManualEntryOption() {
        rebateCreation1Page.chooseManualEntryOption();
    }

    @And("^Sets account for chosen region to the Account No. field.$")
    public void setsAccountForChosenRegionToTheAccountNoField() {
        rebateCreation1Page.setAppropriateAccountToTheAccountNoField((String) threadVarsHashMap.get(TestKeyword.CHOSEN_ACCOUNT));

    }

    @And("^Chooses random SPA No. from (.*) list for the appropriate Account.$")
    public void choosesRandomSPANoFromSPANoListForTheAppropriateAccount(String listTitle) {
        threadVarsHashMap.put(TestKeyword.REBATE_SPA_NO, rebateCreation1Page.chooseRandomSpaNoFromTheListOfAvailableSpa(listTitle));
    }

    @When("^User sets appropriate Catalog No. for appropriate account to the Catalog No. field.$")
    public void userSetsAppropriateCatalogNoForAppropriateAccountToTheCatalogNoField() {
        String catalogNo = getSelectedProducts().keySet().stream().findAny().get().getCatalogNo();
        rebateCreation1Page.setChosenProductCatalogNoToTheInput(catalogNo);
    }

    @And("^Chooses random End Customer Account No. from (.*) list.$")
    public void choosesRandomEndCustomerAccountNoFromEndCustomerAccountNoList(String listTitle) {
        threadVarsHashMap.put(TestKeyword.REBATE_END_CUSTOMER_NO, rebateCreation1Page.setRandomEndCustomerNo(listTitle));
    }

    @And("^Sets correct End Customer Invoice Date.$")
    public void setsCorrectEndCustomerInvoiceDate() {
        rebateCreation1Page.setEndCustomerInvoiceDate();
    }

    @And("^Sets random Distributor Invoice No.$")
    public void setsRandomDistributorInvoiceNo() {
        threadVarsHashMap.put(TestKeyword.REBATE_DISTRIBUTOR_INVOICE_NO, rebateCreation1Page.setRandomDistributorInvoiceNo());
    }

    @SuppressWarnings("unchecked")
    @And("^Sets random Qty. Sold.$")
    public void setsRandomQtySold() {
        HashMap<Product, Integer> selectedProducts = (HashMap<Product, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        selectedProducts.keySet().forEach(product -> selectedProducts.put(product, rebateCreation1Page.setRandomQtySold()));
    }

    @When("^User clicks on the Next top button on the first rebate creation step.$")
    public void userClicksOnTheNextTopButtonOnTheFirstRebateCreationStep() {
        rebateCreation1Page.clickOnTopNextButton();
    }

    @And("^Upload test rebate file with name (.*).$")
    public void uploadTestRebateFile(String fileName) {
        rebateCreation1Page.uploadRebateFile(fileName);
    }
}
