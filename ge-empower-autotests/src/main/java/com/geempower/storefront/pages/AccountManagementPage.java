package com.geempower.storefront.pages;

import com.geempower.helpers.models.Region;
import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;

import static com.geempower.storefront.page_elements.AccountManagementPageElements.*;

@Component
public class AccountManagementPage extends StorefrontBasePage {

    private final String pageUri = "my-account/manage-accounts";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    public void selectAppropriateRegionFromRegionList(Region chosenRegion) {
        waitUntilPageIsFullyLoaded();
        openRegionsList();
        chooseRegion(chosenRegion);
    }

    @Step("Select appropriate region by region name")
    public void chooseRegion(Region chosenRegion) {
        click(APPROPRIATE_REGION_BY_NAME_XPATH, chosenRegion.getRegionType().getRegionName());
    }

    @Step("Open regions list")
    public void openRegionsList() {
        waitUntilPageIsFullyLoaded();
        $(REGION_COMBOBOX_XPATH).click();
    }

    @Step("Search account by account name.")
    public void searchAccountByAccountName(String accountName) {
        setAccountNumberToSearchField(accountName);
        clickOnSearchButton();
    }

    @Step("Set account number to search field")
    public void setAccountNumberToSearchField(String accountName) {
        $(SEARCH_FIELD_XPATH).sendKeys(accountName);
    }

    @Step("Click on Search account button")
    public void clickOnSearchButton() {
        click(SEARCH_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Select account from the list")
    public void selectAccountFromTheList() {
        waitUntilPageIsFullyLoaded();
        click(FIRST_ACCOUNT_FROM_LIST_OF_ACCOUNTS_XPATH);
    }

    @Step("Select account with appropriate sales division from the list")
    public void selectAccountWithDivisionFromTheList(String salesDivision) {
        waitUntilPageIsFullyLoaded();
        click(ACCOUNT_WITH_APPROPRIATE_SALES_DIVISION_FROM_LIST_OF_ACCOUNTS_XPATH, salesDivision);
    }

    @Step("Click on Cancel Button")
    public void clickOnCancelButton() {
        $(By.xpath(CANCEL_BUTTON_XPATH)).click();
    }

    @Step("Open request account pop-up")
    public void openRequestAccountPopup() {
        waitUntilPageIsFullyLoaded();
        click(REQUEST_ACCOUNT_BUTTON);
    }

    @Step("Select region from regions list in request account popup by counter")
    public void selectRegionFromRegionsListInRequestAccountPopupByCounter(Region chosenRegion, int counter) {
        click(REGIONS_DROP_DOWN_BY_COUNTER_IN_POPUP_XPATH, String.valueOf(counter));
        chooseRegion(chosenRegion);
    }

    @Step("Set account number to account field in popup")
    public void setAccountNumberToAccountFieldInPopup(String account, int counter) {
        $(REGIONS_ACCOUNT_FIELD_BY_COUNTER_IN_POPUP_XPATH, String.valueOf(counter)).sendKeys(account);
    }

    @Step("Click on send request button in pop-up")
    public void clickOnSendRequestButtonInPopUp() {
        click(By.id(SEND_EXTERNAL_REQUEST_BUTTON_ID));
    }

    @Step("Switch to pending tab")
    public void switchToPendingTab() {
        waitForElementToDisappear(By.xpath(FULL_SCREEN_PROGRESS_INDICATOR_XPATH));
        click(PENDING_FOR_APPROVAL_TAB_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Get list of requested accounts")
    public ArrayList<String> getListOfRequestedAccounts() {
        waitUntilPageIsFullyLoaded();
        ArrayList<String> pendingAccountsOnPendingTab = new ArrayList<>();
        int i = 1;
        do {
            pendingAccountsOnPendingTab.add($(String.format(PENDING_ACCOUNTS_COLUMN_ON_PENDING_FOR_APPROVAL_TAB_XPATH, i)).getText());
            i++;
        }
        while (isDisplayed(String.format(PENDING_ACCOUNTS_COLUMN_ON_PENDING_FOR_APPROVAL_TAB_XPATH, i)));
        return pendingAccountsOnPendingTab;
    }

    @Step("Remove requested accounts")
    public void removeRequestedAccounts(int countOfRequestedAccount) {
        for (int i = 0; i < countOfRequestedAccount; i++) {
            click(MORE_ACTIONS_THREE_DOT_ICON_XPATH);
            click(CANCEL_REQUEST_BUTTON_XPATH);
            click(CONFIRMATION_FOR_CANCELING_REQUEST_XPATH);
            waitForElementToDisappear(By.xpath(CANCEL_REQUEST_CONFIRMATION_POPUP_XPATH));
        }
    }

    public void isAccountPageFullyLoaded() {
        if (!$(APPROVED_ACCOUNT_ROW_XPATH).isDisplayed()) {
            getDriver().navigate().refresh();
        }
    }

    @Step("Get First Account Name In The Table")
    public String getFirstAccountNameInTheTable() {
        return $(ACCOUNT_NAME_VALUE_IN_TABLE_XPATH).getText();
    }
}
