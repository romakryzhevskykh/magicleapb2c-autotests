package com.geempower.storefront.page_elements;

public class OrderEntry2PageElements {
    public final static String SHIPPING_BILLING_TITLE_XPATH = ".//li[@class='shipping-billing-info active']";

    public final static String ORDER_DETAILS_HEADER_XPATH = ".//h4[contains (text(),'Order Details')]";
    public final static String PO_NO_FIELD_ID = "poNumber";
    public final static String JOB_NAME_FIELD_ID = "jobName";
    public final static String PAYER_TITLE_XPATH = "//*[@id='shipping-billing-info']//label[contains (text(),'Payer')]";

    public final static String SHIPMENT_ADDRESS_TITLE_XPATH = "//*[@id='shipping-billing-info']//label[contains (text(),'Shipment Address')]";
    public final static String ADDRESS_DETAILS_HEADER_XPATH = "//*[@id='shipping-billing-info']//h4[contains (text(),'Address Details')]";
    public final static String MANAGE_ADDRESS_BUTTON_XPATH = ".//*[@data-target='#manage-address-modal']";

    public final static String SHIPPING_DETAILS_HEADER_XPATH = "//*[@id='shipping-billing-info']//h4[contains (text(),'Shipment Details')]";
    public final static String SHIP_PAYMENT_METHOD_TITLE_XPATH = "//*[@id='shipping-billing-info']//label[contains (text(),'Ship Payment Method')]";
    public final static String SHIP_METHOD_TITLE_XPATH = "//*[@id='shipping-billing-info']//label[contains (text(),'Ship Method')]";
    public final static String SHIPPING_NOTE_TITLE_XPATH = "//*[@id='shipping-billing-info']//label[contains (text(),'Shipping Note')]";
    public final static String REQUESTED_DELIVERY_DATE_TITLE_XPATH = "//*[@id='shipping-billing-info']//label[contains (text(),'Requested Delivery Date')]";
    public final static String PARTIAL_DELIVERY_TITLE_XPATH = "//label[contains (text(),'partial delivery')]";
    public final static String BEFORE_DELIVERY_DATE_TITLE_XPATH = "//label[contains (text(),'delivery date')]";

}
