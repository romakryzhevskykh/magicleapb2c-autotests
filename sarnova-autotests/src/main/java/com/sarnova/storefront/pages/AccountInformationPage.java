package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class AccountInformationPage extends StorefrontBasePage {

    private String pageUrlMethod = "boundtree/en/USD/my-account/update-profile";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
