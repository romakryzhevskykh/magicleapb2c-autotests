package com.geempower.cucumber.definition_steps.product;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.helpers.models.Product;
import com.geempower.storefront.pages.product.ProductSubDetailPage;
import cucumber.api.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsSubDetailStepDefs extends AbstractStepDefs {

    @Autowired
    private ProductSubDetailPage productSubDetailPage;

    private final double delta = 0.00001;

    @Then("^Product sub-detail page is opened.$")
    public void checkThatProductSubDetailPageIsOpened() {
        assertTrue(productSubDetailPage.isOpened());
    }

}