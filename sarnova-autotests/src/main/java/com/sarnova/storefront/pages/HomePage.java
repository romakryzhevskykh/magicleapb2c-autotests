package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

@Component
public class HomePage extends StorefrontBasePage {
    private final String pageUrlMethod = "powertools/en/USD/";

    public boolean isHomePageOpened() {
        return isCurrentURLEqualsToHomePageURL() && isUserLoggedIn();
    }

    @Step("Check that current url is Home page url.")
    private boolean isCurrentURLEqualsToHomePageURL() {
        return storefrontProject.getBaseUrl().equals(getCurrentUrl());
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
