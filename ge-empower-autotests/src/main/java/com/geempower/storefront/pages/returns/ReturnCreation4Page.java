package com.geempower.storefront.pages.returns;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.returns.ReturnCreation4PageElements.*;

@Component
public class ReturnCreation4Page extends StorefrontBasePage {

    private final String pageUri = "returnRequest4";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Return Creation 4 page Is Displayed.")
    public boolean returnCreation4pageIsOpened() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(REQUEST_SUMMARY_ACTIVE_TITLE_XPATH);
    }

    @Step("Get Reason For Request.")
    public String getReasonForRequest() {
        return $(REASON_FOR_REQUEST_VALUE_XPATH).getText();
    }

    @Step("Get Invoice No.")
    public long getInvoiceNo() {
        return Long.parseLong($(INVOICE_NO_VALUE_XPATH).getText().substring(1));
    }

    @Step("Click Expand Row Button.")
    public void clickExpandRowButton() {
        waitUntilPageIsFullyLoaded();
        click(ARROW_DOWN_ALL_BUTTON_XPATH);
    }

    @Step("Get Requested Action value.")
    public String getRequestedAction() {
        waitUntilPageIsFullyLoaded();
        return $(REQUEST_ACTION_VALUE_XPATH).getText();
    }

    @Step("Get Color of Shrink value.")
    public String getColorOfShrink() {
        return $(COLOR_OF_SHRINK_WRAP_VALUE_XPATH).getText();
    }

    @Step("Get Additional Info value.")
    public String getAdditionalInfo() {
        return $(ADDITIONAL_INFO_VALUE_XPATH).getText();
    }

    @Step("Click On Submit Request Button.")
    public void clickOnSubmitRequestButton() {
        click(BOTTOM_SUBMIT_REQUEST_BUTTON_XPATH);
    }


    @Step("Submit Terms and Conditions pop-up.")
    public void submitTermsPopUp(String popUpTitle) {
        waitForElementWithAppropriateTextToAppear(By.xpath(TERMS_AND_CONDITIONS_POP_UP_XPATH), popUpTitle);
        click(AGREED_CHECKBOX_POP_UP_XPATH);
        click(By.id(SUBMIT_TERMS_POPUP_BUTTON_ID));
    }

    @Step("Get Catalog No.")
    public String getCatalogNo() {
        return $(CATALOG_NO_VALUE_XPATH).getText();
    }


    @Step("Check that Request Submissions Pop Up Is Displayed.")
    public void requestPopUpIsDisplayed(String popUpTitle) {
        waitForElementWithAppropriateTextToAppear(By.id(REQUEST_SUBMISSION_POP_UP_ID ),popUpTitle);
    }

    @Step("Get Request Confirm No.")
    public String getRequestConfirmNo() {
        return $(By.id(REQUEST_CONFIRM_NUMBER_ID)).getText().trim();
    }

    @Step("Close Request.")
    public void closeRequestPopUp() {
        click(CLOSE_REQUEST_BUTTON_XPATH);
    }

    @Step("Hover Mouse Over Question Icon On Return Creation 4 Page.")
    public void hoverMouseOverQuestionIconOnReturnCreation4Page() {
        moveToElement($(QUESTION_ICON_XPATH));
    }

    @Step("Get Question Icon Tooltip Text.")
    public String getQuestionIconTooltipText() {
        return $(TOOLTIP_QUESTION_ICON_XPATH).getText();
    }
}