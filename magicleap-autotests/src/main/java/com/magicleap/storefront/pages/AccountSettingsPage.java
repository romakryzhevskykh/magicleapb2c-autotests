package com.magicleap.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class AccountSettingsPage extends StorefrontBasePage{

    private final String pageUrlMethod = "/#/account/settings";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
