package com.geempower.storefront.pages.rebate;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.rebate.RebateCreation3PageElements.*;

@Component
public class RebateCreation3Page extends StorefrontBasePage {

    private final String pageUri = "rebate/rebate-request-summary";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Check that third Step Is Opened")
    public boolean thirdStepIsOpened() {
        waitUntilPageIsFullyLoaded();
        return $(REBATE_REQUEST_SUMMARY_ACTIVE_STEP_XPATH).isDisplayed();
    }
    @Step("Check that All Data is Replaced Correctly")
    public boolean isAllDataReplacedCorrectly(String accountNo, long spaNo, String catalogNo, String endCustomerAccountNo, String distributorInvoiceNo, long qtySold) {
        waitUntilPageIsFullyLoaded();
        return $(ACCOUNT_DETAILS_VALUE_XPATH).getText().contains(accountNo) &&
                $(SPA_QUOTE_NO_VALUE_XPATH).getText().equals(String.valueOf(spaNo)) &&
                $(CATALOG_NO_VALUE_XPATH).getText().equals(catalogNo) &&
                $(END_CUSTOMER_ACCOUNT_NO_VALUE_XPATH).getText().equals(endCustomerAccountNo) &&
                $(END_CUSTOMER_INVOICE_DATE_VALUE_XPATH).getText().length() == 10 &&
                $(DISTRIBUTOR_INVOICE_NO_VALUE_XPATH).getText().equals(distributorInvoiceNo) &&
                Long.parseLong($(QTY_SOLD_VALUE_XPATH).getText()) == qtySold;
    }

    @Step("Click on Submit button")
    public void clickOnSubmitButton() {
        click(SUBMIT_REBATE_TOP_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Accept Terms And Condition PopUp")
    public void acceptTermsAndConditionPopUp(String popupTitle) {
        waitForElementWithAppropriateTextToAppear(By.xpath(TERMS_AND_CONDITIONS_POPUP_XPATH), popupTitle);
        $(TERMS_AND_CONDITIONS_POPUP_CHECKBOX_XPATH).click();
        $(TERMS_AND_CONDITIONS_SUBMIT_BUTTON_XPATH).click();
    }

    @Step("Check than submission Popup Is Appeared")
    public boolean submissionPopupIsAppeared(String popupTitle) {
        waitUntilPageIsFullyLoaded();
        return $(REQUEST_SUBMISSION_POPUP_TITLE_XPATH).getText().equals(popupTitle);
    }

    @Step("Get rebate id")
    public String getRebateId() {
        return $(REBATE_ID_XPATH).getText();
    }

    @Step("Close Successful Popup")
    public void closeSuccessfulPopup() {
        waitUntilPageIsFullyLoaded();
        $(REQUEST_SUBMISSION_POPUP_CLOSE_BUTTON_XPATH).click();
    }
}
