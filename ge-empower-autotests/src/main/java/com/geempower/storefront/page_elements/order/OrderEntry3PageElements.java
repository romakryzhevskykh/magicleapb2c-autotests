package com.geempower.storefront.page_elements.order;

public class OrderEntry3PageElements {

    public final static String PLACE_ORDER_TOP_BUTTON_XPATH = ".//*[@id='order-summary']/div[1]/div[2]/div/ul/li/button";
    public final static String PLACE_ORDER_BOTTOM_BUTTON_XPATH = "//div[contains(@class, 'order-footer clearfix')]//button[contains(@class,'place-order-btn')]";
    public final static String ORDER_SUMMARY_STEP_TITLE_XPATH = ".//*[@class='order-summary active']";
    public final static String PO_NUMBER_SUMMARY_XPATH = ".//*[@class='poNumberSummary']";
    public final static String TERMS_AND_CONDITIONS_CHECKBOX_XPATH = "//div[@id='terms-condition-modal']//ins";
    public final static String SUBMIT_ORDER_BUTTON_IN_TERMS_POP_UP_XPATH = "//button[@class='btn primary-btn submit-order-btn']";
    public final static String ORDER_CONFIRMATION_POP_UP_TITLE_XPATH = "//div[@id='order-confirmation-modal']//h4";
    public final static String GE_ORDER_NUMBER_ON_THE_CONFIRMATION_POP_UP_XPATH = "//div[@id='order-confirmation-modal']//span[@class='orderNumber']";
    public final static String CLOSE_ORDER_CONFIRMATION_POP_UP_XPATH = "//*[@id='order-confirmation-modal']//button[@type='button']";

    public final static String PRODUCT_DETAILS_BLOCK_XPATH = ".//table[@id='DataTables_Table_1']";
    public final static String PRODUCT_DETAILS_BLOCK_CATALOG_NO_XPATH = PRODUCT_DETAILS_BLOCK_XPATH + "//a[@data-target='#product-detail-modal-1']";
    public final static String PRODUCT_DETAILS_BLOCK_DESCRIPTION_XPATH = PRODUCT_DETAILS_BLOCK_XPATH + "//td[@class='product-col']";
    public final static String PRODUCT_DETAILS_BLOCK_QUANTITY_XPATH = PRODUCT_DETAILS_BLOCK_XPATH + "//td[@class='order-qty-input-col']";
    public final static String PRODUCT_DETAILS_BLOCK_EXTENDED_PRICE_XPATH = PRODUCT_DETAILS_BLOCK_XPATH + "//td[@class='data-table-value-col']";
    public final static String PRODUCT_DETAILS_BLOCK_CURRENCY_XPATH = PRODUCT_DETAILS_BLOCK_XPATH + "//td[@class='data-table-currency-col']";
    public final static String PRODUCT_DETAILS_BLOCK_EST_DELIVERY_DATE_XPATH = PRODUCT_DETAILS_BLOCK_XPATH + "//span[@class='est_del_date_1']";
    public final static String PRODUCT_DETAILS_BLOCK_REQ_DELIVERY_DATE_XPATH = PRODUCT_DETAILS_BLOCK_XPATH + "//td[@class='req-date-input-col']/p";

    public final static String ORDER_SUMMARY_PAGE_XPATH = "//div[@id='order-summary']";
    public final static String ADDRESS_DETAILS_HEADER_XPATH = ORDER_SUMMARY_PAGE_XPATH + "//h4[contains (text(),'Address Details')]";
    public final static String SHIPMENT_ADDRESS_TITLE_XPATH = ORDER_SUMMARY_PAGE_XPATH + "//label[contains (text(),'Shipment Address')]";
    public final static String SHIPMENT_ADDRESS_DATA_XPATH = ORDER_SUMMARY_PAGE_XPATH + "//p[@class='shipmentAddressSummary']";

    public final static String ORDER_SUMMARY_FORM_XPATH = "//div[@class='add-new-order-form-wrapper checkout-summary']";
    public final static String SHIPPING_DETAILS_HEADER_XPATH = ORDER_SUMMARY_FORM_XPATH + "//h4[contains (text(),'Shipment Details')]";
    public final static String SHIP_PAYMENT_METHOD_TITLE_XPATH = ORDER_SUMMARY_FORM_XPATH + "//label[contains (text(),'Ship Payment Method')]";
    public final static String SHIP_METHOD_TITLE_XPATH = ORDER_SUMMARY_FORM_XPATH + "//label[contains (text(),'Ship Method')]";
    public final static String SHIPPING_NOTE_TITLE_XPATH = ORDER_SUMMARY_FORM_XPATH + "//label[contains (text(),'Shipping Note')]";
    public final static String REQUESTED_DELIVERY_DATE_TITLE_XPATH = "//label[contains (text(),'Req. Date')]";
    public final static String PARTIAL_SHIPMENT_ACCEPTED_TITLE_XPATH = "//label[contains (text(),'Partial shipment accepted')]";
    public final static String ACCEPT_EARLY_DELIVERY_TITLE_XPATH = "//label[contains (text(),'Accept early delivery')]";

    public final static String PO_NO_TITLE_XPATH = ORDER_SUMMARY_FORM_XPATH + "//label[contains (text(),'PO No.')]";
    public final static String ORDER_SUMMARY_TITLE_XPATH = ".//h4[contains (text(),'Order Summary')]";
    public final static String ORDER_NOTE_TITLE_XPATH = ".//label[contains (text(),'Order Note')]";
    public final static String JOB_NAME_TITLE_XPATH = ORDER_SUMMARY_FORM_XPATH + "//label[contains (text(),'Job Name')]";
    public final static String PAYER_TITLE_XPATH = ORDER_SUMMARY_FORM_XPATH + "//label[contains (text(),'Payer')]";
    public final static String PAYER_DATA_XPATH = "//p[@class='billToSummary']";

    public final static String PAYER_BLOCK_VALUE_XPATH = "//p[@class='billToSummary']";
    public final static String SHIPPING_ADDRESS_BLOCK_VALUE_XPATH = "//p[@class='shipmentAddressSummary']";
}