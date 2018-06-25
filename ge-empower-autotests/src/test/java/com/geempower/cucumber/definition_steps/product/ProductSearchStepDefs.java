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
    @Autowired private FullProductDetailsPopUpBlock fullProductDetailsPopUpBlock;

    @Then("^Search product page is displayed.$")
    public void isProductSearchPageOpen(){
        assertTrue(productSearchPage.isOpened());
    }

    @Then("^(.*) title is displayed.$")
    public void searchResultForProductTitleIsDisplayed(String title) {
        assertEquals(title, productSearchPage.getSearchResultTitle());
    }

    @SuppressWarnings("unchecked")
    @Then("^Alternate Cat. No. tab is displayed and not displayed for appropriate region.$")
    public void alternateCatNoTabIsDisplayedAndNotDisplayedForAppropriateRegion(){
        Region chosenRegion = (Region) threadVarsHashMap.get(TestKeyword.CHOSEN_REGION);
        if(!chosenRegion.getRegionType().getRegionName().equals("North America")){
            assertTrue(productSearchPage.verifyAlternateColumn());
        } else {
            assertFalse(productSearchPage.verifyAlternateColumn());
        }
    }

    @When("^Click on (.*) link on the Search Result page.$")
    public void clickOnProductLinkOnTheSearchResultPage(String product) {
        productSearchPage.clickOnProductLinkOnTheSearchResultPage(product);
    }

    @Then("^Is Active Specification tab selected.$")
    public void isActiveSpecificationTabSelected() {
        assertTrue(fullProductDetailsPopUpBlock.isActiveSpecificationTabSelected());
    }

    @Then("^Is Active Product Details tab selected.$")
    public void isActiveProductDetailsTabSelected() {
        assertTrue(fullProductDetailsPopUpBlock.isActiveProductDetailsTabSelected());
    }

    @Then("^Is Active Availability Details tab selected.$")
    public void isActiveAvailabilityDetailsTabSelected() {
        assertTrue(fullProductDetailsPopUpBlock.isActiveAvailabilityDetailsTabSelected());
    }
}