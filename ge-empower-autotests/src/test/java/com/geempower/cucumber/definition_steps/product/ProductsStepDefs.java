package com.geempower.cucumber.definition_steps.product;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.helpers.managers.ProductManager;
import com.geempower.helpers.managers.RegionsManager;
import com.geempower.helpers.models.Product;
import com.geempower.helpers.models.Region;
import com.geempower.storefront.pages.product.ProductsPage;
import cucumber.api.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;

public class ProductsStepDefs extends AbstractStepDefs {
    @Autowired
    private ProductsPage productsPage;
    @Autowired
    private ProductManager productManager;
    @Autowired
    private RegionsManager regionsManager;

    @Then("^(.*) title is displayed on Products page.$")
    public void checkAllProductsTitle(String allProductsTitle) {
        assertEquals(productsPage.getProductsTitle(), allProductsTitle);
    }

    @Given("^Select test product for chosen region.$")
    public void testProductIsCreated() {
        Region chosenRegion = (Region) threadVarsHashMap.get(TestKeyword.CHOSEN_REGION);
        HashMap<Product, Integer> selectedProducts = getSelectedProducts();
        selectedProducts.put(productManager.getProductWithAllDataByRegion(userSessions.getActiveUserSession(), chosenRegion), 0);
        threadVarsHashMap.put(TestKeyword.SELECTED_PRODUCTS, selectedProducts);
    }

    @When("^User search for a product by catalog No. on the Products page.$")
    public void userSearchForAProductByCatalogNoOnTheProductsPage() {
        threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        String catalogueNo = getSelectedProducts().keySet().stream().findAny().get().getCatalogNo();
        productsPage.setCatalogNoToSearchField(catalogueNo);
    }
}