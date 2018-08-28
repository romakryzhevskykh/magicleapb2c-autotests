package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class AccountSettingsPage extends StorefrontBasePage {

    private String pageUrlMethod = "my-account/update-profile";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
