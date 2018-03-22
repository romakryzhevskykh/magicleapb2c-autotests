package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class OrderHistoryPage extends StorefrontBasePage {

    private String pageUrlMethod = "boundtree/en/USD/my-account/orders";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
