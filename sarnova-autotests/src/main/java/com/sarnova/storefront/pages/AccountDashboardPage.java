package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class AccountDashboardPage extends StorefrontBasePage {

    private String pageUrlMethod = "boundtree/en/USD/my-account/account-dashboard";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
