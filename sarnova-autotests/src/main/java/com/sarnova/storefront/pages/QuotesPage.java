package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class QuotesPage extends StorefrontBasePage {

    private String pageUrlMethod = "boundtree/en/USD/my-account/my-quotes";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
