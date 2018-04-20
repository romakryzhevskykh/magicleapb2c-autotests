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

    @Step("Get Manage Users title")
    public String getManageUsersTitle() {
        return $(MANAGE_USERS_TITLE_XPATH).getText();
    }
}
