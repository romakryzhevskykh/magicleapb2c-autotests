package com.template.cucumber.definition_steps.checkout_steps;

import com.template.cucumber.definition_steps.AbstractStepDefs;
import com.template.cucumber.definition_steps.TestKeyword;
import com.template.helpers.models.addresses.BillingAddress;
import com.template.helpers.models.credit_cards.CreditCard;
import com.template.storefront.pages.checkout_pages.CheckoutPaymentAndBillingAddressStepPage;
import cucumber.api.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class CheckoutPaymentAndBillingAddressStepPageStepDefs extends AbstractStepDefs {

    @Autowired private CheckoutPaymentAndBillingAddressStepPage checkoutPaymentAndBillingAddressStepPage;

    @And("^Set Use my shipping address checkbox unchecked in Payment and Billing Address step on Checkout.$")
    public void setUseMyShippingAddressCheckboxUncheckedInBillingAddressStepOnCheckout() {
        if (checkoutPaymentAndBillingAddressStepPage.isUseMyShippingAddressCheckboxSelected()) {
            checkoutPaymentAndBillingAddressStepPage.clickOnUseMyShippingAddressCheckbox();
        }
        threadVarsHashMap.put(TestKeyword.USE_SHIPPING_ADDRESS_FOR_BILLING, false);
    }

    @And("^Fill in Billing address in Payment and Billing Address step on Checkout.$")
    public void fillInBillingAddress() {
        BillingAddress billingAddress = ((CreditCard) threadVarsHashMap.get(TestKeyword.CREDIT_CARD)).getBillingAddress();
        checkoutPaymentAndBillingAddressStepPage.selectCountry(billingAddress.getCountry());
        checkoutPaymentAndBillingAddressStepPage.selectTitleFromDropDown(billingAddress.getUserTitle());
        checkoutPaymentAndBillingAddressStepPage.fillFirstNameField(billingAddress.getFirstName());
        checkoutPaymentAndBillingAddressStepPage.fillLastNameField(billingAddress.getLastName());
        checkoutPaymentAndBillingAddressStepPage.fillAddress1Field(billingAddress.getStreet());
        checkoutPaymentAndBillingAddressStepPage.fillAddress2Field(billingAddress.getAddressLine2());
        checkoutPaymentAndBillingAddressStepPage.fillCityField(billingAddress.getCity());
        checkoutPaymentAndBillingAddressStepPage.selectStateFromDropDown(billingAddress.getState());
        checkoutPaymentAndBillingAddressStepPage.fillPostcodeField(billingAddress.getZipCode());
    }

    @And("^Fill in Credit card data in Payment and Billing Address step on Checkout.$")
    public void fillInCreditCard() {
        CreditCard creditCard = (CreditCard) threadVarsHashMap.get(TestKeyword.CREDIT_CARD);
        checkoutPaymentAndBillingAddressStepPage.selectCardType(creditCard.getCardType());
        checkoutPaymentAndBillingAddressStepPage.fillTheCreditCardNumberField(creditCard.getCardNumber());
        checkoutPaymentAndBillingAddressStepPage.selectMonthExpirationFromDropDown(creditCard.getExpirationMonth());
        checkoutPaymentAndBillingAddressStepPage.selectYearExpirationFromDropDown(creditCard.getExpirationYear());
        checkoutPaymentAndBillingAddressStepPage.fillTheCVVField(creditCard.getCvv());
    }

    @And("^Set Save payment method checkbox unchecked in Payment and Billing Address step on Checkout.$")
    public void setSavePaymentCheckboxUncheckedInBillingAddressStepOnCheckout() {
        if (checkoutPaymentAndBillingAddressStepPage.isSavePaymentMethodCheckboxSelected()) {
            checkoutPaymentAndBillingAddressStepPage.clickOnSavePaymentMethodCheckbox();
        }
    }

    @And("^Click on Next button in Payment and Billing Address step on Checkout.$")
    public void clickOnNextButtonOnBillingAddressStep() {
        checkoutPaymentAndBillingAddressStepPage.clickOnNextButton();
    }


}
