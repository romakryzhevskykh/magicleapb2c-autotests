package com.template.cucumber.definition_steps.checkout_steps;

import com.template.cucumber.definition_steps.AbstractStepDefs;
import com.template.storefront.pages.checkout_pages.CheckoutPaymentTypeStepPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentTypeStepPageStepDefs extends AbstractStepDefs {

    @Autowired private CheckoutPaymentTypeStepPage checkoutPaymentTypeStepPage;


    @When("^Select Card Payment in Payment Type step on Checkout.$")
    public void selectCardPaymentInPaymentTypeStepOnCheckout()  {
        checkoutPaymentTypeStepPage.selectCardPayment();
    }

    @And("^Click on Next button in Payment Type step on Checkout.$")
    public void clickOnNextButtonInPaymentTypeStepOnCheckout() {
        checkoutPaymentTypeStepPage.clickOnNextButton();
    }
}
