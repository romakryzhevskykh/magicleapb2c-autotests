package com.geempower.storefront.pages;

import com.geempower.helpers.user_engine.User;
import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends StorefrontBasePage {

    private final String pageUri = "login";

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }


    public void loginToStorefront(User user) {

    }
}
