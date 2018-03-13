package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.managers.ProductsManager;
import com.sarnova.helpers.models.products.IndividualProduct;
import com.sarnova.helpers.models.products.UnitOfMeasure;
import com.sarnova.storefront.pages.CheckoutPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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
        HashMap<UnitOfMeasure, Integer> selectedUnitsOfMeasurement;
        if (threadVarsHashMap.get(TestKeyword.SELECTED_UOMS_HASH_MAP) == null) {
            selectedUnitsOfMeasurement = new HashMap<>();
            threadVarsHashMap.put(TestKeyword.SELECTED_UOMS_HASH_MAP, selectedUnitsOfMeasurement);
        } else {
            selectedUnitsOfMeasurement = (HashMap<UnitOfMeasure, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_UOMS_HASH_MAP);
        }
        ArrayList<IndividualProduct> selectedProducts = selectedUnitsOfMeasurement.keySet()
                .stream()
                .map(productsManager::getProductByUOM)
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<IndividualProduct> productsInLicenseRestrictedPopUp = checkoutPage.getProductsInCheckLicensePopUp();
        assertEquals(selectedProducts.size(), productsInLicenseRestrictedPopUp.size());
        productsInLicenseRestrictedPopUp.forEach(productInLicenseRestrictedPopUp
                -> assertTrue(selectedProducts.contains(productInLicenseRestrictedPopUp)));
    }

    @And("^Click on Continue button on Checkout Shipping method step in License pop-up.$")
    public void clickOnContinueButtonOnCheckoutShippingMethodStepInLicensePopUp() {
        checkoutPage.clickOnContinueButtonOnCheckoutShippingMethodStepInLicensePopUp();
    }

    @Then("^Check that Checkout Shipping method step is opened.$")
    public void checkThatCheckoutShippingMethodStepIsOpened() {
        checkoutPage.isShippingMethodStepIsOpened();
    }

    @And("^Check that only selected\\(expected\\) products are displaying on Checkout page.$")
    public void checkThatOnlySelectedExpectedProductsAreDisplayingOnCheckout() {

    }
}
