package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class PurchaseSummaryPage extends StorefrontBasePage {

    private String pageUrlMethod = "reports/purchase-summary";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
