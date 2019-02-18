package com.template.cucumber.definition_steps.checkout_steps;

import com.template.cucumber.definition_steps.AbstractStepDefs;
import com.template.cucumber.definition_steps.TestKeyword;
import com.template.helpers.managers.orders.OrdersManager;
import com.template.helpers.models.addresses.ShippingAddress;
import com.template.helpers.models.credit_cards.CreditCard;
import com.template.helpers.models.products.VariantProduct;
import com.template.storefront.pages.OrderConfirmationPage;
import com.template.storefront.pages.checkout_pages.CheckoutFinalReviewStepPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.Optional;

public class CheckoutFinalReviewStepPageStepDefs extends AbstractStepDefs {

    @Autowired private CheckoutFinalReviewStepPage checkoutFinalReviewStepPage;
    @Autowired private OrderConfirmationPage orderConfirmationPage;

    @Autowired private OrdersManager ordersManager;

    @When("^Set Terms and Conditions checkbox as checked in Final review step on Checkout.$")
    public void setTACCheckboxAsCheckedInFinalReviewCheckout() {
        if (!checkoutFinalReviewStepPage.isTermsAndConditionsSelected()) {
            checkoutFinalReviewStepPage.clickOnTermsAndConditionsCheckbox();
        }
    }

    @And("^Click on Place order button in Final review step on Checkout.$")
    public void clickOnPlaceOrderButtonInFinalReviewStepOnCheckout() {
        checkoutFinalReviewStepPage.clickOnPlaceOrderButton();
        if (orderConfirmationPage.isOpened()) {
            String id = orderConfirmationPage.getCurrentUrl().split("orderConfirmation/")[1];
            Map<VariantProduct, Integer> orderProducts = getSelectedProducts();
            ShippingAddress shippingAddress = (ShippingAddress) threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS);
            CreditCard creditCard = (CreditCard) threadVarsHashMap.get(TestKeyword.CREDIT_CARD);
            boolean useShippingAddressForBilling = Optional.ofNullable((Boolean) threadVarsHashMap.get(TestKeyword.USE_SHIPPING_ADDRESS_FOR_BILLING)).orElse(false);
            ordersManager.createOrderInstance(id, orderProducts, shippingAddress, useShippingAddressForBilling, creditCard);
            threadVarsHashMap.put(TestKeyword.ORDER, ordersManager.getOrderById(id));
        }
    }
}
