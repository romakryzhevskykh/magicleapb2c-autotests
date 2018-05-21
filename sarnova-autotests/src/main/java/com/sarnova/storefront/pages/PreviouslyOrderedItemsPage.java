package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class PreviouslyOrderedItemsPage extends StorefrontBasePage {

    private String pageUrlMethod = "boundtree/en/USD/my-account/previously-ordered-items";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
