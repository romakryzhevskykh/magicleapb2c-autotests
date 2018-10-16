package com.sarnova.storefront.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;
import org.openqa.selenium.support.ui.Select;


import static com.sarnova.storefront.page_elements.OrderConfirmationPageElements.*;

@Component
public class OrderConfirmationPage extends StorefrontBasePage {

    private String pageUrlMethod = "checkout/orderConfirmation/%s";

    public String getPageUrl(String orderID) {
        return String.format(getPageUrl(), orderID);
    }

    public boolean isOpened(String orderID) {
        return getCurrentUrl().equals(getPageUrl(orderID));
    }

    @Step("Get shipping address first last name text.")
    public String getFirstLastName() {
        return getShippingAddress().split("\n")[0].trim();
    }

    @Step("Get shipping address street name and number text.")
    public String getStreet() {
        return getShippingAddress().split("\n")[1].trim();
    }

    @Step("Get shipping address city and state name text.")
    public String getCityState() {
        return getShippingAddress().split("\n")[2].trim();
    }

    @Step("Get shipping address country and zip code text.")
    public String getCountryAndZipCode() {
        return getShippingAddress().split("\n")[3].trim();
    }

    @Step("Get shipping address from page.")
    private String getShippingAddress() {
        return $(SHIPPING_ADDRESS_XPATH).getText();
    }

    @Step("Get delivery method name from page.")
    public String getDeliveryMethodName() {
        return getShippingMethod().trim();
    }
//
//    @Step("Get delivery method explanation from page.")
//    public String getDeliveryMethodExplanation() {
//        return getShippingMethod().split("\n")[1].trim();
//    }

    @Step("Get Shipping method.")
    private String getShippingMethod() {
        return $(SHIPPING_METHOD_XPATH).getText();
    }

    @Step("Get billing address first last name text.")
    public String getBillingFirstLastName() {
        return getBillingAddress().split("\n")[0].trim();
    }

    @Step("Get billing address street name and number text.")
    public String getBillingStreet() {
        return getBillingAddress().split("\n")[1].trim();
    }

    @Step("Get billing address city and state name text.")
    public String getBillingCityState() {
        return getBillingAddress().split("\n")[2].trim();
    }

    @Step("Get billing address country and zip code text.")
    public String getBillingCountryAndZipCode() {
        return getBillingAddress().split("\n")[3].trim();
    }

    @Step("Get Payment type data.")
    public String getPaymentTypeData() {
        return $(PAYMENT_TYPE_DATA_XPATH).getText();
    }

    @Step("Get billing address from page.")
    private String getBillingAddress() {
        return $(BILLING_ADDRESS_XPATH).getText();
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
