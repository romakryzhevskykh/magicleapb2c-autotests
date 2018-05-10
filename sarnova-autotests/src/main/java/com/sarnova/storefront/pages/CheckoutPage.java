package com.sarnova.storefront.pages;

import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.models.products.IndividualProduct;
import com.sarnova.storefront.page_blocks.CheckoutFinalReviewStepBlock;
import com.sarnova.storefront.page_blocks.CheckoutPaymentMethodStepBlock;
import com.sarnova.storefront.page_blocks.CheckoutShippingAddressStepBlock;
import com.sarnova.storefront.page_blocks.CheckoutShippingMethodStepBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class CheckoutPage extends StorefrontBasePage {
    @Autowired private CheckoutShippingAddressStepBlock shippingAddressStepBlock;
    @Autowired private CheckoutShippingMethodStepBlock shippingMethodStepBlock;
    @Autowired private CheckoutPaymentMethodStepBlock paymentMethodStepBlock;
    @Autowired private CheckoutFinalReviewStepBlock finalReviewStepBlock;

    @Autowired private ProductsManager productsManager;

    private String pageUrlMethod = "boundtree/en/USD/checkout/%s";

    public void clickOnNextButtonOnShippingAddressStep() {
        shippingAddressStepBlock.clickOnNextButton();
    }

    public void clickOnNextButtonOnShippingMethodStep() {
        shippingMethodStepBlock.clickOnNextButton();
    }

    public boolean isLicensePopUpOpened() {
        return shippingMethodStepBlock.isCheckLicensePopUpOpened();
    }

    public void selectUserHasNoLicenseSelectBoxOnCheckoutShippingMethodStepInLicensePopUp() {
        shippingMethodStepBlock.selectUserHasNoLicenseSelectBoxOnCheckoutShippingMethodStepInLicensePopUp();
    }

    public void clickOnContinueButtonOnCheckoutShippingMethodStepInLicensePopUp() {
        shippingMethodStepBlock.clickOnContinueButtonOnCheckoutShippingMethodStepInLicensePopUp();
    }

    public ArrayList<IndividualProduct> getProductsInCheckLicensePopUp() {
        return shippingMethodStepBlock.getSKUsInCheckLicensePopUp()
                .stream()
                .map(productsManager::getProductBySku)
                .map(product -> (IndividualProduct) product)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + String.format(pageUrlMethod, "");
    }

    @Step("Is Payment method Step opened?")
    public boolean isPaymentMethodStepOpened() {
        return (storefrontProject.getBaseUrl()
                + String.format(pageUrlMethod, paymentMethodStepBlock.getPageUrlMethod()))
                .equals(getCurrentUrl());
    }

    @Step("Is Shipping method Step opened?")
    public boolean isShippingMethodStepOpened() {
        return (storefrontProject.getBaseUrl()
                + String.format(pageUrlMethod, shippingMethodStepBlock.getPageUrlMethod()))
                .equals(getCurrentUrl());
    }

    @Step("Is Shipping address Step opened?")
    public boolean isShippingAddressStepOpened() {
        return (storefrontProject.getBaseUrl()
                + String.format(pageUrlMethod, shippingAddressStepBlock.getPageUrlMethod()))
                .equals(getCurrentUrl());
    }

    @Step("Is Final review Step opened?")
    public boolean isFinalReviewStepOpened() {
        return (storefrontProject.getBaseUrl()
                + String.format(pageUrlMethod, finalReviewStepBlock.getPageUrlMethod()))
                .equals(getCurrentUrl());
    }

    public boolean isInvoicePaymentTypeVisible() {
        return paymentMethodStepBlock.isInvoicePaymentTypeVisible();
    }

    public boolean isCardPaymentTypeVisible() {
        return paymentMethodStepBlock.isCardPaymentTypeVisible();
    }

    public boolean isPurchaseOrderNumberFieldVisible() {
        return paymentMethodStepBlock.isPurchaseOrderNumberFieldVisible();
    }

    public boolean isCommentTextFieldVisible() {
        return paymentMethodStepBlock.isCommentFieldVisible();
    }

    public boolean isCardNumberTextFieldVisible() {
        return paymentMethodStepBlock.isCardNumberTextFieldVisible();
    }

    public boolean isNameOnCardTextFieldTypeVisible() {
        return paymentMethodStepBlock.isNameOnCardTextFieldVisible();
    }

    public boolean isCVVCodeTextFieldVisible() {
        return paymentMethodStepBlock.isCVVCodeTextFieldVisible();
    }

    public void selectInvoicePaymentType() {
        paymentMethodStepBlock.selectInvoicePaymentType();
    }

    public void selectCardPaymentType() {
        paymentMethodStepBlock.selectCardPaymentType();
    }

    public boolean isExpiryYearDropDownVisible() {
        return paymentMethodStepBlock.isExpireYearDropDownVisible();
    }

    public boolean isExpiryMonthDropDownVisible() {
        return paymentMethodStepBlock.isExpireMonthDropDownVisible();
    }

    public void clickOnNextButtonOnPaymentMethodStep() {
        paymentMethodStepBlock.clickOnNextButton();
    }

    public boolean isPlaceOrderButtonVisible() {
        return finalReviewStepBlock.isPlaceOrderButtonVisible();
    }

    public boolean isTermsCheckboxVisible() {
        return finalReviewStepBlock.isAcceptTermsCheckboxVisible();
    }

    public void fillPurchaseOrderNumberWithText(String randomPON) {
        paymentMethodStepBlock.fillPONWithText(randomPON);
    }

    public void confirmTerms() {
        finalReviewStepBlock.confirmTerms();
    }

    public void clickOnPlaceOrder() {
        finalReviewStepBlock.placeOrder();
        if(!isFinalReviewStepOpened()) {
//            createOrder
        }
    }
}
