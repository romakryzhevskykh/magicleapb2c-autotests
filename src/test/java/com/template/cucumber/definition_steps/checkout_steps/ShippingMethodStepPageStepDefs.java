package com.template.cucumber.definition_steps.checkout_steps;

import com.template.cucumber.definition_steps.AbstractStepDefs;
import com.template.storefront.pages.checkout_pages.CheckoutShippingMethodStepPage;
import cucumber.api.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class ShippingMethodStepPageStepDefs extends AbstractStepDefs {

    @Autowired private CheckoutShippingMethodStepPage checkoutShippingMethodStepPage;

    @And("^Click on Next button in Shipping Method step on Checkout.$")
    public void clickOnNextButtonInShippingMethodStepOnCheckout() {
        checkoutShippingMethodStepPage.clickOnNextButton();
    }
}
