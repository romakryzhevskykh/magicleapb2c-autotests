package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class SavedCartsPage extends StorefrontBasePage {

    private String pageUrlMethod = "boundtree/en/USD/my-account/saved-carts";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
