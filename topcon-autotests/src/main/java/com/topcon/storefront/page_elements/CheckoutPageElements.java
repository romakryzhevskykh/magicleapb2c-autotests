package com.topcon.storefront.page_elements;

public class CheckoutPageElements {

    public static final String PO_FIELD_XPATH = "//input[@id='PurchaseOrderNumber']";
    public static final String PRODUCTS_IDS_XPATH = "//div[@class='item__code']";
    public static final String SUCCESS_ORDER_MESSAGE_XPATH = "/html/body/main/div[3]/div[2]/div/div[1]/div[1]/div/div";
    public static final String TERMS_OF_USE_CHECKBOX_XPATH = "//*[@id=\"Terms1\"]";
    public static final String SHIPPING_METHOD_DROPDOWN_XPATH = "//select[@id='delivery_method']";
    public static final String SHIPPING_CARRIER_DROPDOWN_XPATH = "//select[@id='shippingCarrier']";
    public static final String NEXT_PAYMENT_BUTTON_XPATH = "//button[@id='choosePaymentType_continue_button']";
    public static final String NEXT_SHIPPING_METHOD_BUTTON_XPATH = "//*[@id=\"deliveryMethodSubmit\"]";
    public static final String SHIP_TO_ACCOUNTS_BUTTON_XPATH = "//button[@class='btn btn-default btn-block js-shippingTo-address-book']";
    public static final String FIRST_USE_THIS_ADDRESS_BUTTON_XPATH = "//*[@id=\"shipToAddressBook\"]/div[1]/form/button";
    public static final String PLACE_ORDER_BUTTON_XPATH = "//*[@id=\"placeOrder\"]";
}
