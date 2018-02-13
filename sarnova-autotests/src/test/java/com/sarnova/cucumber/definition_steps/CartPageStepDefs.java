package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.models.products.UnitOfMeasure;
import com.sarnova.storefront.pages.CartPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.testng.Assert.assertTrue;

public class CartPageStepDefs extends AbstractStepDefs {

    @Autowired private CartPage cartPage;

    @SuppressWarnings("unchecked")
    @Then("^Check that selected UOMs exist on Cart page.$")
    public void checkThatSelectedUOMsExistOnCartPage() {
        ArrayList<UnitOfMeasure> addedUoCartUnitsOfMeasurement = (ArrayList<UnitOfMeasure>) threadVarsHashMap.get(TestKeyword.SELECTED_UOMS);
        ArrayList<UnitOfMeasure> unitsOfMeasurementInCart = cartPage.getUnitsOfMeasurementInCart();
        addedUoCartUnitsOfMeasurement.forEach(addedUOM ->
                assertTrue(unitsOfMeasurementInCart.contains(addedUOM))
        );
    }
}
