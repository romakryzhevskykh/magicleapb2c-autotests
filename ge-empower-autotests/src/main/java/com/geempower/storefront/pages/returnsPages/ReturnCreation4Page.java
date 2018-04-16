package com.geempower.storefront.pages.returnsPages;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.returnsCreationPageElements.ReturnCreation4PageElements.*;

@Component
public class ReturnCreation4Page extends StorefrontBasePage {

    private final String pageUri = "returnRequest4";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }


    @Step("Return Creation 4 page Is Displayed.")
    public boolean returnCreation4pageIsDisplayed() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(REQUEST_SUMMARY_ACTIVE_TITLE_XPATH);
    }

    @Step("Get Reason For Request.")
    public String getReasonForRequest() {
        return $(REASON_FOR_REQUEST_VALUE_XPATH).getText();
    }

    @Step("Get Invoice No.")
    public String getInvoiceNo() {
        return $(INVOICE_NO_VALUE_XPATH).getText();
    }

    @Step("Click Expand Row Button.")
    public void clickExpandRowButton() {
        waitUntilPageIsFullyLoaded();
        click(ARROW_DOWN_ALL_BUTTON_XPATH);
    }

    @Step("Get Requested Action value")
    public String getRequestedAction() {
        waitUntilPageIsFullyLoaded();
        return $(REQUEST_ACTION_VALUE_XPATH).getText();
    }

    @Step("Get Color of Shrink value")
    public String getColorOfShrink() {
        return $(COLOR_OF_SHRINK_WRAP_VALUE_XPATH).getText();
    }

    @Step("Get Additional Info value")
    public String getAdditionalInfo() {
        return $(ADDITIONAL_INFO_VALUE_XPATH).getText();
    }

    @Step("Click On Submit Request Button")
    public void clickOnSubmitRequestButton() {
        click(BOTTOM_SUBMIT_REQUEST_BUTTON_XPATH);
    }


    public void submitTermsPopUp(String popUpTitle) {
        waitForElementWithAppropriateTextToAppear(By.xpath(TERMS_AND_CONDITIONS_POP_UP_XPATH), popUpTitle);
        click(AGREED_CHECKBOX_POP_UP_XPATH);
        click(SUBMIT_TERMS_POPUP_BUTTON_XPATH);
    }
}
