package com.geempower.storefront.page_elements;

public class OrderEntry3PageElements {
    public final static String ORDER_SUMMARY_TITLE_XPATH = ".//*[@id='order-summary']/div[1]/div[1]/ul/li[3]";
    public final static String PLACE_ORDER_TOP_BUTTON_XPATH = ".//*[@id='order-summary']/div[1]/div[2]/div/ul/li/button";
    public final static String PLACE_ORDER_BOTTOM_BUTTON_XPATH = "//div[contains(@class, 'order-footer clearfix')]//button[contains(@class,'place-order-btn')]";
    public final static String ORDER_SUMMARY_STEP_TITLE_XPATH = ".//*[@class='order-summary active']";
    public final static String PO_NUMBER_SUMMARY_XPATH = ".//*[@class='poNumberSummary']";
    public final static String TERMS_AND_CONDITIONS_CHECKBOX_XPATH = "//div[@id='terms-condition-modal']//ins";
    public final static String SUBMIT_ORDER_BUTTON_IN_TERMS_POP_UP_XPATH = "//button[@class='btn primary-btn submit-order-btn']";
    public final static String ORDER_CONFIRMATION_POP_UP_TITLE_XPATH= "//div[@id='order-confirmation-modal']//h4";
    public final static String GE_ORDER_NUMBER_ON_THE_CONFIRMATION_POP_UP_XPATH = "//div[@id='order-confirmation-modal']//span[@class='orderNumber']";
    public final static String CLOSE_ORDER_CONFIRMATION_POP_UP_XPATH = "//*[@id='order-confirmation-modal']//button[@type='button']";
}
