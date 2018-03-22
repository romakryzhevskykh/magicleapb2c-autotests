package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class HelpNewToBoundtreePage extends StorefrontBasePage {

    private String pageUrlMethod = "boundtree/en/USD/my-account/help-new-to-boundtree";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
