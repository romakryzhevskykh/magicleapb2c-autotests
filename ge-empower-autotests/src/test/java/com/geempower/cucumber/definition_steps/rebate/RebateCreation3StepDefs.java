package com.geempower.cucumber.definition_steps.rebate;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.helpers.managers.RebateManager;
import com.geempower.helpers.models.Product;
import com.geempower.storefront.pages.rebate.RebateCreation3Page;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

import static org.testng.Assert.assertTrue;

public class RebateCreation3StepDefs extends AbstractStepDefs {

    @Autowired private RebateManager rebateManager;
    @Autowired private RebateCreation3Page rebateCreation3Page;

    @Then("^Request summary step is opened.$")
    public void requestSummaryStepIsOpened() {
        assertTrue(rebateCreation3Page.isOpened());
        assertTrue(rebateCreation3Page.thirdStepIsOpened());
    }

    @SuppressWarnings("unchecked")
    @Then("^All data has been replaced correctly from second to third step.$")
    public void allDataHasBeenReplacedCorrectlyFromSecondToThirdStep() {
        String accountNo = (String) threadVarsHashMap.get(TestKeyword.CHOSEN_ACCOUNT);
        long spaNo = (long) threadVarsHashMap.get(TestKeyword.REBATE_SPA_NO);
        String catalogNo = getSelectedProducts().keySet().stream().findAny().get().getCatalogueNo();
        String endCustomerAccountNo = (String) threadVarsHashMap.get(TestKeyword.REBATE_END_CUSTOMER_NO);
        String distributorInvoiceNo = threadVarsHashMap.getString(TestKeyword.REBATE_DISTRIBUTOR_INVOICE_NO);
        HashMap<Product, Integer> selectedProducts = (HashMap<Product, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        selectedProducts.keySet().forEach(product -> assertTrue(rebateCreation3Page.isAllDataReplacedCorrectly(accountNo, spaNo, catalogNo, endCustomerAccountNo, distributorInvoiceNo, (long) selectedProducts.get(product))));
    }

    @When("^User clicks on the Submit rebate button.$")
    public void userClicksOnTheSubmitRebateButton() {
        rebateCreation3Page.clickOnSubmitButton();
    }

    @And("^Users accepts (.*) popup.$")
    public void usersAcceptsTermsAndConditionsForRebatesPopup(String popupTitle) {
        rebateCreation3Page.acceptTermsAndConditionPopUp(popupTitle);
    }

    @Then("^(.*) pop-up is displayed.$")
    public void requestSubmissionSuccessfulPopUpIsDisplayed(String popupTitle) {
        assertTrue(rebateCreation3Page.submissionPopupIsAppeared(popupTitle));
    }

    @SuppressWarnings("unchecked")
    @And("^Rebate is created with all parameters.$")
    public void rebateIsCreatedWithAllParameters() {
        rebateManager.createRebateInstance(rebateCreation3Page.getRebateId(),
                (long) threadVarsHashMap.get(TestKeyword.REBATE_SPA_NO),
                threadVarsHashMap.getString(TestKeyword.REBATE_END_CUSTOMER_NO),
                threadVarsHashMap.getString(TestKeyword.REBATE_DISTRIBUTOR_INVOICE_NO),
                (HashMap<Product, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS));
        rebateCreation3Page.closeSuccessfulPopup();
    }
}
