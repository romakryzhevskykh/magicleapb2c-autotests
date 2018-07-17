package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class PurchasesPerMonthPage extends StorefrontBasePage {

    private String pageUrlMethod = "purchases-per-month-report";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
