package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.models.products.UnitOfMeasure;
import com.sarnova.storefront.pages.CartPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartPageStepDefs extends AbstractStepDefs {

    @Autowired private CartPage cartPage;

    @SuppressWarnings("unchecked")
    @Then("^Check that only selected UOMs exist on Cart page.$")
    public void checkThatSelectedUOMsExistOnCartPage() {
        HashMap<UnitOfMeasure, Integer> addedToCartUnitsOfMeasurement = (HashMap<UnitOfMeasure, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_UOMS_HASH_MAP);
        ArrayList<UnitOfMeasure> unitsOfMeasurementInCart = cartPage.getUnitsOfMeasurementInCart();
        addedToCartUnitsOfMeasurement.keySet().forEach(addedUOM ->
                assertTrue(unitsOfMeasurementInCart.contains(addedUOM))
        );
        assertEquals(addedToCartUnitsOfMeasurement.size(), unitsOfMeasurementInCart.size());
    }

    @SuppressWarnings("unchecked")
    @And("^Check that selected UOMs have corresponding quantities on Cart page.$")
    public void checkThatSelectedUOMsHaveCorrespondingQuantitiesOnCartPage() {
        HashMap<UnitOfMeasure, Integer> addedToCartUnitsOfMeasurement = (HashMap<UnitOfMeasure, Integer>) threadVarsHashMap.get(TestKeyword.SELECTED_UOMS_HASH_MAP);
        addedToCartUnitsOfMeasurement.forEach((unitOfMeasure, qtyOfUOM) ->
                assertEquals(cartPage.getQTYOfUOM(unitOfMeasure), qtyOfUOM.intValue())
        );
    }

    @And("^Open cart page.$")
    public void openCartPage() {
        cartPage.open();
    }

    @And("^Check that there are no products on Cart page.$")
    public void checkThatThereAreNoProductsOnCartPage() {
        assertTrue(cartPage.getUnitsOfMeasurementInCart().isEmpty());
    }

    @When("^Click on Checkout button on Cart page.$")
    public void clickOnCheckoutButtonOnCartPage() {
        cartPage.clickOnCheckoutButton();
    }

    @Then("^Check that Cart page is opened.$")
    public void checkThatCartPageIsOpened() {
        assertTrue(cartPage.isOpened());
    }
}
