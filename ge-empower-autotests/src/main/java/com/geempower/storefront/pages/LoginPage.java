package com.geempower.storefront.pages;

import com.geempower.helpers.user_engine.User;
import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends StorefrontBasePage {

    private final String pageUri = "index.html";

    @Override
    public boolean isOpened() {
        waitUntilPageIsFullyLoaded();
        return getCurrentUrl().contains(getPageUrl());
    }

    @Override
    public String getPageUrl() {
        waitUntilPageIsFullyLoaded();
        return storefrontProject.getBaseUrl().replace("geempower/", "").replace("https", "").concat(pageUri);
    }

    public void loginToStorefront(User user) {

    }
}
