package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.ProductsPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;

public class ProductsStepDefs extends AbstractStepDefs {
    @Autowired
    ProductsPage productsPage;

    @Then("^(.*) title is displayed on Products page.$")
    public void checkAllProductsTitle(String allProductsTitle) {
        assertEquals(productsPage.getProductsTitle(), allProductsTitle);
    }
}
