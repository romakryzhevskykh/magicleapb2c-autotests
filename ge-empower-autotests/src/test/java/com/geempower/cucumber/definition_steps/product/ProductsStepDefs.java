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


}