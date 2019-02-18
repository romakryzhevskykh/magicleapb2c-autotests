package com.template.storefront.pages;

import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

@Component
public class OrderConfirmationPage extends StorefrontBasePage{

    private final String pageADD = "powertools/en/USD/";
    private String pageUrlMethod = "checkout/orderConfirmation/%s";

    @Step("Is Order confirmation page opened?")
    public boolean isOpened() {
        return getCurrentUrl().contains(getPageUrl(""));
    }

    @Step("Is Order confirmation page opened for order id: {0}?")
    public boolean isOpened(String id) {
        return getPageUrl(id).equals(getCurrentUrl());
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl()+ pageADD + pageUrlMethod;
    }

    public String getPageUrl(String orderNumber) {
        return String.format(getPageUrl(), orderNumber);
    }
}
