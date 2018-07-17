package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class SavedCreditCardsPage extends StorefrontBasePage {

    private String pageUrlMethod = "my-account/payment-details";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
