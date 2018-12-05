package com.geempower.storefront.pages.rebate;

import com.geempower.helpers.Utils;
import com.geempower.storefront.StorefrontBasePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.rebate.RebateCreation2PageElements.*;

@Component
public class RebateCreation2Page extends StorefrontBasePage {

    @Autowired
    private Utils utils;

    private final String pageUri = "rebate/review-request";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        waitUntilPageIsFullyLoaded();
        return getCurrentUrl().contains(getPageUrl());
    }

    @Step("Check that second Step Is Opened.")
    public boolean secondStepIsOpened() {
        waitUntilPageIsFullyLoaded();
        return $(REBATE_REVIEW_REQUEST_ACTIVE_STEP_XPATH).isDisplayed();
    }

    @Step("Check that All Data is Replaced Correctly.")
    public boolean isAllDataReplacedCorrectly(String accountNo, long spaNo, String catalogNo, String endCustomerAccountNo, String distributorInvoiceNo, long qtySold) {
        waitUntilPageIsFullyLoaded();
        return $(ACCOUNT_NO_VALUE_XPATH).getAttribute("value").contains(accountNo) &&
                $(SPA_NO_VALUE_XPATH).getAttribute("value").equals(String.valueOf(spaNo)) &&
                $(CATALOG_NO_VALUE_XPATH).getAttribute("value").equals(catalogNo) &&
                $(END_CUSTOMER_NO_VALUE_XPATH).getAttribute("value").equals(endCustomerAccountNo) &&
                $(END_CUSTOMER_INVOICE_DATE_VALUE_XPATH).getAttribute("value").length() == 10 &&
                $(DISTRIBUTOR_INVOICE_NO_VALUE_XPATH).getAttribute("value").equals(distributorInvoiceNo) &&
                Long.parseLong($(QTY_SOLD_VALUE_XPATH).getAttribute("value")) == qtySold;
    }

    @Step("Click On Next Button On Second Page.")
    public void clickOnNextButtonOnSecondPage() {
        click(NEXT_TOP_BUTTON_XPATH);
    }

    @Step("Get actual Spa no. value on the second Rebate creation page.")
    public long getSpaNo() {
        return Long.parseLong($(SPA_NO_VALUE_XPATH).getAttribute("value"));
    }

    @Step("Get actual Catalog no. value on the second Rebate creation page.")
    public String getCatalogNo() {
        return $(CATALOG_NO_VALUE_XPATH).getAttribute("value");
    }

    @Step("Get validation message for end customer invoice date.")
    public String getValidationMessageForEndCustomerInvoiceDate() {
        return $(END_CUSTOMER_INVOICE_DATE_VALIDATION_MESSAGE_XPATH).getText();
    }

    @Step("Get error message on the top of the page.")
    public String getErrorMessageOnTheTopRebatePage() {
        waitUntilPageIsFullyLoaded();
        return $(ERROR_MESSAGE_ON_REBATE_CREATION_SECOND_PAGE_XPATH).getText();
    }

    @Step("Click On Save For Later Button.")
    public void clickOnSaveForLaterButton() {
        click(SAVE_FOR_LATER_REBATE_BUTTON_XPATH);
    }

    @Step("Get Save For Later Pop-Up Title.")
    public String getSaveForLaterPopUpTitle() {
        waitUntilPageIsFullyLoaded();
        return $(SAVE_FOR_LATER_POP_UP_TITLE_XPATH).getText();
    }

    @Step("Get Save For Later Pop-up Header.")
    public String getSaveForLaterPopUpHeader() {
        waitUntilPageIsFullyLoaded();
        return $(SAVE_FOR_LATER_POP_UP_HEADER_XPATH).getText();
    }

    @Step("Click Save New Rebates List.")
    public void clickSaveNewRebatesList() {
        click(SAVE_FOR_LATER_POP_UP_SAVE_BUTTON_XPATH);
    }

    @Step("Set Name For New Saved Rebate List.")
    public String setNameForNewSavedRebateList() {
        waitUntilPageIsFullyLoaded();
        String rebateListName = utils.getLocalDateTimeStamp();
        $(SAVE_FOR_LATER_POP_UP_LIST_NAME_INPUT_XPATH).clear();
        $(SAVE_FOR_LATER_POP_UP_LIST_NAME_INPUT_XPATH).sendKeys(rebateListName);
        return rebateListName;
    }
}