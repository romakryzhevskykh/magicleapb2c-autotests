package com.topcon.cucumber.definition_steps;

import com.topcon.helpers.managers.ProductsManager;
import com.topcon.helpers.models.Product;
import com.topcon.storefront.pages.CartPage;
import com.topcon.storefront.pages.ProductDetailsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static com.topcon.cucumber.definition_steps.TestKeyword.OPENED_PDP_PRODUCT;
import static org.testng.AssertJUnit.assertTrue;

public class CartPageStepDefs extends AbstractStepDefs {
    @Autowired private CartPage cartPage;

    @Then("^Check that selected products exist on Cart page.$")
    public void checkThatSelectedProductsExistOnCartPage() {
        Product product = (Product) threadVarsHashMap.get(OPENED_PDP_PRODUCT);
        assertTrue(cartPage.getAllAddedProductsIds().contains(product.getId()));
    }



}
