package com.geempower.storefront.pages;

import com.geempower.helpers.Utils;
import com.geempower.storefront.StorefrontBasePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.AccountManagementPageElements.FAVORITES_ACTIVE_TAB_XPATH;

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

    @Step("Is Active Favorite Tab Displayed.")
    public boolean isActiveFavoriteTabDisplayed() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(FAVORITES_ACTIVE_TAB_XPATH);
    }

}