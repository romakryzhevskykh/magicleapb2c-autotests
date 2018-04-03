package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.OrderEntry3Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class OrderEntry3StepDefs extends AbstractStepDefs {
    @Autowired
    private OrderEntry3Page orderEntry3Page;

    @Then("^Order Summary step is opened.$")
    public void orderSummaryStepIsOpened() {
        assertTrue(orderEntry3Page.isOrderSummaryStepOpened());
    }

    @Then("^PO no. is correct.$")
    public void poNoIsCorrect() {
        assertEquals(threadVarsHashMap.get(TestKeyword.PO_NO), orderEntry3Page.getPoNoFromOrderSummary());
    }

    @When("^User clicks on Place Order button.$")
    public void userClicksOnPlaceOrderButton() {
        orderEntry3Page.clickOnThePlaceOrderButton();
    }

    @And("^Terms and Conditions pop-up is confirmed.$")
    public void termsAndConditionsPopUpIsConfirmed() throws Throwable {
        orderEntry3Page.submitTermsAndConditions();
    }

    @Then("^(.*) pop-up appears.$")
    public void orderSuccessfulPopUpAppears(String title) throws Throwable {
        threadVarsHashMap.put(TestKeyword.GE_ORDER_NO, orderEntry3Page.getGEOrderNoFromOrderSuccessPopUp(title));
    }

    //Test commit
    @When("^User closes the pop-up.$")
    public void userClosesThePopUp() {
        orderEntry3Page.closeOrderConfirmationPopUp();
    }
}
