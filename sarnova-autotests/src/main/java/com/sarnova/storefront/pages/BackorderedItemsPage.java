package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class BackorderedItemsPage extends StorefrontBasePage {

    private String pageUrlMethod = "boundtree/en/USD/reports/backordered-items";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
