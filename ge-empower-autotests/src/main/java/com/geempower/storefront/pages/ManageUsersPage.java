package com.geempower.storefront.pages;

import com.geempower.helpers.models.Region;
import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.stream.Collectors;

import static com.geempower.storefront.page_block_elements.IwantToBlockElements.*;
import static com.geempower.storefront.page_elements.manageUsers.ManageUsersPageElements.*;

@Component
public class ManageUsersPage extends StorefrontBasePage {
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
        ((JavascriptExecutor) getDriver()).executeScript("scroll(0,0)");
        click(ADD_ACCOUNT_BUTTON_XPATH);
    }

    @Step("Get Add Account Pop Up Title.")
    public String getAddAccPopUpTitle() {
        waitUntilPageIsFullyLoaded();
        ((JavascriptExecutor) getDriver()).executeScript("scroll(0,0)");
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

    @Step("Is Add Account Pop-up is displayed.")
    public boolean isAddAccountPopUpDisplayed() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(ADD_ACCOUNT_POP_UP_XPATH);
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
        ((JavascriptExecutor)getDriver()).executeScript("scroll(0,0)");
        return isDisplayed(USER_DETAILS_BLOCK_XPATH);
    }

    @Step("Getting user's id from the user's details block.")
    public String getUserIdFromUserDetailsBlock() {
        return $(USER_DETAILS_USER_ID_XPATH).getText();
    }

    @Step("Open Actions list.")
    public void openActionsList() {
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

    public boolean isPendingRequestTabActive() {
        return $(ACTIVE_PENDING_REQUESTS_TAB_XPATH).getAttribute("class").equals("active");
    }

    public int getPagesCountOfPendingRequests() {
        return Integer.parseInt($(COUNT_OF_PAGES_PENDING_REQUESTS_TAB_XPATH).getText().replace(" of ", ""));
    }
}