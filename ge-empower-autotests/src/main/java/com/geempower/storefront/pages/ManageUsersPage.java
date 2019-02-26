package com.geempower.storefront.pages;

import com.geempower.helpers.Utils;
import com.geempower.helpers.models.Region;
import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.stream.Collectors;

import static com.geempower.storefront.page_block_elements.IwantToBlockElements.APPROVE_PENDING_ACCOUNTS_SECTION_TITLE_XPATH;
import static com.geempower.storefront.page_block_elements.IwantToBlockElements.TOTAL_ACCOUNT_REQUESTS_XPATH;
import static com.geempower.storefront.page_elements.manageUsers.ManageUsersPageElements.*;

@Component
public class ManageUsersPage extends StorefrontBasePage {
    @Autowired
    private Utils utils;

    private final String pageUri = "user/admin/my-account/manage-users";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Get Manage Users title.")
    public String getManageUsersTitle() {
        waitUntilPageIsFullyLoaded();
        return $(MANAGE_USERS_TITLE_XPATH).getText();
    }

    @Step("Open Users tab.")
    public void openUsersTab() {
        waitUntilPageIsFullyLoaded();
        utils.pageScrollUp();
        click(USERS_TAB_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Set email to the search field.")
    public void setEmailToTheSearchField(String email) {
        waitUntilPageIsFullyLoaded();
        $(USER_TERM_INPUT_XPATH).clear();
        $(USER_TERM_INPUT_XPATH).sendKeys(email);
    }

    @Step("Click on Search User button.")
    public void clickOnSearchUserButton() {
        click(SEARCH_USER_BY_PARAMS_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Get first user email from the list.")
    public String isUserFoundByEmail() {
        waitUntilPageIsFullyLoaded();
        return $(USER_EMAIL_FIELD_XPATH).getText();
    }

    @Step("Click on Add Account Button In User Detail Block.")
    public void clickOnAddAccountButtonInUserDetailBlock() {
        waitUntilPageIsFullyLoaded();
        moveToElement($(ADD_ACCOUNT_BUTTON_XPATH));
        $(ADD_ACCOUNT_BUTTON_XPATH).click();
    }

    @Step("Get Add Account Pop Up Title.")
    public String getAddAccPopUpTitle() {
        waitUntilPageIsFullyLoaded();
        utils.pageScrollUp();
        return $(ADD_ACCOUNT_TITLE_XPATH).getText();
    }

    @Step("Set SO Code To The Sales Office Code Field.")
    public void setSoCodeToTheFirstSalesOfficeCodeField(String code) {
        $(By.id(SALES_OFFICE_CODE_FIELD_ID)).sendKeys(code);
    }

    @Step("Click on Modify Button In The Add Account Pop-Up.")
    public void clickOnModifyButtonInTheAddAccountPopUp() {
        click(MODIFY_ACTIVE_BUTTON_XPATH);
    }

    @Step("Select Region In The Add Account Pop-Up.")
    public void selectRegionInTheAddAccountPopUp(Region region) {
        waitUntilPageIsFullyLoaded();
        click(By.id(SELECT_REGION_FIELD_ID));
        waitUntilPageIsFullyLoaded();
        chooseRegion(region);
    }

    @Step("Select appropriate region by region name")
    private void chooseRegion(Region region) {
        click(APPROPRIATE_REGION_BY_NAME_IN_ADD_ACC_POP_UP_XPATH, region.getRegionType().getRegionName());
    }

    @Step("Set SO Code To The Second Sales Office Code Field.")
    public void setSoCodeToTheSecondSalesOfficeCodeField(String code) {
        waitUntilPageIsFullyLoaded();
        $(By.id(SALES_OFFICE_CODE_SECOND_FIELD_ID)).sendKeys(code);
    }

    @Step("Click On Search Button In The Add Account Pop-Up.")
    public void clickOnTheSearchButtonInTheAddAccountPopUp() {
        waitUntilPageIsFullyLoaded();
        click(SEARCH_BUTTON_XPATH);
    }

    @Step("Get Account No from Add Account Pop-Up.")
    public String getAccountNoFromAddAccPopUp() {
        waitUntilPageIsFullyLoaded();
        return $(ACCOUNT_NO_NEW_ACC_TABLE_XPATH).getText();
    }

    @Step("Check that Add New Accounts Table Is Displayed in the Add Account Pop-Up.")
    public boolean addNewAccountsTableIsDisplayed() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(By.id(ADD_NEW_ACCOUNTS_TABLE_ID));
    }

    @Step("Is Add Account Pop-up displayed.")
    public boolean isAddAccountPopUpDisplayed() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(ADD_ACCOUNT_POP_UP_XPATH);
    }

    @Step("Is Assign/Modify Rep.Code Pop-up displayed.")
    public boolean isAssignModifyRepCodePopUpDisplayed() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(By.id(ASSIGN_MODIFY_REP_CODE_POP_UP_ID));
    }

    @Step("Set Account To The Account Search Field.")
    public void setAccountToTheAccountSearchField(String account) {
        $(ACCOUNT_DETAIL_SEARCH_INPUT_XPATH).clear();
        $(ACCOUNT_DETAIL_SEARCH_INPUT_XPATH).sendKeys(account);
    }

    @Step("Check than users list is not empty.")
    public boolean isUsersListNotEmpty() {
        waitUntilPageIsFullyLoaded();
        return $(USERS_TABLE_XPATH + FIRST_USER_XPATH).isDisplayed();
    }

    @Step("Click on User Name in the table")
    public void clickOnTheUserNameInTheTableWithPendingRequests(int countOfAccount) {
        waitUntilPageIsFullyLoaded();
        int counter = 0;
        do {
            click(FIRST_NAME_LINK_XPATH);
            waitUntilPageIsFullyLoaded();
            counter++;
        }
        while (!isUserDetailFullyLoaded(countOfAccount) && counter < 50);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Click on User Name in the table")
    public void clickOnTheUserNameInTheTable() {
        waitUntilPageIsFullyLoaded();
        click(FIRST_NAME_LINK_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    private boolean isUserDetailFullyLoaded(int countOfAccount) {
        return isDisplayed(APPROVE_PENDING_ACCOUNTS_SECTION_TITLE_XPATH)
                && Integer.parseInt($(TOTAL_ACCOUNT_REQUESTS_XPATH).getText()) == countOfAccount;
    }

    @Step("Check that user details block is opened.")
    public boolean isUserDetailsBlockOpened() {
        waitUntilPageIsFullyLoaded();
        utils.pageScrollUp();
        return isDisplayed(USER_DETAILS_BLOCK_XPATH);
    }

    @Step("Getting user's id from the user's details block.")
    public String getUserIdFromUserDetailsBlock() {
        return $(USER_DETAILS_USER_ID_XPATH).getText();
    }

    @Step("Open Actions list.")
    public void openActionsList() {
        waitUntilPageIsFullyLoaded();
        click(USER_ACTIONS_LIST_OPEN_ICON_XPATH);
    }

    @Step("Getting user's actual status.")
    public String getUserStatus() {
        waitUntilPageIsFullyLoaded();
        return $(ACTIVE_USER_STATUS_LABEL_XPATH).getText();
    }

    @Step("Click on appropriate option in actions list.")
    public void clickOnAppropriateOptionOnActionsList(String actionName) {
        click(APPROPRIATE_USER_OPTION_XPATH, actionName);
    }

    @Step("Getting user's sub status.")
    public String getFullUserSubStatus() {
        return $(FULL_USER_SUB_STATUS_XPATH).getText();
    }

    @Step("Set SE Code To The Second Sales Engineer Code Field In The Add Account Pop-Up.")
    public void setSECodeToTheSecondSalesEngineerCodeFieldInTheAddAccountPopUp(String code) {
        waitUntilPageIsFullyLoaded();
        $(By.id(SALES_ENGINEER_CODE_SECOND_FIELD_ID)).sendKeys(code);
    }

    @Step("Set SE Code To The First Sales Engineer Code Field In The Add Account Pop-Up.")
    public void setSeCodeSECodeToTheFirstSalesEngineerCodeFieldInTheAddAccountPopUp(String code) {
        $(By.id(SALES_ENGINEER_CODE_FIELD_ID)).sendKeys(code);
    }

    @Step("Set Account To The Account Field In The Add Account Pop-Up.")
    public void setAccountToTheAccountFieldInTheAddAccountPopUp(String account) {
        waitUntilPageIsFullyLoaded();
        $(ACCOUNT_FIELD_XPATH).sendKeys(account);
    }

    @Step("Click On Select All Checkbox In The Add Account Pop-Up.")
    public void clickOnSelectAllCheckboxInTheAddAccountPopUp() {
        waitUntilPageIsFullyLoaded();
        click(SELECT_ALL_CHECKBOX_XPATH);
    }

    @Step("Click On Add Button In The Add Account Pop-Up.")
    public void clickOnAddButtonInTheAddAccountPopUp() {
        click(By.id(ADD_BUTTON_ID));
    }

    @Step("Get User Full Name In Details Block.")
    public String getUserFullNameInDetailsBlock() {
        return $(USER_FULL_NAME_IN_USER_DETAILS_BLOCK_XPATH).getText();
    }

    @Step("Admin Expands User Details Block.")
    public void adminExpandsUserDetailsBlock() {
        click(EXPAND_USER_DETAILS_BLOCK_BUTTON_XPATH);
    }

    @Step("Get Bottom Row In User Details Block.")
    public WebElement getBottomRowInUserDetailsBlock() {
        waitUntilPageIsFullyLoaded();
        return $(BOTTOM_ROW_IN__USER_DETAILS_BLOCK_XPATH);
    }

    @Step("Get Label Value In User Details Block.")
    public List<String> getAllLabelValuesInUserDetailsBlock() {
        return $$(ALL_LABEL_VALUES_IN_USER_DETAILS_BLOCK_XPATH).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("Get Label Value In User Details Block.")
    public String getLabelValueInUserDetailsBlock(String label) {
        return $(LABEL_VALUE_IN_USER_DETAILS_BLOCK_XPATH, label).getText();
    }

    @Step("Admin Closes User Details Block.")
    public void adminClosesUserDetailsBlock() {
        click(CLOSE_USER_DETAILS_BLOCK_BUTTON_XPATH);
    }

    @Step("Is Pending Request Tab Active.")
    public boolean isPendingRequestTabActive() {
        return $(ACTIVE_PENDING_REQUESTS_TAB_XPATH).getAttribute("class").equals("active");
    }

    @Step("Get Pages Count Of Pending Requests.")
    public int getPagesCountOfPendingRequests() {
        return Integer.parseInt($(COUNT_OF_PAGES_PENDING_REQUESTS_TAB_XPATH).getText().replace("of ", ""));
    }

    @Step("Get Count Of Pages On Pending Requests Tab.")
    private int getCountOfPagesOnPendingRequestsTab() {
        int actualCount = 0;
        if (isPaginatorDisplayed()) {
            actualCount = Integer.parseInt($(COUNT_OF_PAGES_PENDING_REQUESTS_TAB_XPATH).getText().replace("of ", ""));
        } else if (!isPaginatorDisplayed() && !isEmptyPendingRequestTableDisplayed()) {
            actualCount = 1;
        } else if (isEmptyPendingRequestTableDisplayed()) {
            actualCount = 0;
        }
        return actualCount;
    }

    @Step("Is Empty Pending Request Table Displayed.")
    private boolean isEmptyPendingRequestTableDisplayed() {
        return isDisplayed(EMPTY_PENDING_REQUESTS_TABLE_XPATH);
    }

    @Step("Is Admin Can See User On The Pending Requests Tab.")
    public boolean isAdminCanSeeUserOnThePendingRequestsTab(String userId) {
        waitUntilPageIsFullyLoaded();
        boolean result = false;
        int actualCountOfPages = getCountOfPagesOnPendingRequestsTab();
        for (int i = 0; i < actualCountOfPages; i++) {
            if ($$(PENDING_USERS_SSO_LIST_XPATH).stream().noneMatch(userSso -> userSso.getText().equals(userId))) {
                if (actualCountOfPages > 1) {
                    click(By.id(NEXT_PAGINATION_BUTTON_PENDING_TAB_ID));
                }
            } else if ($$(PENDING_USERS_SSO_LIST_XPATH).stream().anyMatch(userSso -> userSso.getText().equals(userId))) {
                result = true;
            }
        }
        return result;
    }

    @Step("Is Paginator Displayed.")
    private boolean isPaginatorDisplayed() {
        return isDisplayed(COUNT_OF_PAGES_PENDING_REQUESTS_TAB_XPATH);
    }

    @Step("Get No Accounts Label For User.")
    public String getNoAccountsLabelForUser(String userId, int pagesCount) {
        for (int i = 0; i < pagesCount; i++) {
            if ($$(PENDING_USERS_SSO_LIST_XPATH).stream().anyMatch(userSso -> userSso.getText().equals(userId))) {
                waitUntilPageIsFullyLoaded();
                return $(NO_ACCOUNTS_LABEL_FOR_APPROPRIATE_USER_XPATH, userId).getText();
            } else {
                waitUntilPageIsFullyLoaded();
                click(By.id(NEXT_PAGINATION_BUTTON_PENDING_TAB_ID));
            }
        }
        throw new NullPointerException("There is no user " + userId + " in Pending requests tab.");
    }

    @Step("Click On Envelope For Appropriate User.")
    public void clickOnEnvelopeForAppropriateUser(String userId) {
        waitUntilPageIsFullyLoaded();
        click(ENVELOPE_ICON_FOR_APPROPRIATE_USER_XPATH, userId);
    }

    @Step("Is Blue Internal User Icon Displayed For User.")
    public boolean isBlueInternalUserIconDisplayedForUser(String userId) {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(BLUE_INTERNAL_ICON_FOR_APPROPRIATE_USER_XPATH, userId);
    }

    @Step("Get Confirmation Pop-Up Title.")
    public String getConfirmationPopUpTitle() {
        waitUntilPageIsFullyLoaded();
        moveToElement($(CONFIRMATION_POP_UP_TITLE_XPATH));
        return $(CONFIRMATION_POP_UP_TITLE_XPATH).getText();
    }

    @Step("Close Confirmation Pop-Up.")
    public void closeConfirmationPopUp() {
        waitUntilPageIsFullyLoaded();
        click(CONFIRMATION_POP_UP_CLOSE_BUTTON_XPATH);
    }

    @Step("Get Found Users List.")
    public String getFoundUsersList() {
        return $(NO_DATA_AVAILABLE_IN_THE_USERS_LIST_XPATH).getText();
    }

    @Step("Assign Rep Code To User.")
    public void assignRepCodeToUser(String repCode) {
        waitUntilPageIsFullyLoaded();
        $(By.id(ATS_REP_CODE_FIELD_ID)).clear();
        $(By.id(ATS_REP_CODE_FIELD_ID)).sendKeys(repCode);
        click(By.id(ASSIGN_REP_CODE_BUTTON_ID));
        waitUntilPageIsFullyLoaded();
    }

    @Step("Confirm Delete User Action.")
    public void confirmDeleteUserAction() {
        waitUntilPageIsFullyLoaded();
        click(By.id(CONFIRM_DELETE_ACTION_BUTTON_ID));
        waitUntilPageIsFullyLoaded();
    }

    @Step("Click On Add Rep Code Button In User Detail Block.")
    public void clickOnAddRepCodeButtonInUserDetailBlock() {
        waitUntilPageIsFullyLoaded();
        click(ADD_REP_CODE_BUTTON_XPATH);
    }

    @Step("Hover Mouse Over Blue Icon For User.")
    public String hoverMouseOverBlueIconForUser(String userId) {
        click(BLUE_INTERNAL_ICON_FOR_APPROPRIATE_USER_XPATH, userId);
        moveToElement($(BLUE_INTERNAL_ICON_FOR_APPROPRIATE_USER_XPATH, userId));
        waitUntilPageIsFullyLoaded();
        return $(BLUE_INTERNAL_ICON_TOOLTIP_FOR_APPROPRIATE_USER_XPATH, userId).getText();
    }

    @Step("Clean Account Field.")
    public void cleanAccountField() {
        $(ACCOUNT_DETAIL_SEARCH_INPUT_XPATH).clear();
    }

    @Step("Delete user if necessary.")
    public void deleteUserIfNecessary(String userEmail, String actionName) {
        waitUntilPageIsFullyLoaded();
        if ($$(NO_DATA_AVAILABLE_IN_THE_USERS_LIST_XPATH).size()>2) {
            if ($(USER_EMAIL_FIELD_XPATH).getText().equals(userEmail)) {
                waitUntilPageIsFullyLoaded();
                click(FIRST_NAME_LINK_XPATH);
                waitUntilPageIsFullyLoaded();
                openActionsList();
                click(APPROPRIATE_USER_OPTION_XPATH, actionName);
                confirmDeleteUserAction();
            }
        }
    }
}