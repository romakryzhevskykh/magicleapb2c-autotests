package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;

public class OrderEntry2 extends StorefrontBasePage {

    private final String pageUri = "checkout";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }
}
