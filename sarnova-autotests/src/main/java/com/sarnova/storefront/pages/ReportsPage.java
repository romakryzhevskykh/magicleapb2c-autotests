package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class ReportsPage extends StorefrontBasePage {

    private String pageUrlMethod = "boundtree/en/USD/reports";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
