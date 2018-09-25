package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class HelpPage extends StorefrontBasePage implements DefaultHomePage {

    private String pageUrlMethod = "help";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }

}
