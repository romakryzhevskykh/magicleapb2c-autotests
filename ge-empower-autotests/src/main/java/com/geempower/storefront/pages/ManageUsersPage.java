package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
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
    public void clickOnTheUserNameInTheTable() {
        click(FIRST_NAME_LINK_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Check that user details block is opened.")
    public boolean isUserDetailsBlockOpened() {
        waitUntilPageIsFullyLoaded();
        return $(USER_DETAILS_BLOCK_XPATH).isDisplayed();
    }

    @Step("Getting user's id from the user's details block.")
    public String getUserIdFromUserDetailsBlock() {
        return $(USER_DELAILS_USER_ID_XPATH).getText();
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
        $(APPROPRIATE_USER_OPTION_XPATH, actionName).click();
    }

    @Step("Getting user's sub status.")
    public String getFullUserSubStatus() {
        return $(FULL_USER_SUB_STATUS_XPATH).getText();
    }
}
