package com.geempower.cucumber.definition_steps.order;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.helpers.Utils;
import com.geempower.storefront.pages.order.PODetailsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.testng.Assert.*;

public class PODetailsStepDefs extends AbstractStepDefs {
    @Autowired
    private PODetailsPage poDetailsPage;
    @Autowired
    private Utils utils;

    @Then("^PO Details page is opened.$")
    public void orderDetailsPageIsOpened() {
        assertTrue(poDetailsPage.isOpened(threadVarsHashMap.get(TestKeyword.PO_NO).toString()));
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

    @Then("^Is (.*) label contains date in PO Details block.$")
    public void isOrderedRequestedOnLabelContainsDate(String label) {
        assertTrue(utils.isValidDate(poDetailsPage.getLabelValueInPODetailsBlock(label)));
    }

    @Then("^Is (.*) label contains (.*) value in PO Details block.$")
    public void isOrderValueAndTaxTotalContainsUSDValue(String label, String currency) {
        assertTrue(poDetailsPage.getLabelValueInPODetailsBlock(label).contains(currency));
    }

    @Then("^Is (.*) label contains value in PO Details block.$")
    public void isLabelContainsValue(String label) {
        assertFalse(poDetailsPage.getLabelValueInPODetailsBlock(label).isEmpty());
    }

    @Then("^Is (.*) label contains (.*) email character in PO Details block.$")
    public void isCreatedByLabelContainsEmailCharacter(String label, String emailCharacter) {
        assertTrue(poDetailsPage.getLabelValueInPODetailsBlock(label).contains(emailCharacter));
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
}
