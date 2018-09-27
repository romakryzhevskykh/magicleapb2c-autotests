package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class OrderHistoryPage extends StorefrontBasePage implements DefaultHomePage {

    private String pageUrlMethod = "my-account/orders";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
