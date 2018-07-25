package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.Utils;
import com.geempower.storefront.page_blocks.HelpFeedbackBlock;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GeneralStepDefs extends AbstractStepDefs {

    @Autowired private Utils utils;
    @Autowired private HelpFeedbackBlock helpFeedbackBlock;

    @And("^Focus on browser.$")
    public void focusOnBrowser() {
        utils.focusOnActiveBrowser();
    }

    @And("^Refresh page.$")
    public void refreshPage() {
        utils.refreshCurrentPage();
    }

    @And("^Help button is displayed.$")
    public void helpButtonIsDisplayed() {
        assertTrue(helpFeedbackBlock.helpButtonIsDisplayed());
    }

    @Then("^Feedback button is displayed.$")
    public void feedbackButtonIsDisplayed() {
        assertTrue(helpFeedbackBlock.feedbackButtonIsDisplayed());
    }

    @When("^Admin clicks on the feedback button.$")
    public void adminClicksOnTheFeedbackButton() {
        helpFeedbackBlock.clickOnTheFeedbackButton();
    }

    @Then("^(.*) title is displayed in the feedback pop-up.$")
    public void helpUsImproveTitleIsDisplayedInTheFeedbackPopUp(String feedbackTitle) {
        assertEquals(feedbackTitle, helpFeedbackBlock.getFeedbackPopUpTitle());
    }

    @Then("^(.*) labels are present in the feedback pop-up.$")
    public void greatOkConfusingFrustratingLabelsArePresentInTheFeedbackPopUp(List<String> emojies) {
        emojies.forEach(emoji -> assertTrue(helpFeedbackBlock.isEmojiDisplayedInTheFeedbackPopUp(emoji)));
    }

    @Then("^Include screenshot checkbox is checked by default.$")
    public void includeScreenshotCheckboxIsCheckedByDefault() {
        assertTrue(helpFeedbackBlock.isCheckboxIncludeScreenshotSelected());
    }

    @When("^Admin sets (.*) to the feedback input.$")
    public void adminSetsTestTextToTheFeedbackInput(String text) {
        helpFeedbackBlock.setTextToTheFeedbackInput(text);
    }

    @And("^Clicks on the Submit button.$")
    public void clicksOnTheSubmitButton() {
        helpFeedbackBlock.submitFeedback();
    }

    @Then("^(.*) text is displayed in successful pop-up.$")
    public void isCorrectTextIsDisplayedInSuccessfulPopUp(String successfulFeedbackText) {
        assertEquals(successfulFeedbackText, helpFeedbackBlock.getResultTextFromFeedbackPopUp());
    }

    @And("^Admin clicks on OK button in the successful feedback pop-up.$")
    public void adminClicksOnOKButtonInTheSuccessfulFeedbackPopUp() {
        helpFeedbackBlock.clickOkOnTheFeedbackPopUp();
    }


    @When("^User clicks on Help button.$")
    public void userClicksOnHelpButton() {
        helpFeedbackBlock.clickOnHelpButton();
    }

    @And("^Click on Sign in with your GE SSO Account button on Lessonly page.$")
    public void signInToLessonLy(){
        helpFeedbackBlock.signInToLessonLy();
    }

    @Then("^(.*) tip is displayed on Lessonly widget.$")
    public void savedListsShoppingCartsTipIsDisplayedOnLessonlyWidget(String tipText) {
        assertEquals(tipText, helpFeedbackBlock.getLessonlyTipForAppropriatePage());
    }
}
