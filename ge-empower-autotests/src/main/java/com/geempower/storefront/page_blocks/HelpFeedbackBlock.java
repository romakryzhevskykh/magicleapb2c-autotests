package com.geempower.storefront.page_blocks;

import com.geempower.helpers.UIComponent;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_block_elements.HelpFeedbackBlockElements.*;

@Component
public class HelpFeedbackBlock extends UIComponent {

    @Step("Feedback button is displayed.")
    public boolean feedbackButtonIsDisplayed() {
        return isDisplayed(FEEDBACK_BUTTON_XPATH);
    }

    @Step("Help button is displayed.")
    public boolean helpButtonIsDisplayed() {
        return isDisplayed(HELP_BUTTON_XPATH);
    }

    @Step("Click on the Feedback button.")
    public void clickOnTheFeedbackButton() {
        click(FEEDBACK_BUTTON_XPATH);
    }

    @Step("Get feedback pop-up title.")
    public String getFeedbackPopUpTitle() {
        waitUntilPageIsFullyLoaded();
        return $(FEEDBACK_POP_UP_TITLE_XPATH).getText();
    }

    @Step("Check If Emoji Displayed.")
    public boolean isEmojiDisplayedInTheFeedbackPopUp(String emoji) {
        return isDisplayed(EMOJI_LABEL_XPATH, emoji.toLowerCase());
    }

    @Step("Is checkbox selected by default.")
    public boolean isCheckboxIncludeScreenshotSelected() {
        return $(By.id(CHECKBOX_INCLUDE_SCREENSHOT_ID)).isSelected();
    }

    @Step("Set some text to the feedback input.")
    public void setTextToTheFeedbackInput(String text) {
        $(By.id(FEEDBACK_INPUT_ID)).clear();
        $(By.id(FEEDBACK_INPUT_ID)).sendKeys(text);
    }

    @Step("Submit feedback.")
    public void submitFeedback() {
        click(By.id(SUBMIT_FEEDBACK_ID));
    }

    @Step("Get result text from the Feedback pop-up.")
    public String getResultTextFromFeedbackPopUp() {
        waitUntilPageIsFullyLoaded();
        return $(SUCCESSFUL_TEXT_FEEDBACK_POP_UP_XPATH).getText();
    }

    @Step("Click on the OK button.")
    public void clickOkOnTheFeedbackPopUp() {
        click(By.id(OK_BUTTON_FEDBACK_POP_UP_ID));
    }

    @Step("Click on Help button.")
    public void clickOnHelpButton() {
        waitUntilPageIsFullyLoaded();
        click(HELP_BUTTON_XPATH);
    }

    @Step("Sign in to Lessonly.")
    public void signInToLessonLy() {
        waitUntilPageIsFullyLoaded();
        click(SIGN_IN_TO_LESSONLY_BUTTON_XPATH);
    }

    @Step("Get Lessonly Tip For Appropriate Page")
    public String getLessonlyTipForAppropriatePage() {
        waitUntilPageIsFullyLoaded();
        getDriver().switchTo().frame($("//iframe[@id='lessonlyWidget']"));
        return $(TIP_FOR_APPROPRIATE_PAGE_XPATH).getText();
    }

    @Step("Get Help Button Name.")
    public String getHelpButtonName() {
        return $(HELP_BUTTON_XPATH).getText();
    }

    @Step("Get Data Client Id From Help Button.")
    public String getDataClientIdFromHelpButton() {
        return $(HELP_BUTTON_XPATH).getAttribute("data-client-id");
    }

    @Step("Get Data Token From Help Button.")
    public String getDataTokenFromHelpButton() {
        return $(HELP_BUTTON_XPATH).getAttribute("data-token");
    }

    public String getFeedbackButtonName() {
        return $(FEEDBACK_BUTTON_XPATH).getText();
    }
}
