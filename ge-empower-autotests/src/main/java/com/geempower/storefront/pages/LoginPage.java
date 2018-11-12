package com.geempower.storefront.pages;

import com.geempower.helpers.user_engine.User;
import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.geempower.hybris.backoffice.page_elements.LoginPageElements.WELCOME_TO_EMPOWER_TITLE_XPATH;

@Component
public class LoginPage extends StorefrontBasePage {

    private final String pageUri = "index.html";

    @Override
    public boolean isOpened() {
        waitUntilPageIsFullyLoaded();
        return getCurrentUrl().contains(getPageUrl());
    }

    public void waitForIndexHtmlLoginPage() {
        waitForElementWithAppropriateTextToAppear(By.xpath(WELCOME_TO_EMPOWER_TITLE_XPATH), "Welcome to empower!");
    }

    @Override
    public String getPageUrl() {
        waitUntilPageIsFullyLoaded();
        return storefrontProject.getBaseUrl().replace("geempower/", "").replace("https", "").concat(pageUri);
    }

    public void loginToStorefront(User user) {

    }
}
