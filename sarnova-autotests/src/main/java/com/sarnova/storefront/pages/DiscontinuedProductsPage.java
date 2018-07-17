package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class DiscontinuedProductsPage extends StorefrontBasePage {

    private String pageUrlMethod = "reports/replacement-products";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
