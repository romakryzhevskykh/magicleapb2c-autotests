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
}
