package com.geempower.cucumber.definition_steps.product;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.storefront.page_blocks.FullProductDetailsPopUpBlock;
import com.geempower.storefront.pages.product.PDPPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PDPStepDefs extends AbstractStepDefs {

    @Autowired
    private PDPPage pdpPage;
    @Autowired
    private FullProductDetailsPopUpBlock fullProductDetailsPopUpBlock;

    @Then("^PDP page is opened.$")
    public void checkThatPDPPageIsOpened() {
        assertTrue(pdpPage.isOpened());
    }

    @Then("^Is (.*) (.*) header displayed on PDP page.$")
    public void isCatalogNoHeaderDisplayed(String title, String catalogNo) {
        threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        catalogNo = getSelectedProducts().keySet().stream().findAny().get().getCatalogueNo();
        assertEquals(title + catalogNo, pdpPage.getCatalogNoHeaderTitle());
    }

    @Then("^Is (.*) panel title and image displayed in Product Details block on PDP page.$")
    public void productDetailsPanelTitleIsDisplayed(String title) {
        assertEquals(title, pdpPage.getProductDetailsPanelTitle());
        assertTrue(pdpPage.isImageDisplayed());
    }

    @When("^Click on Price and Availability tab on PDP page.$")
    public void clickOnPriceAndAvailabilityTabOnPDPPage() {
        pdpPage.clickOnPriceAndAvailabilityTabOnPDPPage();
    }

    @Then("^Is (.*) Product Details Tab Selected on PDP page.$")
    public void isActiveProductDetailsTabSelectedOnPDPPage(String status) {
        assertTrue(pdpPage.isActiveProductDetailsTabSelected().contains(status));
    }

    @And("^Is (.*) header title in Product Detail tab displayed.$")
    public void isProductSummaryHeaderTitleAndTableInProductDetailTabDisplayed(String title) {
        assertEquals(title, pdpPage.getProductSummaryTitle());
    }

    @Then("^Check that product details table contains correct titles (.*).$")
    public void checkThatProductDetailsTableContainsCorrectTitles(List<String> tableItems) {
        assertTrue(pdpPage.getAllProductDetailTableItems().containsAll(tableItems));
    }

    @Then("^Is (.*) Price and Availability tab Selected on PDP page.$")
    public void isActivePriceAndAvailabilityTabSelectedOnPDPPage(String status) {
        assertTrue(pdpPage.isActivePATabSelected().contains(status));
    }

    @Then("^Is (.*) header title displayed in Price and Availability tab.$")
    public void isAvailabilityDetailsHeaderTitleInPriceAndAvailabilityTab(String title) {
        assertEquals(title, pdpPage.getAvailabilityDetailsHeaderTitle());
    }

    @Then("^Info table contains (.*) and (.*) headers in Price and Availability tab.$")
    public void infoTableContainsNecessaryHeadersInPriceAndAvailabilityTab(String warehouse, String availability) {
        assertEquals(warehouse, pdpPage.getWarehouseInfoTableHeader());
        assertEquals(availability, pdpPage.getAvailabilityInfoTableHeader());
    }

    @Then("^Is (.*) header title and table displayed in Price and Availability tab.$")
    public void isPricingDetailsHeaderTitleAndTableDisplayedInPriceAndAvailabilityTab(String title) {
        assertEquals(title, pdpPage.getPricingDetailsHeaderTitle());
    }

    @Then("^Check that Pricing details table contains correct titles (.*).$")
    public void checkThatPricingDetailsTableContainsCorrectTitles(List<String> tableItems) {
        assertTrue(pdpPage.getAllPricingDetailsItems().containsAll(tableItems));
    }

    @Then("^Is Add to Cart button displayed in Product Details block on PDP page.$")
    public void isAddToCartButtonDisplayedInProductDetailsBlockOnPDPPage() {
        assertTrue(pdpPage.isAddToCartButtonDisplayedInProductDetailsBlockOnPDPPage());
    }

    @When("^user clicks on Specifications tab.$")
    public void userClicksOnSpecificationsTab() {
        pdpPage.userClicksOnSpecificationsTab();
    }

    @Then("^is (.*) Specification tab selected on PDP page.$")
    public void isActiveSpecificationTabSelectedOnPDPPage(String status) {
        assertTrue(pdpPage.isActiveSpecificationTabSelected().contains(status));
    }

    @Then("^is (.*) header titles in Specification tab displayed.$")
    public void isGeneralNecessaryHeaderTitlesInSpecificationTabDisplayed(String title) {
        assertEquals(title, pdpPage.getGeneralCharacteristicsTabHeaderTitle());
    }

    @Then("^check that general characteristics table contains correct titles (.*) in Specification tab.$")
    public void checkThatGeneralCharacteristicsTableContainsCorrectTitlesInSpecificationTab(List<String> tableItems) {
        assertTrue(pdpPage.getAllGeneralCharacteristicsItems().containsAll(tableItems));
    }

    @When("^user clicks on Publications tab.$")
    public void userClicksOnPublicationsTab() {
        pdpPage.userClicksOnPublicationsTab();
    }

    @Then("^is (.*) List of Publications tab selected on PDP page.$")
    public void isActiveListOfPublicationsTabSelectedOnPDPPage(String status) {
        assertTrue(pdpPage.isActivePublicationsTabSelected().contains(status));
    }

    @Then("^is (.*) header title in Publications tab displayed.$")
    public void isListOfPublicationsHeaderTitleInPublicationsTabDisplayed(String title)  {
        assertEquals(title, pdpPage.getListOfPublicationsHeaderTitle());
    }

    @Then("^is Publications table with correct headers (.*) displayed.$")
    public void isPublicationsTableWithCorrectHeadersDisplayed(List<String> tableHeaders)  {
        assertTrue(pdpPage.getAllPublicationTableHeaders().containsAll(tableHeaders));
    }

    @Then("^is Publication table contains link.$")
    public void isPublicationTableContainsLink(){
        assertTrue(pdpPage.isPublicationTableContainsLink());
    }
}