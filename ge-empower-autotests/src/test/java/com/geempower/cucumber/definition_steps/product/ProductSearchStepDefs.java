package com.geempower.cucumber.definition_steps.product;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.helpers.models.Region;
import com.geempower.storefront.page_blocks.FullProductDetailsPopUpBlock;
import com.geempower.storefront.pages.product.ProductSearchPage;
import cucumber.api.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.*;

public class ProductSearchStepDefs extends AbstractStepDefs {

    @Autowired
    private ProductSearchPage productSearchPage;
    @Autowired
    private FullProductDetailsPopUpBlock fullProductDetailsPopUpBlock;

    @Then("^Search product page is opened.$")
    public void ProductSearchPageIsOpened() {
        assertTrue(productSearchPage.isOpened());
    }

}