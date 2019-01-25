package com.geempower.storefront.pages;

import com.geempower.helpers.Utils;
import com.geempower.helpers.models.Region;
import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.geempower.storefront.page_elements.AccountManagementPageElements.*;

@Component
public class AccountManagementPage extends StorefrontBasePage {

    private final String pageUri = "my-account/manage-accounts";

    @Autowired
    private Utils utils;

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Select Appropriate Region From Region List.")
    public void selectAppropriateRegionFromRegionList(Region chosenRegion) {
        waitUntilPageIsFullyLoaded();
        openRegionsList();
        chooseRegion(chosenRegion);
    }

    @Step("Close we are now ABB pop-up.")
    public void closeWeAreNowAbbPopUpIfPresent() {
        if (isDisplayed(WE_ARE_NOW_ABB_POP_UP_XPATH)) {
            click(WE_ARE_NOW_ABB_OK_BUTTON_XPATH);
            waitUntilPageIsFullyLoaded();
        }
    }

    @Step("Select appropriate region by region name.")
    private void chooseRegion(Region chosenRegion) {
        click(APPROPRIATE_REGION_BY_NAME_XPATH, chosenRegion.getRegionType().getRegionName());
    }

    @Step("Open regions list.")
    private void openRegionsList() {
        waitUntilPageIsFullyLoaded();
        click(By.id(REGION_COMBOBOX_ID));
    }

    @Step("Click on Search account button.")
    public void clickOnSearchButton() {
        click(SEARCH_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Select account from the list.")
    public void selectAccountFromTheList() {
        waitUntilPageIsFullyLoaded();
        click(FIRST_ACCOUNT_FROM_LIST_OF_ACCOUNTS_XPATH);
    }

    @Step("Select account with appropriate sales division from the list.")
    public void selectAccountWithDivisionFromTheList(String salesDivision) {
        waitUntilPageIsFullyLoaded();
        click(ACCOUNT_WITH_APPROPRIATE_SALES_DIVISION_FROM_LIST_OF_ACCOUNTS_XPATH, salesDivision);
    }

    @Step("Click on Cancel Button.")
    public void clickOnCancelButton() {
        $(By.xpath(CANCEL_BUTTON_XPATH)).click();
    }

    @Step("Open request account pop-up.")
    public void openRequestAccountPopup() {
        waitUntilPageIsFullyLoaded();
        waitForElementToDisappear(By.xpath(MODAL_DIALOG_XPATH));
        click(REQUEST_ACCOUNT_BUTTON_XPATH);
    }

    @Step("Select region from regions list in request account popup by counter.")
    public void selectRegionFromRegionsListInRequestAccountPopupByCounter(Region chosenRegion, int counter) {
        click(REGIONS_DROP_DOWN_BY_COUNTER_IN_POPUP_XPATH, String.valueOf(counter));
        chooseRegion(chosenRegion);
    }

    @Step("Search account by account name.")
    public void searchAccountByAccountName(String accountName) {
        $(By.id(SEARCH_FIELD_ID)).clear();
        $(By.id(SEARCH_FIELD_ID)).sendKeys(accountName);
        clickOnSearchButton();
    }

    @Step("Set account number to account field in popup.")
    public void setAccountNumberToAccountFieldInPopup(String account, int counter) {
        $(REGIONS_ACCOUNT_FIELD_BY_COUNTER_IN_POPUP_XPATH, String.valueOf(counter)).sendKeys(account);
    }

    @Step("Click on send request button in pop-up.")
    public void clickOnSendRequestButtonInPopUp() {
        click(By.id(SEND_EXTERNAL_REQUEST_BUTTON_ID));
    }

    @Step("Switch to pending tab.")
    public void switchToPendingTab() {
        waitForElementToDisappear(By.xpath(FULL_SCREEN_PROGRESS_INDICATOR_XPATH));
        click(PENDING_FOR_APPROVAL_TAB_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Get list of requested accounts.")
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

    @Step("Remove requested accounts.")
    public void removeRequestedAccounts(int countOfRequestedAccount) {
        for (int i = 0; i < countOfRequestedAccount; i++) {
            click(MORE_ACTIONS_THREE_DOT_ICON_XPATH);
            click(CANCEL_REQUEST_BUTTON_XPATH);
            click(CONFIRMATION_FOR_CANCELING_REQUEST_XPATH);
            waitForElementToDisappear(By.xpath(CANCEL_REQUEST_CONFIRMATION_POPUP_XPATH));
        }
    }

    public void isAccountPageFullyLoaded() {
        if (!isDisplayed(By.id(FAVORITES_ACCOUNTS_TABLE_ID))) {
            getDriver().navigate().refresh();
        }
    }

    @Step("Get Full Account Number with divisions In The Approved Accounts Table.")
    public String getFirstAccountFullInfo() {
        waitUntilPageIsFullyLoaded();
        return $(FULL_INFO_OF_FIRST_ACCOUNT_APPROVED_ACC_TAB_XPATH).getAttribute("href").split("/select-account/")[1];
    }

    @Step("Get No Data Title From Pending Accounts Table.")
    public String getNoDataTitleFromPendingAccountsTable() {
        waitUntilPageIsFullyLoaded();
        return $(PENDING_FOR_APPROVAL_TABLE_NO_DATA_TITLE_XPATH).getText();
    }

    @Step("Switch To Approved Accounts Tab.")
    public void switchToApprovedAccountsTab() {
        waitUntilPageIsFullyLoaded();
        click(APPROVED_ACCOUNTS_TAB_XPATH);
    }

    @Step("Switch To Favorites Accounts Tab.")
    public void switchToFavoritesAccountsTab() {
        waitUntilPageIsFullyLoaded();
        click(FAVORITES_ACCOUNTS_TAB_XPATH);
    }

    @Step("Get All Approved Accounts No In Approved Accounts Tab.")
    public List<String> getAllApprovedAccountsNoInApprovedAccountsTab() {
        return $$(APPROVED_ACCOUNTS_NO_IN_APPROVED_ACCOUNTS_TABLE_XPATH).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("Remove All Active Requested Accounts.")
    public void removeAllRequestedAccounts(ArrayList<String> approvedAccounts) {
        waitUntilPageIsFullyLoaded();
        approvedAccounts.forEach(this::removeAccountByAccountNo);
    }

    @Step("Is Active Favorite Tab Displayed.")
    public boolean isActiveFavoriteTabDisplayed() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(FAVORITES_ACTIVE_TAB_XPATH);
    }

    @Step("Set SO Code To The First SO Code Field In The Request Acc Pop Up.")
    public void setSOCodeToTheFirstSOCodeFieldInTheRequestAccPopUp(String code) {
        $(By.id(SALES_OFFICE_CODE_FIELD_ID)).sendKeys(code);
    }

    @Step("Click on Modify button in the Request Account pop-up.$")
    public void clickOnModifyButtonInTheRequestAccountPopUp() {
        waitUntilPageIsFullyLoaded();
        Actions action = new Actions(getDriver());
        action.moveToElement($(MODIFY_ACTIVE_BUTTON_XPATH)).click().build().perform();
    }

    @Step("Get Rejected request list messages")
    public Stream<WebElement> getRejectedRequestListMessages() {
        return $$(LIST_OF_REJECTED_INFO_MESSAGES_XPATH).stream();
    }

    @Step("Get List of rejected accounts.")
    public List<WebElement> getListOfApprovedAccounts() {
        return $$(By.xpath(APPROVED_ACCOUNTS_LIST_XPATH));
    }

    @Step("Get List of approved account names.")
    public Stream<WebElement> getListOfApprovedAccountNames() {
        return $$(APPROVED_ACCOUNTS_NAME_IN_APPROVED_ACCOUNTS_TABLE_XPATH).stream();
    }

    @Step("Get all approved accounts.")
    public Stream<WebElement> getAllApprovedAccounts() {
        waitUntilPageIsFullyLoaded();
        return $$(APPROVED_ACCOUNTS_LIST_XPATH).stream();
    }

    @Step("Remove account by account number.")
    public void removeAccountByAccountNo(String account) {
        waitUntilPageIsFullyLoaded();
        click(REMOVE_ACCOUNT_ACTION_FOR_APPROPRIATE_ACCOUNT_THREE_DOT_ICON_XPATH, account);
        click(THREE_DOT_ICON_REMOVE_ACCOUNT_XPATH, account);
        waitUntilPageIsFullyLoaded();
        click(CONFIRMATION_FOR_REMOVE_ACTIVE_ACCOUNT_BUTTON_ID);
        getDriver().navigate().refresh();
    }

    @Step("Mark appropriate account as favourite.")
    public void markAppropriateAccountAsFavorite(String accountDetails) {
        waitUntilPageIsFullyLoaded();
        click(NOT_FAVORITE_ACCOUNT_STAR_ICON_XPATH, accountDetails);
    }

    @Step("Get All favorites accounts.")
    public Stream<WebElement> getAllFavoriteAccounts() {
        return $$(LIST_OF_FAVORITES_ACCOUNTS_FULL_INFO_XPATH).stream();
    }

    @Step("Unmark as favorite appropriate account on the favorites tab.")
    public void unmarkAsFavoriteAppropriateAccountOnFavoritesTab(String favAccount) {
        waitUntilPageIsFullyLoaded();
        click(STAR_ICON_FOR_APPROPRIATE_ACCOUNT_ON_FAVORITES_TAB_XPATH, favAccount);
    }

    @Step("Check that favorite account is displayed on favorites tab.")
    public boolean isFavoriteAccountDisplayedOnFavoritesTab(String favAccount) {
        return isDisplayed(STAR_ICON_FOR_APPROPRIATE_ACCOUNT_ON_FAVORITES_TAB_XPATH, favAccount);
    }

    @Step("Get Pre Auth Code Section Title.")
    public String getPreAuthCodeSectionTitle() {
        waitUntilPageIsFullyLoaded();
        return $(PRE_AUTHORIZATION_CODE_SECTION_FIRST_PART_TITLE_XPATH).getText();
    }

    @Step("Set Data To Pre Auth Field.")
    public void setDataToPreAuthField() {
        $(PRE_AUTH_INPUT_XPATH).clear();
        $(PRE_AUTH_INPUT_XPATH).sendKeys(utils.getLocalDateTimeStamp());
    }

    @Step("Click On Go Pre Auth Code Button.")
    public void clickOnGoPreAuthCodeButton() {
        click(PRE_AUTH_GO_BUTTON_XPATH);
    }

    @Step("Is Pre Auth Accounts Table Displayed.")
    public boolean isPreAuthAccountsTableDisplayed() {
        return isDisplayed(PRE_AUTH_ACCOUNTS_TABLE_XPATH);
    }

    @Step("Is Pre Auth Accounts Table Empty.")
    public boolean isPreAuthAccountsTableEmpty() {
        return $(PRE_AUTH_ACCOUNTS_TABLE_BODY_XPATH).getText().length() == 0;
    }

    @Step("Click On Send Pre Auth Code.")
    public void clickOnSendPreAuthCode() {
        click(By.id(PRE_AUTH_SEND_REQUEST_BUTTON_ID));
    }

    @Step("Get Count Of Favorite Accounts.")
    public int getCountOfFavoriteAccounts() {
        waitUntilPageIsFullyLoaded();
        String countOfEntries = $(By.id(COUNT_OF_FAVORITE_ACCOUNTS_ON_FAVORITES_TAB_ID)).getText();
        String[] countOfFavorites = countOfEntries.split(" ");
        return Integer.parseInt(countOfFavorites[5]);
    }

    @Step("Get List Of Not Favorite Accounts.")
    public List<WebElement> getListOfNotFavoritesAccounts() {
        return $$(LIST_OF_NOT_FAVORITES_ACCOUNTS_XPATH);
    }

    @Step("Is Request Account Button Displayed.")
    public boolean isRequestAccountButtonDisplayed() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(REQUEST_ACCOUNT_BUTTON_XPATH);
    }

    @Step("Is Favorite Accounts Tab Displayed.")
    public boolean isFavoriteAccountsTabDisplayed() {
        return isDisplayed(FAVORITES_ACCOUNTS_TAB_XPATH);
    }

    @Step("Is Pending For Approval Tab Displayed.")
    public boolean isPendingForApprovalTabDisplayed() {
        return isDisplayed(PENDING_FOR_APPROVAL_TAB_XPATH);
    }

    @Step("Is Accounts Tab Displayed.")
    public boolean isAccountsTabDisplayed() {
        return isDisplayed(APPROVED_ACCOUNTS_TAB_XPATH);
    }

    @Step("Get Approved Accounts Table Size.")
    public int getApprovedAccountsTableSize() {
        return $$(APPROVED_ACCOUNTS_TABLE_XPATH).size();
    }

    @Step("Get No Data Title From Accounts Table.")
    public String getNoDataTitleFromAccountsTable() {
        return $(APPROVED_ACCOUNTS_TABLE_XPATH).getText();
    }

    @Step("User Hover Mouse Over Red Triangle Icon.")
    public void userHoverMouseOverRedTriangleIcon() {
        waitUntilPageIsFullyLoaded();
        moveToElement($(RED_EXCLAMATION_TRIANGLE_ICON_XPATH));
    }

    @Step("User Hover Mouse Over Red Certificate Icon.")
    public void userHoverMouseOverRedCertificateIcon() {
        waitUntilPageIsFullyLoaded();
        moveToElement($(RED_CERTIFICATION_ICON_XPATH));
    }

    @Step("Get Stopbook Stopship Tooltip Text.")
    public String getStopBookStopShipTooltipText() {
        return $(STOP_BOOK_STOP_SHIP_TOOLTIP_TEXT_XPATH).getText();
    }
}