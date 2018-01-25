package com.sarnova.storefront.pages;

import com.sarnova.storefront.page_blocks.LoggedOutHeaderRowBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

@Component
public class StartPage extends StorefrontBasePage {
    private final String pageUrlMethod = "powertools/en/USD/";

    @Autowired LoggedOutHeaderRowBlock loggedOutHeaderRowBlock;

    @Step("Check that Start page is opened.")
    public boolean isStartPageOpened() {
        return isCurrentURLEqualsToStartPageURL() && isUserLoggedOut();
    }

    public void clickOnSignInButton() {
        loggedOutHeaderRowBlock.clickOnSignInButton();
    }

    @Step("Open Start page using url.")
    public void openStartPage() {
        open(storefrontProject.getBaseUrl());
    }

    @Step("Check that current url is Start page url.")
    private boolean isCurrentURLEqualsToStartPageURL() {
        return storefrontProject.getBaseUrl().equals(getCurrentUrl());
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
