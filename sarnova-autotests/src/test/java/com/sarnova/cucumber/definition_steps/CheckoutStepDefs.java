package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.models.products.IndividualProduct;
import com.sarnova.helpers.models.products.UnitOfMeasure;
import com.sarnova.storefront.pages.CheckoutPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class CheckoutStepDefs extends AbstractStepDefs {
    @Autowired CheckoutPage checkoutPage;

    @Autowired private ProductsManager productsManager;

    @When("^Click on Next button on Checkout Shipping address step.$")
    public void clickOnNextButtonOnShippingAddressStep() {
        checkoutPage.clickOnNextButtonOnShippingAddressStep();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("^Click on Next button on Checkout Shipping method step.$")
    public void clickOnNextButtonOnShippingMethodStep() {
        checkoutPage.clickOnNextButtonOnShippingMethodStep();
    }

    @Then("^Check that Check license pop-up is not displayed on Checkout Shipping method step.$")
    public void checkThatLicensePopUpIsNotOpened() {
        assertFalse(checkoutPage.isLicensePopUpOpened());
    }

    @Then("^Check that Check license pop-up is displayed on Checkout Shipping method step.$")
    public void checkThatLicensePopUpIsOpened() {
        assertTrue(checkoutPage.isLicensePopUpOpened());
    }

    @And("^Select user has no license select-box on Checkout Shipping method step in License pop-up.$")
    public void selectUserHasNoLicenseSelectBoxOnCheckoutShippingMethodStepInLicensePopUp() {
        checkoutPage.selectUserHasNoLicenseSelectBoxOnCheckoutShippingMethodStepInLicensePopUp();
    }

    @SuppressWarnings("unchecked")
    @Then("^Check that only license-restricted products are displaying in pop-up.$")
    public void checkThatOnlyLicenseRestrictedProductsAreDisplayingInPopUp() {
        HashMap<UnitOfMeasure, Integer> selectedUnitsOfMeasurement = getSelectedUOMS();
        ArrayList<IndividualProduct> selectedLicenseRestrectedProducts = selectedUnitsOfMeasurement.keySet()
                .stream()
                .map(productsManager::getProductByUOM)
                .distinct()
                .filter(IndividualProduct::isLicenseRestricted)
                .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<IndividualProduct> productsInLicenseRestrictedPopUp = checkoutPage.getProductsInCheckLicensePopUp();
        assertEquals(productsInLicenseRestrictedPopUp.size(), selectedLicenseRestrectedProducts.size());
        productsInLicenseRestrictedPopUp.forEach(productInLicenseRestrictedPopUp
                -> assertTrue(selectedLicenseRestrectedProducts.contains(productInLicenseRestrictedPopUp)));
    }

    @And("^Click on Continue button on Checkout Shipping method step in License pop-up.$")
    public void clickOnContinueButtonOnCheckoutShippingMethodStepInLicensePopUp() {
        checkoutPage.clickOnContinueButtonOnCheckoutShippingMethodStepInLicensePopUp();
    }

    @Then("^Check that Checkout Payment method step is opened.$")
    public void checkThatCheckoutPaymentMethodStepIsOpened() {
        assertTrue(checkoutPage.isPaymentMethodStepOpened());
    }

    @Then("^Check that Checkout Shipping method step is opened.$")
    public void checkThatCheckoutShippingMethodStepIsOpened() {
        assertTrue(checkoutPage.isShippingMethodStepOpened());
    }

    @Then("^Check that Checkout Shipping address step is opened.$")
    public void checkThatCheckoutShippingAddressStepIsOpened() {
        assertTrue(checkoutPage.isShippingAddressStepOpened());
    }

    @Then("^Check that Checkout Final review step is opened.$")
    public void checkThatCheckoutFinalReviewStepIsOpened() {
        assertTrue(checkoutPage.isFinalReviewStepOpened());
    }

    @And("^Check that only selected\\(expected\\) products are displaying on Checkout page.$")
    public void checkThatOnlySelectedExpectedProductsAreDisplayingOnCheckout() {

    }

    @When("^Select Invoice payment type on Checkout Payment method step.$")
    public void selectInvoicePaymentTypeOnCheckoutPaymentMethodStep() {
        checkoutPage.selectInvoicePaymentType();
    }

    @When("^Select Card payment type on Checkout Payment method step.$")
    public void selectCardPaymentTypeOnCheckoutPaymentMethodStep() {
        checkoutPage.selectCardPaymentType();
    }

    @Then("^Check that Invoice selector is visible on Checkout Payment method step.$")
    public void checkThatInvoiceSelectorIsVisibleOnCheckoutPaymentMethodStep() {
        assertTrue(checkoutPage.isInvoicePaymentTypeVisible());
    }

    @Then("^Check that Card selector is visible on Checkout Payment method step.$")
    public void checkThatCardSelectorIsVisibleOnCheckoutPaymentMethodStep() {
        assertTrue(checkoutPage.isCardPaymentTypeVisible());
    }

    @Then("^Check that Purchase order number text field is visible on Checkout Payment method step.$")
    public void checkThatPONIsVisibleOnCheckoutPaymentMethodStep() {
        assertTrue(checkoutPage.isPurchaseOrderNumberFieldVisible());
    }

    @Then("^Check that Comment text field is visible on Checkout Payment method step.$")
    public void checkThatCommentIsVisibleOnCheckoutPaymentMethodStep() {
        assertTrue(checkoutPage.isCommentTextFieldVisible());
    }

    @And("^Check that Card number text field is visible on Checkout Payment method step.$")
    public void checkThatCardNumberTextFieldIsVisibleOnCheckoutPaymentMethodStep() {
        assertTrue(checkoutPage.isCardNumberTextFieldVisible());
    }

    @And("^Check that Expiry month drop-down is visible on Checkout Payment method step.$")
    public void checkThatExpiryMonthDropDownIsVisibleOnCheckoutPaymentMethodStep() {
        assertTrue(checkoutPage.isExpiryMonthDropDownVisible());
    }

    @And("^Check that Expiry year drop-down is visible on Checkout Payment method step.$")
    public void checkThatExpiryYearDropDownIsVisibleOnCheckoutPaymentMethodStep() {
        assertTrue(checkoutPage.isExpiryYearDropDownVisible());
    }

    @And("^Check that Name on card text field is visible on Checkout Payment method step.$")
    public void checkThatNameOnCardTextFieldIsVisibleOnCheckoutPaymentMethodStep() {
        assertTrue(checkoutPage.isNameOnCardTextFieldTypeVisible());
    }

    @And("^Check that CVV text field is visible on Checkout Payment method step.$")
    public void checkThatCVVTextFieldIsVisibleOnCheckoutPaymentMethodStep() {
        assertTrue(checkoutPage.isCVVCodeTextFieldVisible());
    }

    @And("^Click on Next button on Checkout Payment method step.$")
    public void clickOnNextButtonOnCheckoutPaymentMethodStep() {
        checkoutPage.clickOnNextButtonOnPaymentMethodStep();
    }

    @And("^Set any Purchase order number on Checkout Payment method step.$")
    public void setAnyPurchaseOrderNumberOnCheckoutPaymentMethodStep() {
        String randomPON = RandomStringUtils.randomNumeric(9);
        checkoutPage.fillPurchaseOrderNumberWithText(randomPON);
    }

    @And("^Check that Place order button is visible on Checkout Final Review step.$")
    public void checkThatPlaceOrderButtonVisible() {
        assertTrue(checkoutPage.isPlaceOrderButtonVisible());
    }

    @And("^Check that accept Terms and Conditions checkbox is visible on Checkout Final Review step.$")
    public void checkThatTermsCheckboxVisible() {
        assertTrue(checkoutPage.isTermsCheckboxVisible());
    }

    @And("^Confirm Terms and Conditions on Checkout Final Review step.$")
    public void confirmTermsAndConditionsOnCheckoutFinalReviewStep() {
        checkoutPage.confirmTerms();
    }

    @And("^Click on Place order on Checkout Final Review step.$")
    public void clickOnPlaceOrderOnCheckoutFinalReviewStep() {
        checkoutPage.clickOnPlaceOrder();
    }
}
