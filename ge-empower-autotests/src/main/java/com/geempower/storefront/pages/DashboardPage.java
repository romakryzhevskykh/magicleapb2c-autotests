package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.DashboardPageElements.*;

@Component
public class DashboardPage extends StorefrontBasePage {

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl();
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Check that order Status widget is displayed.")
    public boolean orderStatusWidgetIsDisplayed() {
        return isDisplayed(ORDER_STATUS_WIDGET_XPATH);
    }

    @Step("Check that Featured Updates widget is displayed.")
    public boolean featuredUpdatesWidgetIsDisplayed() {
        return isDisplayed(FEATURED_UPDATES_WIDGET_XPATH);
    }

    @Step("Check that order Search widget is displayed.")
    public boolean orderSearchWidgetIsDisplayed() {
        return isDisplayed(ORDER_SEARCH_WIDGET_XPATH);
    }

    @Step("Check that Price and Availability widget is displayed.")
    public boolean priceAndAvailabilityWidgetIsDisplayed() {
        return isDisplayed(PRICE_AND_AVAILABILITY_WIDGET_XPATH);
    }

    @Step("Check that Recent Orders widget is displayed.")
    public boolean recentOrdersWidgetIsDisplayed() {
        return isDisplayed(RECENT_ORDERS_WIDGET_XPATH);
    }

    @Step("Check that Recent List widget is displayed.")
    public boolean recentListWidgetIsDisplayed() {
        return isDisplayed(RECENT_LIST_WIDGET_XPATH);
    }

    @Step("Click on Skip training button.")
    public void skipTrainingLevel() {
        waitUntilPageIsFullyLoaded();
        if (isDisplayed(SKIP_BUTTON_XPATH)) {
            click(SKIP_BUTTON_XPATH);
        }
    }

    @Step("Click on Close Cookies button.")
    public void closeCookiesPopUp() {
        if (isDisplayed(By.id(CLOSE_COOKIES_BUTTON_ID))) {
            click(By.id(CLOSE_COOKIES_BUTTON_ID));
        }
    }

    @Step("Check selected account is displayed.")
    public String isSelectedAccountIsDisplayed() {
        waitUntilPageIsFullyLoaded();
        return $(ACCOUNT_INFO_XPATH).getText();

    }

    @Step("Select Address from address field.")
    public String selectAddressFromAddressField() {
        waitUntilPageIsFullyLoaded();
        return $(By.id(SELECT_SHIP_ADDRESS_FIELD_ID)).getText();
    }
    @Step("Click on Submit button.")
    public void clickOnSubmitButton() {
        click(SUBMIT_SHIP_ADDRESS_BUTTON_XPATH);
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

    @Step("Set Product To The Search Product Field.")
    public void setProductToTheSearchProductField(String product) {
        $(PRODUCT_SEARCH_FIELD_XPATH).clear();
        $(PRODUCT_SEARCH_FIELD_XPATH).sendKeys(product);
    }

    @Step
    public void clickOnSearchProductIcon() {
        click($(By.id(PRODUCT_SEARCH_ICON_ID)));
    }
}