package com.sarnova.storefront.pages;

import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.models.products.IndividualProduct;
import com.sarnova.storefront.page_blocks.CheckoutShippingAddressStepBlock;
import com.sarnova.storefront.page_blocks.CheckoutShippingMethodStepBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class CheckoutPage extends StorefrontBasePage {
    @Autowired private CheckoutShippingAddressStepBlock shippingAddressStepBlock;
    @Autowired private CheckoutShippingMethodStepBlock shippingMethodStepBlock;

    @Autowired private ProductsManager productsManager;

    private String pageUrlMethod = "checkout/%s";

    public void clickOnNextButtonOnShippingAddressStep() {
        shippingAddressStepBlock.clickOnNextButton();
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

    public boolean isShippingMethodStepIsOpened() {
        return (storefrontProject.getBaseUrl()
                + String.format(pageUrlMethod, shippingMethodStepBlock.getPageUrlMethod()))
                .equals(getCurrentUrl());
    }
}
