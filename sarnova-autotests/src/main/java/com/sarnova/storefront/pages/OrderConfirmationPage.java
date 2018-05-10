package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class OrderConfirmationPage extends StorefrontBasePage {

    private String pageUrlMethod = "boundtree/en/USD/checkout/orderConfirmation/%s";

    public String getPageUrl(String orderID) {
        return String.format(getPageUrl(), orderID);
    }

    public boolean isOpened(String orderID) {
        return getCurrentUrl().equals(getPageUrl(orderID));
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().contains(getPageUrl(""));
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
