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
        if (!isFinalReviewStepOpened()) {
//            createOrder
        }
    }

    public String getAnyShippingCountryFromDropDown() {
        return shippingAddressStepBlock.getAnyCountryFromCountiesDropDown();
    }

    public void selectCreateNewShippingAddress() {
        shippingAddressStepBlock.selectCreateNewShippingAddress();
    }

    public void openShippingCountriesDropDown() {
        shippingAddressStepBlock.openCountriesDropDown();
    }

    public void selectShippingCountryFromDropDown(String country) {
        shippingAddressStepBlock.selectCountryFromCountiesDropDown(country);
    }

    public void openShippingTitlesDropDown() {
        shippingAddressStepBlock.openTitlesDropDown();
    }

    public void selectTitleFromTitlesDropDown(String title) {
        shippingAddressStepBlock.selectTitleFromTitlesDropDown(title);
    }

    public void openStatesDropDown() {
        shippingAddressStepBlock.openStatesDropDown();
    }

    public void selectStateFromTitlesDropDown(String state) {
        shippingAddressStepBlock.selectStateFromTitlesDropDown(state);
    }

    public void fillFirstName(String firstName) {
        shippingAddressStepBlock.fillFirstName(firstName);
    }

    public void fillLastName(String lastName) {
        shippingAddressStepBlock.fillLastName(lastName);
    }

    public void fillAddressLine1(String addressLine1) {
        shippingAddressStepBlock.fillAddressLine1(addressLine1);
    }

    public void fillAddressLine2(String addressLine2) {
        shippingAddressStepBlock.fillAddressLine2(addressLine2);
    }

    public void fillTown(String town) {
        shippingAddressStepBlock.fillTown(town);
    }

    public void fillZipCode(String zipCode) {
        shippingAddressStepBlock.fillZipCode(zipCode);
    }

    public void fillPhoneNumber(String phoneNumber) {
        shippingAddressStepBlock.fillPhoneNumber(phoneNumber);
    }

    public void selectOvernightShippingMethod() {
        shippingMethodStepBlock.selectOvernightShippingMethod();
    }

    public void selectGroundShippingMethod() {
        shippingMethodStepBlock.selectGroundShippingMethod();
    }

    public void select2DayShippingMethod() {
        shippingMethodStepBlock.select2DayShippingMethod();
    }

    public void fillCardNumberField(String cardNumber) {
        paymentMethodStepBlock.fillCardNumberField(cardNumber);
    }

    public void fillExpiryDateMonth(String expiryMonth) {
        paymentMethodStepBlock.clickOnExpiryMonthDropDown();
        paymentMethodStepBlock.selectExpiryMonth(expiryMonth);
    }

    public void fillExpiryYear(String expiryYear) {
        paymentMethodStepBlock.clickOnExpiryYearDropDown();
        paymentMethodStepBlock.selectExpiryYear(expiryYear);
    }

    public void fillNameOnCard(String nameOnCard) {
        paymentMethodStepBlock.fillNameOnCard(nameOnCard);
    }

    public void fillCVV(String cvv) {
        paymentMethodStepBlock.fillCVV(cvv);
    }

    public void clickOnChangeBillingAddress() {
        paymentMethodStepBlock.clickOnChangeBillingAddress();
    }

    public String getAnyBillingCountryFromDropDown() {
        return paymentMethodStepBlock.getAnyCountryFromBillingAddressCountiesDropDown();
    }

    public void openBillingCountriesDropDown() {
        paymentMethodStepBlock.openBillingAddressCountriesDropDown();
    }

    public void selectBillingCountryFromDropDown(String country) {
        paymentMethodStepBlock.selectBillingAddressCountryFromCountiesDropDown(country);
    }

    public void openBillingStatesDropDown() {
        paymentMethodStepBlock.openBillingAddressStatesDropDown();
    }

    public void selectBillingStateFromTitlesDropDown(String state) {
        paymentMethodStepBlock.selectBillingAddressStateFromTitlesDropDown(state);
    }

    public void fillBillingFirstName(String firstName) {
        paymentMethodStepBlock.fillBillingAddressFirstName(firstName);
    }

    public void fillBillingLastName(String lastName) {
        paymentMethodStepBlock.fillBillingAddressLastName(lastName);
    }

    public void fillBillingAddressLine1(String addressLine1) {
        paymentMethodStepBlock.fillBillingAddressAddressLine1(addressLine1);
    }

    public void fillBillingAddressLine2(String addressLine2) {
        paymentMethodStepBlock.fillBillingAddressAddressLine2(addressLine2);
    }

    public void fillBillingTown(String town) {
        paymentMethodStepBlock.fillBillingAddressTown(town);
    }

    public void fillBillingZipCode(String zipCode) {
        paymentMethodStepBlock.fillBillingAddressZipCode(zipCode);
    }

    public void fillBillingPhoneNumber(String phoneNumber) {
        paymentMethodStepBlock.fillBillingAddressPhoneNumber(phoneNumber);
    }

    public boolean isPlaceOrderButtonEnabled() {
        return finalReviewStepBlock.isPlaceOrderButtonEnabled();
    }
}
