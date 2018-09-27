package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.models.credit_cards.CreditCard;
import com.sarnova.helpers.models.delivery_methods.DeliveryMethod;
import com.sarnova.helpers.models.shipping_addresses.ShippingAddress;
import com.sarnova.storefront.pages.OrderConfirmationPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class OrderConfirmationPageStepDefs extends AbstractStepDefs {
    @Autowired OrderConfirmationPage orderConfirmationPage;

    @Then("^Check that Order confirmation page is opened.$")
    public void checkThatOrderConfirmationPageIsOpened() {
        assertTrue(orderConfirmationPage.isOpened());
    }

    @Then("^Check that Shipping Address is correct on Order confirmation page.$")
    public void checkThatShippingAddressIsCorrect() {
        ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.TEST_SHIPPING_ADDRESS);
        assertEquals(orderConfirmationPage.getFirstLastName(), shippingAddress.getFirstNameText() + " " + shippingAddress.getLastNameText());
        assertEquals(orderConfirmationPage.getStreet(), shippingAddress.getAddressLine1());
        assertEquals(orderConfirmationPage.getCityState(), shippingAddress.getTown().getFullName() + ", " + shippingAddress.getState().getFullName());
        assertEquals(orderConfirmationPage.getCountryAndZipCode(), shippingAddress.getCountry().getName() + " " + shippingAddress.getPostcode());
    }

    @Then("^Check that delivery method is correct on Order confirmation page.$")
    public void checkThatDeliveryMethodIsCorrectOnOrderConfirmationPage() {
        DeliveryMethod deliveryMethod = (DeliveryMethod) threadVarsHashMap.get(TestKeyword.DELIVERY_METHOD);
        assertEquals(orderConfirmationPage.getDeliveryMethodName(), deliveryMethod.getNameOnConfirmationPage());
//        assertEquals(orderConfirmationPage.getDeliveryMethodExplanation(), deliveryMethod.getExplanation());
    }

    @Then("^Check that Billing Address is correct on Order confirmation page.$")
    public void checkThatBillingAddressIsCorrect() {
        ShippingAddress billingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.TEST_BILLING_ADDRESS);
        assertEquals(orderConfirmationPage.getBillingFirstLastName(), billingAddress.getFirstNameText() + " " + billingAddress.getLastNameText());
        assertEquals(orderConfirmationPage.getBillingStreet(), billingAddress.getAddressLine1());
        assertEquals(orderConfirmationPage.getBillingCityState(), billingAddress.getTown().getFullName() + ", " + billingAddress.getState().getFullName());
        assertEquals(orderConfirmationPage.getBillingCountryAndZipCode(), billingAddress.getCountry().getName() + " " + billingAddress.getPostcode());
    }

    @Then("^Check that credit card data is correct on Order confirmation page.$")
    public void checkThatCreditCardDataIsCorrectOnOrderConfirmationPage() {
        CreditCard creditCard = (CreditCard) threadVarsHashMap.get(TestKeyword.CREDIT_CARD);
        String paymentData = orderConfirmationPage.getPaymentTypeData();
        assertEquals(paymentData.substring(paymentData.length() - 4), creditCard.getCardNumber().substring(12));
    }
}
