package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class QuotesPage extends StorefrontBasePage implements DefaultHomePage {

    private String pageUrlMethod = "my-account/my-quotes";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
