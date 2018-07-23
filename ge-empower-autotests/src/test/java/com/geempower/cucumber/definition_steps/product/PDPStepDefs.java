package com.geempower.cucumber.definition_steps.product;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.storefront.pages.product.PDPPage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PDPStepDefs extends AbstractStepDefs {

    @Autowired
    PDPPage pdpPage;

    @Then("^PDP page is opened.$")
    public void checkThatPPDPageIsOpened() {
        assertTrue(pdpPage.isOpened());
    }

    @Then("^(.*) (.*) header is displayed.$")
    public void catalogNoHeaderIdDisplayed(String title, String catalogNo){
        threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        catalogNo = getSelectedProducts().keySet().stream().findAny().get().getCatalogueNo();
        assertEquals(title + catalogNo, pdpPage.getCatalogNoHeaderTitle());
    }
}
