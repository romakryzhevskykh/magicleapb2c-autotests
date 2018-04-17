package com.geempower.storefront.pages.rebate;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Random;

import static com.geempower.storefront.page_elements.rebate.RebateCreation1PageElements.*;

@Component
public class RebateCreation1Page extends StorefrontBasePage {

    private final String pageUri = "rebate/create-rebate";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Check that first Step Is Opened")
    public boolean firstStepIsOpened() {
        waitUntilPageIsFullyLoaded();
        return $(REBATE_CREATE_REQUEST_ACTIVE_STEP_XPATH).isDisplayed();
    }
    @Step("Choose Manual Entry Option")
    public void chooseManualEntryOption() {
        $(MANUAL_ENTRY_OPTION_XPATH).click();
    }

    @Step("Set Appropriate Account To The Account No Field")
    public void setAppropriateAccountToTheAccountNoField(String chosenAccountNo) {
        waitUntilPageIsFullyLoaded();
        $(ACCOUNT_NO_INPUT_XPATH).clear();
        $(ACCOUNT_NO_INPUT_XPATH).sendKeys(chosenAccountNo);
        $(FIRST_ACCOUNT_FROM_THE_RESULT_ACCOUNTS_LIST_XPATH).click();
    }

    @Step("Choose Random Spa No From The List Of Available Spa")
    public long chooseRandomSpaNoFromTheListOfAvailableSpa(String listTitle) {
        waitUntilPageIsFullyLoaded();
        $(SPA_NO_SEARCH_ICON_XPATH).click();
        waitUntilPageIsFullyLoaded();
        StringBuilder spaNo = new StringBuilder("");
        waitForElementWithAppropriateTextToAppear(By.xpath(SPECIAL_PRICING_LOOKUP_POP_UP_TITLE_XPATH), listTitle);
        $$(SPECIAL_PRICING_LOOKUP_LIST_XPATH).stream().findAny().ifPresent(webElement -> {
            spaNo.append(webElement.getText());
            click(webElement);
        });
        $(SPECIAL_PRICING_LOOKUP_APPLY_BUTTON_XPATH).click();
        return Long.parseLong(String.valueOf(spaNo));
    }

    @Step("Set Chosen product CatalogNo To The Input")
    public void setChosenProductCatalogNoToTheInput(String catalogNo) {
        $(CATALOG_NO_INPUT_XPATH).clear();
        $(CATALOG_NO_INPUT_XPATH).sendKeys(catalogNo);
    }

    @Step("Set Random End Customer No")
    public String setRandomEndCustomerNo(String listTitle) {
        waitUntilPageIsFullyLoaded();
        $(END_CUSTOMER_ACCOUNT_NO_SEARCH_ICON_XPATH).click();
        waitUntilPageIsFullyLoaded();
        StringBuilder endCustomerNo = new StringBuilder("");
        waitForElementWithAppropriateTextToAppear(By.xpath(END_CUSTOMER_ACCOUNT_NO_POP_UP_TITLE_XPATH), listTitle);
        $$(END_CUSTOMER_NO_LIST_XPATH).stream().findAny().ifPresent(webElement -> {
            moveToElement(webElement);
            endCustomerNo.append(webElement.getText());
            webElement.click();
        });
        $(END_CUSTOMER_NO_APPLY_BUTTON_XPATH).click();
        return String.valueOf(endCustomerNo);
    }

    @Step("Set End Customer Invoice Date")
    public void setEndCustomerInvoiceDate() {
        waitUntilPageIsFullyLoaded();
        $(END_CUSTOMER_INVOICE_DATE_ICON_XPATH).click();
        $(SOME_AVAILABLE_DAY_FROM_CALENDAR_XPATH).click();
    }

    @Step("Set Random Distributor Invoice No")
    public String setRandomDistributorInvoiceNo() {
        String randomDistributorInvoiceNo = String.valueOf(generateRandomNumber(10000, 1000000));
        $(DISTRIBUTOR_INVOICE_NO_INPUT_XPATH).clear();
        $(DISTRIBUTOR_INVOICE_NO_INPUT_XPATH).sendKeys(randomDistributorInvoiceNo);
        return randomDistributorInvoiceNo;
    }

    private int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return min + random.nextInt((max - min) + 1);
    }

    @Step("Set Random Qty Sold")
    public int setRandomQtySold() {
        int randomQtySold = generateRandomNumber(2, 40);
        $(QTY_SOLD_INPUT_XPATH).clear();
        $(QTY_SOLD_INPUT_XPATH).sendKeys(String.valueOf(randomQtySold));
        return randomQtySold;
    }

    @Step("Click On Next Button On First Page")
    public void clickOnTopNextButton() {
        $(NEXT_TOP_BUTTON_FIRST_STEP_XPATH).click();
        waitUntilPageIsFullyLoaded();
    }
}
