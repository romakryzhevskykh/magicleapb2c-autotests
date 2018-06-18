package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class DSCSATransactionsPage extends StorefrontBasePage {

    private String pageUrlMethod = "boundtree/en/USD/reports/dscsa";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
