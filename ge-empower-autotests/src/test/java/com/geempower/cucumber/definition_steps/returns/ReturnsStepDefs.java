package com.geempower.cucumber.definition_steps.returns;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.storefront.pages.returns.ReturnsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;

public class ReturnsStepDefs extends AbstractStepDefs {
    @Autowired
    private ReturnsPage returnsPage;

    @Then("^(.*) title is displayed on Returns page.$")
    public void checkAllCasesTitle(String allCasesTitle) {
        assertEquals(returnsPage.getReturnsTitle(), allCasesTitle);
    }

    @And("^Click on Create Request button.$")
    public void clickOnCreateRequestButton(){
        returnsPage.clickOnCreateRequestButton();
    }

    @When("^User opens Saved Requests tab.$")
    public void userOpensSavedRequestsTab() {
        returnsPage.openSavedRequestsTab();
    }

    @Then("^The return with appropriate name is displayed on the Saved Request tab.$")
    public void theReturnWithAppropriateNameIsDisplayedOnTheSavedRequestTab(){
        assertEquals(threadVarsHashMap.getString(TestKeyword.RETURN_SAVE_FOR_LATER_LIST_NAME), returnsPage.getLastSavedReturntName());
    }

    @When("^User clicks on Edit last saved return icon.$")
    public void userClicksOnEditLastSavedReturnIcon() {
        returnsPage.editLastSavedReturn();
    }
}
