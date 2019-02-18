package com.template.cucumber.definition_steps.checkout_steps;

import com.template.cucumber.definition_steps.AbstractStepDefs;
import com.template.cucumber.definition_steps.TestKeyword;
import com.template.helpers.models.addresses.ShippingAddress;
import com.template.storefront.pages.checkout_pages.CheckoutShippingAddressStepPage;
import cucumber.api.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class CheckoutShippingAddressStepPageStepDefs extends AbstractStepDefs {
    @Autowired private CheckoutShippingAddressStepPage checkoutShippingAddressStepPage;

    @And("^Fill in Shipping address in Shipping Address step on Checkout.$")
    public void fillInShippingAddress() {
        ShippingAddress userAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS);
        checkoutShippingAddressStepPage.selectCountry(userAddress.getCountry());
        checkoutShippingAddressStepPage.selectTitleFromDropDown(userAddress.getUserTitle());
        checkoutShippingAddressStepPage.fillFirstNameField(userAddress.getFirstName());
        checkoutShippingAddressStepPage.fillLastNameField(userAddress.getLastName());
        checkoutShippingAddressStepPage.fillAddress1Field(userAddress.getStreet());
        checkoutShippingAddressStepPage.fillAddress2Field(userAddress.getAddressLine2());
        checkoutShippingAddressStepPage.fillCityField(userAddress.getCity());
        checkoutShippingAddressStepPage.selectStateFromDropDown(userAddress.getState());
        checkoutShippingAddressStepPage.fillPostcodeField(userAddress.getZipCode());
        checkoutShippingAddressStepPage.fillTelephoneField(userAddress.getPhoneNumber());
    }

    @And("^Click on Next button in Shipping Address step on Checkout.$")
    public void clickOnNextButtonOnShippingAddressStep() {
        checkoutShippingAddressStepPage.clickOnNextButton();
    }

}
