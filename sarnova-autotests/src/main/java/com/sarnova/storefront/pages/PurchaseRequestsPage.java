package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class PurchaseRequestsPage extends StorefrontBasePage {

    private String pageUrlMethod = "my-account/approval-dashboard";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
