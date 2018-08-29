package com.geempower.storefront.pages.rebate;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.rebate.RebateCreation2PageElements.*;

@Component
public class RebateCreation2Page extends StorefrontBasePage {

    private final String pageUri = "rebate/review-request";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        waitUntilPageIsFullyLoaded();
        return getCurrentUrl().equals(getPageUrl());
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
        return $(ERROR_MESSAGE_ON_REBATE_CREATION_SECOND_PAGE_XPATH).getText();
    }
}
