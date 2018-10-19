package com.geempower.cucumber.definition_steps.order;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.helpers.Utils;
import com.geempower.storefront.pages.order.PODetailsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.geempower.cucumber.definition_steps.TestKeyword.*;
import static org.testng.Assert.*;

public class PODetailsStepDefs extends AbstractStepDefs {
    @Autowired
    private PODetailsPage poDetailsPage;
    @Autowired
    private Utils utils;

    @Then("^PO Details page is opened.$")
    public void orderDetailsPageIsOpened() {
        assertTrue(poDetailsPage.isOpened(threadVarsHashMap.getString(TestKeyword.PO_NO)));
    }

    @Then("^Is (.*) title displayed on Details PO Number page.$")
    public void isPurchaseOrderTitleDisplayedOnDetailsPONumberPage(String title) {
        assertEquals(title, poDetailsPage.getPurchaseOrderTitleOnDetailsPONumberPage());
    }

    @Then("^Is PO title contains appropriate PO number.$")
    public void isPOTitleContainsAppropriatePONumber() {
        assertEquals(threadVarsHashMap.getString(TestKeyword.PO_NO), poDetailsPage.getPONoTitleNumber());
    }

    @Then("^Is Email/Download icon displayed in right corner.$")
    public void isEmailDownloadIconDisplayedInRightCorner() {
        assertTrue(poDetailsPage.isEmailDownloadIconDisplayedInRightCorner());
    }

    @When("^User expands/closes status boxes on PO Details page.$")
    public void userExpandsClosesStatusBoxesOnPODetailsPage() {
        poDetailsPage.userExpandsClosesStatusBoxesOnPODetailsPage();
    }

    @Then("^Is Expanded status box line displayed on PO Details page.$")
    public void isExpandedStatusBoxLineDisplayedOnPODetailsPage() {
        assertTrue(poDetailsPage.isExpandedStatusBoxLineDisplayedOnPODetailsPage());
    }

    @Then("^Is Expanded status box line not displayed on PO Details page.$")
    public void isExpandedStatusBoxLineNotDisplayedOnPODetailsPage() {
        assertFalse(poDetailsPage.isExpandedStatusBoxLineDisplayedOnPODetailsPage());
    }

    @Then("Is appropriate (.*) statuses displayed in the status boxes on PO Details page.")
    public void isAppropriateStatusesDisplayedInTheStatusBoxesOnPODetailsPage(List<String> statuses) {
        assertTrue(poDetailsPage.getAllStatusesInStatusBoxesOnPODetailsPage().containsAll(statuses));
    }

    @Then("^Is (.*) label contains date in opened Order No. Details block.$")
    public void isOrderedRequestedOnLabelContainsDate(String label) {
        assertTrue(utils.isValidDate(poDetailsPage.getLabelValueInOpenedOrderNoDetailsBlock(label)));
    }

    @Then("^Is (.*) label contains (.*) value in opened Order No. Details block.$")
    public void isOrderValueAndTaxTotalContainsUSDValue(String label, String currency) {
        assertTrue(poDetailsPage.getLabelValueInOpenedOrderNoDetailsBlock(label).contains(currency));
    }

    @Then("^Is (.*) label contains value in opened Order No. Details block.$")
    public void isLabelContainsValue(String label) {
        assertFalse(poDetailsPage.getLabelValueInOpenedOrderNoDetailsBlock(label).isEmpty());
    }

    @Then("^Is (.*) label contains (.*) email character in opened Order No. Details block.$")
    public void isCreatedByLabelContainsEmailCharacter(String label, String emailCharacter) {
        assertTrue(poDetailsPage.getLabelValueInOpenedOrderNoDetailsBlock(label).contains(emailCharacter));
    }

    @When("^User clicks on time status drop down field on PO Details page.$")
    public void userClickOnTimeStatusDropDownFieldOnPODetailsPage() {
        poDetailsPage.userClickOnTimeStatusDropDownField();
    }

    @Then("^Is Correct time statuses (.*) displayed in the time status drop down field on PO Details page.$")
    public void isCorrectTimeStatusesDisplayedInTheTimeStatusDropDownField(List<String> timeStatuses) {
        assertTrue(poDetailsPage.getAllTimeStatusesInTimeStatusDropDown()
                .allMatch(statuses ->
                        timeStatuses.stream().anyMatch(timeStatus -> statuses.getText().contains(timeStatus))));
    }

    @Then("^Is Opened PO Details block table contains correct header (.*) titles.$")
    public void isOpenedPODetailsBlockTableContainsCorrectHeaderTableTitles(List<String> tableTitles) {
        poDetailsPage.getAllPOOrderTableHeaders().containsAll(tableTitles);
    }

    @When("Put random catalog no to the thredVarsHaspMap.")
    public void putRandomCatalogNoToTheThredVarsHaspMap() {
        threadVarsHashMap.put(DETAILS_PO_PAGE_CATALOG_NO, poDetailsPage.getRandomCatalogNoInOpenedOrderNoDetailBlock());
    }

    @When("^User expands/closes random catalog No block in opened Order No. Details block.$")
    public void userExpandsClosesRandomCatalogNoBlockInOpenedOrderNoDetailsBlock() {
        poDetailsPage.clickOnExpandClosesArrowInOpenedOrderNoDetailsBlock(threadVarsHashMap.getString(DETAILS_PO_PAGE_CATALOG_NO));
    }

    @Then("^Is (.*) label contains date in Product Details block in opened Order No. Details block.$")
    public void isRequestedDateLabelContainsDateInProductDetailsBlockInOpenedPODetailsBlock(String label) {
        assertTrue(utils.isValidDate(poDetailsPage.getLabelValueInProductDetailsBlockInOpenedOrderNoDetailsBlock(label)));
    }

    @Then("^Is (.*) label contains value in Product Details block in opened Order No. Details block.$")
    public void isLabelContainsValueInProductDetailsBlock(String label) {
        assertFalse(poDetailsPage.getLabelValueInProductDetailsBlockInOpenedOrderNoDetailsBlock(label).isEmpty());
    }

    @Then("^Is Correct (.*) labels displayed in Product Details block in opened Order No. Details block.$")
    public void isCorrectProductDetailLabelsDisplayedInProductDetailsBlockInOpenedPODetailsBlock(List<String> productDetailLabels) {
        poDetailsPage.getAllProductDetailLabels().containsAll(productDetailLabels);
    }
}