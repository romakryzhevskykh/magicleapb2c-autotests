package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class ReplenishmentOrdersPage extends StorefrontBasePage {

    private String pageUrlMethod = "my-account/my-replenishment";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
