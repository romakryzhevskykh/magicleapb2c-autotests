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

    @Then("^Search Result title for appropriate product is displayed on Product Search page.$")
    public void searchResultForProductTitleIsDisplayed() {
        threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        String catalogueNo = getSelectedProducts().keySet().stream().findAny().get().getCatalogueNo();
        String title = "Search Result for '" + catalogueNo + "'";
        assertEquals(title, productSearchPage.getSearchResultTitle());
    }

    @SuppressWarnings("unchecked")
    @Then("^Alternate Cat. No. tab is displayed and not displayed for appropriate region on Product Search page.$")
    public void alternateCatNoTabIsDisplayedAndNotDisplayedForAppropriateRegion() {
        Region chosenRegion = (Region) threadVarsHashMap.get(TestKeyword.CHOSEN_REGION);
        if (chosenRegion.getRegionType().getRegionName().equals("EMEA")) {
            assertTrue(productSearchPage.verifyAlternateColumn());
        } else {
            assertFalse(productSearchPage.verifyAlternateColumn());
        }
    }

    @When("^Click on catalogueNo link on Product Search page.$")
    public void clickOnProductLinkOnTheSearchResultPage() {
        threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        String catalogueNo = getSelectedProducts().keySet().stream().findAny().get().getCatalogueNo();
        productSearchPage.clickOnProductLinkOnTheSearchResultPage(catalogueNo);
    }

    @Then("^Is Active Specification tab selected in Full Product Details pop-up.$")
    public void isActiveSpecificationTabSelected() {
        assertTrue(fullProductDetailsPopUpBlock.isActiveSpecificationTabSelected());
    }

    @Then("^Is Active Product Details tab selected in Full Product Details pop-up.$")
    public void isActiveProductDetailsTabSelected() {
        assertTrue(fullProductDetailsPopUpBlock.isActiveProductDetailsTabSelected());
    }

    @Then("^Is Active Availability Details tab selected in Full Product Details pop-up.$")
    public void isActiveAvailabilityDetailsTabSelected() {
        assertTrue(fullProductDetailsPopUpBlock.isActiveAvailabilityDetailsTabSelected());
    }

    @When("^Click on appropriate product checkbox on Product Search page.$")
    public void clickOnAppropriateProductCheckboxOnProductSearchPage() {
        threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        String catalogueNo = getSelectedProducts().keySet().stream().findAny().get().getCatalogueNo();
        productSearchPage.clickOnAppropriateProductCheckboxOnProductSearchPage(catalogueNo);
    }

    @And("^Click on Save to List button on Product Search page.$")
    public void clickOnSaveToListButtonOnProductSearchPage() {
        productSearchPage.clickOnSaveToListButtonOnProductSearchPage();
    }

    @Then("^Is Save To List pop-up displayed.$")
    public void isSaveToListPopUpDisplayed() {
        assertTrue(productSearchPage.isSaveToListPopUpDisplayed());
    }

    @When("^Set List name to the New List Field.$")
    public void setListNameToTheNewListField() {
        productSearchPage.setListNameToTheNewListField();
    }

    @And("^Click on Save button in the Save to list pop-up.$")
    public void clickOnSaveButtonInTheSaveToListPopUp() {
        productSearchPage.clickOnSaveButtonInTheSaveToListPopUp();
    }

    @And("^Click on Get P&A button on Product Search page.$")
    public void clickOnGetPAButtonOnProductSearchPage() {
        productSearchPage.clickOnGetPriceAndAvailabilityButton();
    }

    @And("^User clicks on Add to Cart button on Product Search page.$")
    public void userClicksOnAddToCartButtonOnProductSearchPage(){
        productSearchPage.clickOnAddToCartButtonOnProductSearchPage();
    }
}