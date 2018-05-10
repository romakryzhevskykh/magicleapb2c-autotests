package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.OrderConfirmationPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class OrderConfirmationPageStepDefs extends AbstractStepDefs {
    @Autowired OrderConfirmationPage orderConfirmationPage;

    @Then("^Check that Order confirmation page is opened.$")
    public void checkThatOrderConfirmationPageIsOpened() {
        assertTrue(orderConfirmationPage.isOpened());
    }
}
