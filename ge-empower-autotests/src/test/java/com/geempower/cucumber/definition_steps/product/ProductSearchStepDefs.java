package com.geempower.cucumber.definition_steps.product;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.helpers.models.Region;
import com.geempower.storefront.page_blocks.FullProductDetailsPopUpBlock;
import com.geempower.storefront.pages.product.ProductSearchPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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

    @Then("^(.*) title is displayed on Product Search page.$")
    public void searchResultForProductTitleIsDisplayed(String title) {
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

    @When("^Click on (.*) link on Product Search page.$")
    public void clickOnProductLinkOnTheSearchResultPage(String product) {
        productSearchPage.clickOnProductLinkOnTheSearchResultPage(product);
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

    @When("^Click on All product checkbox on Product Search page.$")
    public void clickOnAllProductCheckboxOnProductSearchPage() {
        productSearchPage.clickOnAllProductCheckboxOnProductSearchPage();
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
}