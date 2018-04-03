package com.geempower.storefront.page_elements;

public class OrderEntry2PageElements {
    public final static String SHIPPING_BILLING_TITLE_XPATH = ".//li[@class='shipping-billing-info active']";

    public final static String ORDER_DETAILS_HEADER_XPATH = ".//h4[contains (text(),'Order Details')]";
    public final static String PO_NO_FIELD_ID = "poNumber";
    public final static String JOB_NAME_FIELD_ID = "jobName";
    public final static String PAYER_TITLE_XPATH = "//*[@id='shipping-billing-info']//label[contains (text(),'Payer')]";
  
    public final static String SHIPPING_ADDRESS_FIELD_ID = "select2-shipmentAddress-container";
    public final static String SHIPPING_BILLING_TOP_NEXT_BUTTON_XPATH = ".//*[@id='shipping-billing-info']/div[1]/div[2]/div/ul/li/button";
    public final static String SHIPPING_BILLING_BOTTOM_NEXT_BUTTON_XPATH = "//*[@class='order-titles order-bottom-steps clearfix']//*[@class='btn primary-btn vaidateCheckoutBtn']";
    public final static String SHIPPING_ADDRESS_LIST_OPEN_XPATH = "//*[@id='select2-shipmentAddress-container']/../span[@class='select2-selection__arrow']";
    public final static String SHIPPING_ADDRESS_DROPDOWN_XPATH = "//select[@id='shipmentAddress']";
    public final static String SHIP_TO_FIELD_VALUE_XPATH = "//*[@id='shippmentAddresses-1']//..//span[@id='select2-shippmentAddresses-1-container']";
    
    public final static String PRODUCT_DETAILS_BLOCK_XPATH = ".//table[@id='DataTables_Table_0']";
    public final static String PRODUCT_DETAILS_BLOCK_CATALOG_NO_XPATH = PRODUCT_DETAILS_BLOCK_XPATH + "//a[@data-target='#product-detail-modal-1']";
    public final static String PRODUCT_DETAILS_BLOCK_DESCRIPTION_XPATH = PRODUCT_DETAILS_BLOCK_XPATH + "//td[@class='product-col']";
    public final static String PRODUCT_DETAILS_BLOCK_QUANTITY_XPATH = PRODUCT_DETAILS_BLOCK_XPATH + "//td[@class='order-qty-input-col']";
    public final static String PRODUCT_DETAILS_BLOCK_EXTENDED_PRICE_XPATH = PRODUCT_DETAILS_BLOCK_XPATH + "//td[@class='data-table-value-col']";
    public final static String PRODUCT_DETAILS_BLOCK_CURRENCY_XPATH = PRODUCT_DETAILS_BLOCK_XPATH + "//td[@class='data-table-currency-col']";
    public final static String PRODUCT_DETAILS_BLOCK_EST_DELIVERY_DATE_XPATH = PRODUCT_DETAILS_BLOCK_XPATH + "//span[@class='est_del_date_1']";
    public final static String PRODUCT_DETAILS_BLOCK_REQ_DELIVERY_DATE_XPATH = PRODUCT_DETAILS_BLOCK_XPATH + "//div[@class='input-group date datetimepicker future-date mycart-datepicker']/input";
    

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
