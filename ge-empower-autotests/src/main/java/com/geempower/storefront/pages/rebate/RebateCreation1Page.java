package com.geempower.storefront.pages.rebate;

import com.geempower.helpers.Utils;
import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.rebate.RebateCreation1PageElements.*;

@Component
public class RebateCreation1Page extends StorefrontBasePage {

    @Autowired
    private Utils utils;

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
        click(MANUAL_ENTRY_OPTION_XPATH);
    }

    @Step("Set Appropriate Account To The Account No Field")
    public void setAppropriateAccountToTheAccountNoField(String chosenAccountNo) {
        waitUntilPageIsFullyLoaded();
        $(ACCOUNT_NO_INPUT_XPATH).clear();
        $(ACCOUNT_NO_INPUT_XPATH).sendKeys(chosenAccountNo);
        click(FIRST_ACCOUNT_FROM_THE_RESULT_ACCOUNTS_LIST_XPATH);
    }

    @Step("Choose Random Spa No From The List Of Available Spa")
    public long chooseRandomSpaNoFromTheListOfAvailableSpa(String listTitle) {
        waitUntilPageIsFullyLoaded();
        StringBuilder spaNo = new StringBuilder("");
        waitForElementWithAppropriateTextToAppear(By.xpath(SPECIAL_PRICING_LOOKUP_POP_UP_TITLE_XPATH), listTitle);
        $$(SPECIAL_PRICING_LOOKUP_LIST_XPATH).stream().findAny().ifPresent(webElement -> {
            spaNo.append(webElement.getText());
            click(webElement);
        });
        click(SPECIAL_PRICING_LOOKUP_APPLY_BUTTON_XPATH);
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
        StringBuilder endCustomerNo = new StringBuilder("");
        waitForElementWithAppropriateTextToAppear(By.xpath(END_CUSTOMER_ACCOUNT_NO_POP_UP_TITLE_XPATH), listTitle);
        $$(END_CUSTOMER_NO_LIST_XPATH).stream().findAny().ifPresent(webElement -> {
            moveToElement(webElement);
            endCustomerNo.append(webElement.getText());
            click(webElement);
        });
        click(END_CUSTOMER_NO_APPLY_BUTTON_XPATH);
        return String.valueOf(endCustomerNo);
    }

    @Step("Set End Customer Invoice Date")
    public void setEndCustomerInvoiceDate() {
        waitUntilPageIsFullyLoaded();
        click(END_CUSTOMER_INVOICE_DATE_ICON_XPATH);
        click(SOME_AVAILABLE_DAY_FROM_CALENDAR_XPATH);
    }

    @Step("Set Random Distributor Invoice No")
    public String setRandomDistributorInvoiceNo() {
        String randomDistributorInvoiceNo = String.valueOf(utils.generateRandomNumber(10000, 1000000));
        $(DISTRIBUTOR_INVOICE_NO_INPUT_XPATH).clear();
        $(DISTRIBUTOR_INVOICE_NO_INPUT_XPATH).sendKeys(randomDistributorInvoiceNo);
        return randomDistributorInvoiceNo;
    }


    @Step("Set Random Qty Sold")
    public int setRandomQtySold() {
        int randomQtySold = utils.generateRandomNumber(2, 40);
        $(QTY_SOLD_INPUT_XPATH).clear();
        $(QTY_SOLD_INPUT_XPATH).sendKeys(String.valueOf(randomQtySold));
        return randomQtySold;
    }

    @Step("Click On Next Button On First Page")
    public void clickOnTopNextButton() {
        click(NEXT_TOP_BUTTON_FIRST_STEP_XPATH);
    }

    public void uploadRebateFile(String fileName) {
        waitUntilPageIsFullyLoaded();
        utils.uploadFileByName(fileName, UPLOAD_INPUT_PATH_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("User Hover Mouse Over Top Next Button On Rebate Creation 1 Page.")
    public void userHoverMouseOverTopNextButtonOnRebateCreation1Page() {
        moveToElement($(NEXT_TOP_BUTTON_FIRST_STEP_XPATH));
    }

    @Step("Get Next Button Tool Tip Text on Rebate Creation 1 page.")
    public String getNextButtonToolTipText1Page() {
        waitUntilPageIsFullyLoaded();
        return $(NEXT_BUTTON_TOOLTIP_XPATH).getText();
    }

    @Step("Hover Mouse Over Question Icon On Rebate Creation 1 Page.")
    public void hoverMouseOverQuestionIconOnRebateCreation1Page() {
        click(QUESTION_ICON_XPATH);
        moveToElement($(QUESTION_ICON_XPATH));
    }

    @Step("Get Question Icon Tooltip Text.")
    public String getQuestionIconTooltipText() {
        return $(TOOLTIP_QUESTION_ICON_XPATH).getText();
    }

    @Step("Click On Search Agreement Icon.")
    public void clickOnSearchAgreementNoIcon() {
        waitUntilPageIsFullyLoaded();
        click(SPA_NO_SEARCH_ICON_XPATH);
    }

    @Step("Hover Mouse Over Apply Button In Special Pricing Lookup Pop Up.")
    public void hoverMouseOverApplyButtonInSpecialPricingLookupPopUp() {
        waitUntilPageIsFullyLoaded();
        moveToElement($(SPECIAL_PRICING_LOOKUP_APPLY_BUTTON_XPATH));
    }

    @Step("Get Apply Button Tool Tip.")
    public String getApplyButtonToolTip() {
        return $(TOOLTIP_APPLY_BUTTON_XPATH).getText();
    }

    @Step("Click On Search End Customer Account No Icon.")
    public void clickOnSearchEndCustomerAccountNoIcon() {
        waitUntilPageIsFullyLoaded();
        click(END_CUSTOMER_ACCOUNT_NO_SEARCH_ICON_XPATH);
    }

    @Step("Hover Mouse Over Apply Button In End Customer Account Pop Up.")
    public void hoverMouseOverApplyButtonInEndCustomerAccountPopUp() {
        waitUntilPageIsFullyLoaded();
        moveToElement($(END_CUSTOMER_NO_APPLY_BUTTON_XPATH));
    }
}