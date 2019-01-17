package com.geempower.cucumber.definition_steps.returns;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.helpers.Utils;
import com.geempower.storefront.pages.returns.ReturnDetailsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class ReturnDetailsStepDefs extends AbstractStepDefs {
    @Autowired
    private ReturnDetailsPage returnDetailsPage;
    @Autowired
    private Utils utils;

    @Then("^Return Details page is opened.$")
    public void returnDetailsPageIsOpened() {
        assertTrue(returnDetailsPage.isOpened(threadVarsHashMap.getString(TestKeyword.RETURN_CASE_NO)));
    }

    @And("^Click on Comments tab on Return Details page.$")
    public void clickOnCommentsTabOnReturnDetailsPage() {
        returnDetailsPage.clickOnCommentsTab();
    }

    @When("^User clicks on Add Comment button.$")
    public void clickOnAddCommentButton() {
        returnDetailsPage.clickOnAddCommentButton();
    }

    @And("^User fills Comments field.$")
    public void fillCommentsField() {
        String uniqueComment = utils.generateUniqueTimestamp();
        returnDetailsPage.fillCommentsField(uniqueComment);
    }

    @And("^Click on Submit button in Comments pop-up.$")
    public void clickOnSubmitButtonInCommentsPopUp() {
        returnDetailsPage.clickOnSubmitButtonInCommentsPopUp();
    }
}