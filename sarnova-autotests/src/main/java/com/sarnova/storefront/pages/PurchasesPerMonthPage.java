package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class PurchasesPerMonthPage extends StorefrontBasePage {

    private String pageUrlMethod = "reports/purchases-per-month";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
