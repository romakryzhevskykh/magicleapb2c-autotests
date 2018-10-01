package com.geempower.cucumber.definition_steps.order;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.storefront.pages.order.PODetailsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PODetailsStepDefs extends AbstractStepDefs {
    @Autowired
    private PODetailsPage poDetailsPage;

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
        assertEquals(threadVarsHashMap.get(TestKeyword.PO_NO), poDetailsPage.getPONoTitleNumber());
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

    @Then("Is Correct (.*) statuses displayed in the status boxes on PO Details page.")
    public void isCorrectStatusesDisplayedInTheStatusBoxesOnPODetailsPage(List<String> statuses) {
        assertTrue(poDetailsPage.getAllStatusesInStatusBoxesOnPODetailsPage().containsAll(statuses));
    }
}
