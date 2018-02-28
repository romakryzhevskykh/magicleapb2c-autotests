package com.geempower.storefront.pages;

import com.geempower.helpers.models.Region;
import com.geempower.helpers.models.RegionType;
import com.geempower.storefront.StorefrontBasePage;
import org.apache.commons.lang.text.StrTokenizer;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static com.geempower.storefront.page_elements.AccountManagementPageElements.*;

@Component
public class AccountManagementPage extends StorefrontBasePage {
    @Autowired
    private AccountManagementPage accountManagementPage;

    private final String pageUri = "my-account/manage-accounts";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
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
        click(REGION_COMBOBOX_XPATH);
    }

    public void searchAccountForChosenRegion(String accountName) {
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

    @Step
    public void selectFirstAccount() {
        click(FIRST_ACCOUNT_FROM_LIST_OF_ACCOUNTS_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Click on Cancel Button")
    public void clickOnCancelButton() {
        $(By.xpath(CANCEL_BUTTON_XPATH)).click();
    }

    @Step
    public void openRequestAccountPopup() {
        waitUntilPageIsFullyLoaded();
        click(REQUEST_ACCOUNT_BUTTON);
    }

    @Step
    public void selectRegionFromRegionsListInRequestAccountPopupByCounter(Region chosenRegion, int counter) {
        click(REGIONS_DROP_DOWN_BY_COUNTER_IN_POPUP_XPATH, String.valueOf(counter));
        chooseRegion(chosenRegion);
    }

    @Step
    public void setAccountNumberToAccountFieldInPopup(String account, int counter) {
        $(REGIONS_ACCOUNT_FIELD_BY_COUNTER_IN_POPUP_XPATH, String.valueOf(counter)).sendKeys(account);
    }

    @Step
    public void clickOnSendRequestButtonInPopUp() {
        click(By.id(SEND_EXTERNAL_REQUEST_BUTTON_ID));
    }

    @Step
    public void switchToPendingTab() {
        waitForElementToDisappear(By.xpath(FULL_SCREEN_PROGRESS_INDICATOR_XPATH));
        click(PENDING_FOR_APPROVAL_TAB_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step
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

    @Step
    public void removeRequestedAccounts(int countOfRequestedAccount) {
        for (int i = 0; i < countOfRequestedAccount; i++) {
            click(MORE_ACTIONS_THREE_DOT_ICON_XPATH);
            click(CANCEL_REQUEST_BUTTON_XPATH);
            click(CONFIRMATION_FOR_CANCELING_REQUEST_XPATH);
            waitForElementToDisappear(By.xpath(CANCEL_REQUEST_CONFIRMATION_POPUP_XPATH));
        }
    }
}
