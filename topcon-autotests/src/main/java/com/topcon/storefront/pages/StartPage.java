package com.topcon.storefront.pages;

import com.topcon.storefront.page_blocks.LoggedOutHeaderRowBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

@Component
public class StartPage extends StorefrontBasePage {

    @Autowired private LoggedOutHeaderRowBlock loggedOutHeaderRowBlock;

    private final String pageUrlMethod = "topcon/en/USD/login";

    @Step("Check that Start page is opened.")
    public boolean isOpened() {
        return isCurrentURLEqualsToStartPageURL() && isUserLoggedOut();
    }

    public void clickOnSignInButton() {
        loggedOutHeaderRowBlock.clickOnSignInButton();
    }

    @Step("Check that current url is Start page url.")
    private boolean isCurrentURLEqualsToStartPageURL() {
        return getPageUrl().equals(getCurrentUrl());
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
