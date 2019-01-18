package com.geempower.cucumber.definition_steps.returns;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.helpers.managers.ReturnManager;
import com.geempower.helpers.models.Return;
import com.geempower.storefront.pages.returns.ReturnsPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.*;

public class ReturnsStepDefs extends AbstractStepDefs {
    @Autowired
    private ReturnsPage returnsPage;
    @Autowired
    private ReturnManager returnManager;

    @Then("^(.*) title is displayed on Returns page.$")
    public void checkAllCasesTitle(String allCasesTitle) {
        assertEquals(returnsPage.getReturnsTitle(), allCasesTitle);
    }

    @And("^Click on Create Request button.$")
    public void clickOnCreateRequestButton() {
        returnsPage.clickOnCreateRequestButton();
    }

    @When("^User opens Saved Requests tab.$")
    public void userOpensSavedRequestsTab() {
        returnsPage.openSavedRequestsTab();
    }

    @Then("^The return with appropriate name is displayed on the Saved Request tab.$")
    public void theReturnWithAppropriateNameIsDisplayedOnTheSavedRequestTab() {
        assertEquals(threadVarsHashMap.getString(TestKeyword.RETURN_SAVE_FOR_LATER_LIST_NAME), returnsPage.getLastSavedReturntName());
    }

    @When("^User clicks on Edit appropriate saved return icon.$")
    public void userClicksOnEditAppropriateSavedReturnIcon() {
        returnsPage.editAppropriateReturn(threadVarsHashMap.getString(TestKeyword.RETURN_SAVE_FOR_LATER_LIST_NAME));
    }

    @When("^User clicks on Delete appropriate saved return icon.$")
    public void userClicksOnDeleteAppropriateSavedReturnIcon() {
        returnsPage.deleteAppropriateReturn(threadVarsHashMap.getString(TestKeyword.RETURN_SAVE_FOR_LATER_LIST_NAME));
    }

    @Then("^Is Created return displayed in Sent Requests tab.$")
    public void isCreatedReturnDisplayedInSentRequestsTab() {
        Return testReturn = returnManager.getReturnByRequestNo(threadVarsHashMap.getString(TestKeyword.RETURN_REQUEST_CONFIRM_N0));
        int allReturnsQuantity = Integer.parseInt(threadVarsHashMap.getString(TestKeyword.ALL_RETURNS_QUANTITY));
        returnsPage.getUpdatedSentRequestsTab(allReturnsQuantity + 1);
        assertEquals(testReturn.getId(), returnsPage.getLastAddedReturn().replace("Request No.:  ", ""));
    }

    @And("^Quantity of all returns is stored to hashmap.$")
    public void quantityOfAllReturnsIsStoredToHashmap() {
        threadVarsHashMap.put(TestKeyword.ALL_RETURNS_QUANTITY, returnsPage.getAllReturnsQuantity());
    }

    @Then("^Deleted return is not displayed in Saved Requests tab.$")
    public void deletedReturnIsNotDisplayedInSavedRequestsTab() {
        if (returnsPage.isSavedRequestsTableDisplayed()) {
            assertFalse(returnsPage.getAllReturnsConfirmationNo().allMatch(confirNo -> confirNo.getText()
                    .equals(threadVarsHashMap.getString(TestKeyword.RETURN_SAVE_FOR_LATER_LIST_NAME))));
        } else {
            assertFalse(returnsPage.isSavedRequestsTableDisplayed());
        }
    }

    @Then("^User sees Access Denied page.$")
    public void userSeesAccessDeniedPage() {
        assertTrue(returnsPage.getWindowTitle().contains("Access Denied"));
        assertEquals("Access Denied", returnsPage.getAccessDeniedPageTitle());
        assertEquals("Unfortunately, you do not have permission to view this page.", returnsPage.getAccessDeniedPageSubTitle());
        assertEquals("Return to the home page", returnsPage.getReturnHomeButtonName());
    }

    @And("^User clicks on filter returns icon.$")
    public void clickOnFilterReturnsIcon() {
        returnsPage.clickOnFilterReturnsIcon();
    }

    @And("^Select (.*) status in the case status drop-down field.$")
    public void selectAppropriateStatusInTheCaseStatusDropDownField(String status) {
        returnsPage.selectAppropriateStatusInTheCaseStatusDropDownField(status);
    }

    @And("^Click on apply filter button on Returns page.$")
    public void clickOnApplyFilterButtonOnReturnsPage() {
        returnsPage.clickOnApplyFilterButtonOnReturnsPage();
    }

    @Then("^Opened return contains (.*) status.$")
    public void openedReturnContainsAppropriateStatus(String status) {
        assertEquals(status, returnsPage.getStatusOfOpenedReturn());
    }

    @When("^User clicks on Case No. in opened Return block.$")
    public void clickOnCaseNoInOpenedReturn() {
        returnsPage.clickOnCaseNoInOpenedReturn();
    }

    @And("^Case No. value put to the hashmap.$")
    public void caseNoValuePutToTheHashmap() {
        threadVarsHashMap.put(TestKeyword.RETURN_CASE_NO, returnsPage.getCaseNoInOpenedReturn());
    }

    @Then("^Is Filter slider displayed.$")
    public void isFilterSliderDisplayed(){
        assertTrue(returnsPage.isFilterSliderDisplayed());
    }
}