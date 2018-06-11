package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.RandomUtils;
import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.models.credit_cards.CreditCard;
import com.sarnova.helpers.models.products.IndividualProduct;
import com.sarnova.helpers.models.products.UnitOfMeasure;
import com.sarnova.helpers.models.shipping_addresses.ShippingAddress;
import com.sarnova.helpers.user_engine.UserTitle;
import com.sarnova.storefront.pages.CheckoutPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class CheckoutStepDefs extends AbstractStepDefs {
    @Autowired CheckoutPage checkoutPage;

    @Autowired private ProductsManager productsManager;
    @Autowired private RandomUtils randomUtils;

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
        threadVarsHashMap.put(TestKeyword.LOCAT_DATE_TIME_OF_ACTION, LocalDateTime.now(ZoneId.of("America/Los_Angeles")));
        checkoutPage.clickOnNextButtonOnPaymentMethodStep();
    }

    @And("^Set any Purchase order number on Checkout Payment method step.$")
    public void setAnyPurchaseOrderNumberOnCheckoutPaymentMethodStep() {
        String randomPON = RandomStringUtils.randomNumeric(9);
        checkoutPage.fillPurchaseOrderNumberWithText(randomPON);
        threadVarsHashMap.put(TestKeyword.PURCHASE_ORDER_NUMBER, randomPON);
    }

    @And("^Check that Place order button is visible on Checkout Final Review step.$")
    public void checkThatPlaceOrderButtonVisible() {
        assertTrue(checkoutPage.isPlaceOrderButtonVisible());
    }

    @And("^Check that Place order button is unable on Checkout Final Review step.$")
    public void checkThatPlaceOrderButtonIsUnable() {
        assertFalse(checkoutPage.isPlaceOrderButtonEnabled());
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
        threadVarsHashMap.put(TestKeyword.LOCAT_DATE_TIME_OF_ACTION, LocalDateTime.now(ZoneId.of("America/Los_Angeles")));
        checkoutPage.clickOnPlaceOrder();
    }

    @And("^Click on Create new address button on Checkout Shipping address step.$")
    public void clickOnCreateNewAddressButtonOnCheckoutShippingAddressStep() {
        checkoutPage.selectCreateNewShippingAddress();
    }

    @And("^Select Country in drop-down on Checkout Shipping address step.$")
    public void selectCountryInDropDownOnCheckoutShippingAddressStep() {
        String randomCountry = checkoutPage.getAnyShippingCountryFromDropDown();
        checkoutPage.selectShippingCountryFromDropDown(randomCountry);
    }

    @And("^Click on Countries drop-down on Checkout Shipping address step.$")
    public void clickOnCountriesDropDownOnCheckoutShippingAddressStep() {
        checkoutPage.openShippingCountriesDropDown();
    }

    @And("^Click on Titles drop-down on Checkout Shipping address step.$")
    public void clickOnTitlesDropDownOnCheckoutShippingAddressStep() {
        checkoutPage.openShippingTitlesDropDown();
    }

    @And("^Select Title in drop-down on Checkout Shipping address step.$")
    public void selectTitleInDropDownOnCheckoutShippingAddressStep() {
        String titleValue = UserTitle.getRandom().name().toLowerCase();
        checkoutPage.selectTitleFromTitlesDropDown(titleValue);
    }

    @And("^Fill First name field on Checkout Shipping address step.$")
    public void fillFirstNameFieldOnCheckoutShippingAddressStep() {
        String name = randomUtils.randomName();
        checkoutPage.fillFirstName(name);
    }

    @And("^Fill Last name field on Checkout Shipping address step.$")
    public void fillLastNameFieldOnCheckoutShippingAddressStep() {
        String name = randomUtils.randomName();
        checkoutPage.fillLastName(name);
    }

    @And("^Fill Address line 1 field on Checkout Shipping address step.$")
    public void fillAddressLine1FieldOnCheckoutShippingAddressStep() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.TEST_SHIPPING_ADDRESS);
        checkoutPage.fillAddressLine1(shippingAddress.getAddressLine1());
    }

    @And("^Fill Address line 2 field on Checkout Shipping address step.$")
    public void fillAddressLine2FieldOnCheckoutShippingAddressStep() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.TEST_SHIPPING_ADDRESS);
        checkoutPage.fillAddressLine2(shippingAddress.getAddressLine2());
    }

    @And("^Fill Town field on Checkout Shipping address step.$")
    public void fillTownFieldOnCheckoutShippingAddressStep() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.TEST_SHIPPING_ADDRESS);
        checkoutPage.fillTown(shippingAddress.getTown());
    }

    @And("^Click on States drop-down on Checkout Shipping address step.$")
    public void clickOnStatesDropDownOnCheckoutShippingAddressStep() {
        checkoutPage.openStatesDropDown();
    }

    @And("^Select State in drop-down on Checkout Shipping address step.$")
    public void selectStateInDropDownOnCheckoutShippingAddressStep() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.TEST_SHIPPING_ADDRESS);
        checkoutPage.selectStateFromTitlesDropDown(shippingAddress.getState());
    }

    @And("^Fill Zip code field on Checkout Shipping address step.$")
    public void fillZipCodeFieldOnCheckoutShippingAddressStep() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.TEST_SHIPPING_ADDRESS);
        checkoutPage.fillZipCode(shippingAddress.getPostcode());
    }

    @And("^Fill Phone number field on Checkout Shipping address step.$")
    public void fillPhoneNumberFieldOnCheckoutShippingAddressStep() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.TEST_SHIPPING_ADDRESS);
        checkoutPage.fillPhoneNumber(shippingAddress.getPhoneNumber());
    }

    @And("^Select 2-DAY shipping method on Checkout Shipping method step.$")
    public void select2DayShippingMethodOnCheckoutShippingMethodStep() {
        checkoutPage.select2DayShippingMethod();
    }

    @And("^Select GROUND shipping method on Checkout Shipping method step.$")
    public void selectGroundShippingMethodOnCheckoutShippingMethodStep() {
        checkoutPage.selectGroundShippingMethod();
    }

    @And("^Select OVERNIGHT shipping method on Checkout Shipping method step.$")
    public void selectOvernightShippingMethodOnCheckoutShippingMethodStep() {
        checkoutPage.selectOvernightShippingMethod();
    }

    @And("^Fill Card Number field on Checkout Payment method step.$")
    public void fillCardNumberFieldOnCheckoutPaymentMethodStep() {
        CreditCard creditCard = (CreditCard) threadVarsHashMap.get(TestKeyword.CREDIT_CARD);
        checkoutPage.fillCardNumberField(creditCard.getCardNumber());
    }

    @And("^Fill Expiry Date\\(Month\\) drop-down on Checkout Payment method step.$")
    public void fillExpiryDateMonthDropDownOnCheckoutPaymentMethodStep() {
        CreditCard creditCard = (CreditCard) threadVarsHashMap.get(TestKeyword.CREDIT_CARD);
        checkoutPage.fillExpiryDateMonth(creditCard.getExpiryMonth());
    }

    @And("^Fill Expiry Year drop-down on Checkout Payment method step.$")
    public void fillExpiryYearDropDownOnCheckoutPaymentMethodStep() {
        CreditCard creditCard = (CreditCard) threadVarsHashMap.get(TestKeyword.CREDIT_CARD);
        checkoutPage.fillExpiryYear(creditCard.getShortExpiryYear());
    }

    @And("^Fill Name on card field on Checkout Payment method step.$")
    public void fillNameOnCardFieldOnCheckoutPaymentMethodStep(){
        CreditCard creditCard = (CreditCard) threadVarsHashMap.get(TestKeyword.CREDIT_CARD);
        checkoutPage.fillNameOnCard(creditCard.getNameOnCard());
    }

    @And("^Fill Card Verification Number field on Checkout Payment method step.$")
    public void fillCardVerificationNumberFieldOnCheckoutPaymentMethodStep() {
        CreditCard creditCard = (CreditCard) threadVarsHashMap.get(TestKeyword.CREDIT_CARD);
        checkoutPage.fillCVV(creditCard.getCvv());
    }

    @And("^Select Billing Country in drop-down on Checkout Payment method step.$")
    public void selectCountryInDropDownOnCheckoutPaymentMethodStep() {
        String randomCountry = checkoutPage.getAnyBillingCountryFromDropDown();
        checkoutPage.selectBillingCountryFromDropDown(randomCountry);
    }

    @And("^Click on Billing Countries drop-down on Checkout Payment method step.$")
    public void clickOnCountriesDropDownOnCheckoutPaymentMethodStep() {
        checkoutPage.openBillingCountriesDropDown();
    }

    @And("^Fill Billing First name field on Checkout Payment method step.$")
    public void fillFirstNameFieldOnCheckoutPaymentMethodStep() {
        String name = randomUtils.randomName();
        checkoutPage.fillBillingFirstName(name);
    }

    @And("^Fill Billing Last name field on Checkout Payment method step.$")
    public void fillLastNameFieldOnCheckoutPaymentMethodStep() {
        String name = randomUtils.randomName();
        checkoutPage.fillBillingLastName(name);
    }

    @And("^Fill Billing Address line 1 field on Checkout Payment method step.$")
    public void fillAddressLine1FieldOnCheckoutPaymentMethodStep() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.TEST_BILLING_ADDRESS);
        checkoutPage.fillBillingAddressLine1(shippingAddress.getAddressLine1());
    }

    @And("^Fill Billing Address line 2 field on Checkout Payment method step.$")
    public void fillAddressLine2FieldOnCheckoutPaymentMethodStep() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.TEST_BILLING_ADDRESS);
        checkoutPage.fillBillingAddressLine2(shippingAddress.getAddressLine2());
    }

    @And("^Fill Billing Town field on Checkout Payment method step.$")
    public void fillTownFieldOnCheckoutPaymentMethodStep() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.TEST_BILLING_ADDRESS);
        checkoutPage.fillBillingTown(shippingAddress.getTown());
    }

    @And("^Click on Billing States drop-down on Checkout Payment method step.$")
    public void clickOnStatesDropDownOnCheckoutPaymentMethodStep() {
        checkoutPage.openBillingStatesDropDown();
    }

    @And("^Select Billing State in drop-down on Checkout Payment method step.$")
    public void selectStateInDropDownOnCheckoutPaymentMethodStep() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.TEST_BILLING_ADDRESS);
        checkoutPage.selectBillingStateFromTitlesDropDown(shippingAddress.getState());
    }

    @And("^Fill Billing Zip code field on Checkout Payment method step.$")
    public void fillZipCodeFieldOnCheckoutPaymentMethodStep() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.TEST_BILLING_ADDRESS);
        checkoutPage.fillBillingZipCode(shippingAddress.getPostcode());
    }

    @And("^Fill Billing Phone number field on Checkout Payment method step.$")
    public void fillPhoneNumberFieldOnCheckoutPaymentMethodStep() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.TEST_BILLING_ADDRESS);
        checkoutPage.fillBillingPhoneNumber(shippingAddress.getPhoneNumber());
    }

    @And("^Click on Change Billing address on Checkout Payment method step.$")
    public void clickOnChangeBillingAddressOnCheckoutPaymentMethodStep() {
        checkoutPage.clickOnChangeBillingAddress();
    }
}
