package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

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
        return $(MANAGE_USERS_TITLE_XPATH).getText();
    }

    @Step("Open Users tab.")
    public void openUsersTab() {
        $(USERS_TAB_XPATH).click();
        waitUntilPageIsFullyLoaded();
    }

    @Step("Set email to the search field.")
    public void setEmailToTheSearchField(String email) {
        $(USER_TERM_INPUT_XPATH).clear();
        $(USER_TERM_INPUT_XPATH).sendKeys(email);
    }

    @Step("Click on Search User button.")
    public void clickOnSearchUserButton() {
        $(SEARCH_USER_BY_PARAMS_BUTTON_XPATH).click();
        waitUntilPageIsFullyLoaded();
    }

    @Step("Get first user email from the list.")
    public String isUserFoundByEmail() {
        waitUntilPageIsFullyLoaded();
        return $(USER_EMAIL_FIELD_XPATH).getText();
    }

    @Step("Click on User Name in the table.")
    public void clickOnTheUserNameInTheTable() {
        click(FIRST_NAME_LINK_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Click on Add Account Button In User Detail Block .")
    public void clickOnAddAccountButtonInUserDetailBlock() {
        click(ADD_ACCOUNT_BUTTON_XPATH);
    }

    @Step("Add Account Pop Up Title is Displayed On Manage Users Page.")
    public String getAddAccPopUpTitle() {
        waitUntilPageIsFullyLoaded();
        return $(ADD_ACCOUNT_TITLE_XPATH).getText();
    }

    @Step("Set SO Code To The Sales Office Code Field.")
    public void setSoCodeToTheSalesOfficeCodeField(String code) {
        $(By.id(SALES_OFFICE_CODE_FIELD_ID)).sendKeys(code);
    }

    @Step("Click on Modify Button.")
    public void clickOnModifyButtonInTheAddAccountPopUp() {
        $(MODIFY_ACTIVE_BUTTON_XPATH).click();
    }

    @Step("Select Region")
    public void selectRegion(String region) {
        waitUntilPageIsFullyLoaded();
        click(By.id(SELECT_REGION_FIELD_ID));
        $$(REGION_DROP_DOWN_LIST_ELEMENTS_XPATH).stream()
                .filter(webElement -> webElement.getText().equals(region)).findAny().ifPresent(WebElement::click);
    }

    @Step("Set SO Code To The Second Sales Office Code Field.")
    public void setSoCodeToTheSecondSalesOfficeCodeField(String code) {
        waitUntilPageIsFullyLoaded();
        $(By.id(SALES_OFFICE_CODE_SECOND_FIELD_ID)).sendKeys(code);
    }

    @Step("Click On Search Button In The Add Account Pop-Up.")
    public void clickOnTheSearchButtonInTheAddAccountPopUp() {
        waitUntilPageIsFullyLoaded();
        $(SEARCH_BUTTON_XPATH).click();
    }

    @Step("Check that Add New Accounts Table Is Displayed in the Add Account Pop-Up.")
    public void addNewAccountsTableIsDisplayed() {
        isDisplayed(By.id(ADD_NEW_ACCOUNTS_TABLE_ID));
    }

    @Step("Get Account Name from Add Account Pop-Up.")
    public String getAccountNameFromAddAccPopUp() {
        isDisplayed(ACCOUNT_NAME_NEW_ACC_TABLE_XPATH);
        return $(ACCOUNT_NAME_NEW_ACC_TABLE_XPATH).getText();
    }

}
