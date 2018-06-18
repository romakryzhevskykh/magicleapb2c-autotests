package com.sarnova.cucumber.definition_steps;

import com.sarnova.storefront.pages.DiscontinuedProductsPage;
import cucumber.api.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class DiscontinuedProductsPageStepDefs extends AbstractStepDefs {

    @Autowired private DiscontinuedProductsPage discontinuedProductsPage;

    @And("^Check that Discontinued Products page is opened.$")
    public void checkThatDiscontinuedProductsPageIsOpened() {
        assertTrue(discontinuedProductsPage.isOpened());
    }
}
