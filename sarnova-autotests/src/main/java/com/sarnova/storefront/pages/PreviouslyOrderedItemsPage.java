package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class PreviouslyOrderedItemsPage extends StorefrontBasePage implements DefaultHomePage {

    private String pageUrlMethod = "my-account/previously-ordered-items";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }

}
