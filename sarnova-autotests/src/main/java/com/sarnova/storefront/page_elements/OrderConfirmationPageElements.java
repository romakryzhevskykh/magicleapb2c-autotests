package com.sarnova.storefront.page_elements;

public class OrderConfirmationPageElements {
    private static final String ORDER_CONFIRMATION_INFO_HEADER_XPATH = "//div[@class='yCmsContentSlot account-section-content checkout__confirmation__content']/div[@class='yCmsComponent checkout__confirmation__content--component'][2]";

    public static final String SHIPPING_ADDRESS_XPATH = "//div[contains(@class, 'order-ship-to')][1]/div[@class='value-order']";
    public static final String SHIPPING_METHOD_XPATH = ORDER_CONFIRMATION_INFO_HEADER_XPATH + "//div[@class='row']//div[@class='item-group'][span[@class='item-label'][.='Shipping Method']]/span[@class='item-value']";
    public static final String BILLING_ADDRESS_XPATH = "//div[contains(@class, 'order-ship-to')][2]/div[@class='value-order']";
    public static final String PAYMENT_TYPE_DATA_XPATH = ORDER_CONFIRMATION_INFO_HEADER_XPATH + "//div[@class='row']//div[@class='item-group'][span[@class='item-label'][.='Payment Information']]/span[@class='item-value']";
}
