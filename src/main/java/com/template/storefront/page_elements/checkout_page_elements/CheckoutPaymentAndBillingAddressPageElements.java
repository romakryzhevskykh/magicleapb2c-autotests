package com.template.storefront.page_elements.checkout_page_elements;

public class CheckoutPaymentAndBillingAddressPageElements {

    public static final String CARD_NUMBER_FIELD_ID = "card_accountNumber";
    public static final String COUNTRY_DROP_DOWN_ID = "address.country";
    public static final String TITLE_DROPDOWN_ID = "address.title";
    public static final String STATE_DROP_DOWN_ID = "address.region";
    public static final String EXPIRY_MONTH_DROPDOWN_ID = "ExpiryMonth";
    public static final String EXPIRY_YEAR_DROPDOWN_ID = "ExpiryYear";
    public static final String CVV_FIELD_ID = "card_cvNumber";
    public static final String SAVE_CARD_CHECKBOX_ID = "savePaymentMethod";
    public static final String CARD_TYPE_DROPDOWN_ID = "card_cardType";

    public static String USE_MY_SHIPPING_ADDRESS_CHECKBOX_ID = "useDeliveryAddress";
    public static String PRACTICE_NAME_FIELD_ID = "address.practiceName";
    public static String ADDRESS_TITLE_DROP_DOWN_ID = "address.title";
    //    public static String TITLE_FROM_DROP_DOWN_BY_NAME_XPATH = "//ul[@id='address.title-menu']/li[contains(text(),'%s')]";
    public static String FIRST_NAME_FIELD_ID = "address.firstName";
    public static String LAST_NAME_FIELD_ID = "address.surname";
    public static String ADDRESS1_FIELD_ID = "address.line1";
    public static String ADDRESS2_FIELD_ID = "address.line2";
    public static String CITY_ID = "address.townCity";
    //    public static String STATE_FROM_DROP_DOWN_BY_FULL_NAME_XPATH = "//ul[@id='address.region-menu']/li[contains(text(),'%s')]";
    public static String POSTCODE_FIELD_ID = "address.postcode";

    public static String NEXT_BUTTON_XPATH = "//button[contains(@class,'submit_silentOrderPostForm')]";

    public static String ADDRESS_VERIFICATION_POPUP_ID = "cboxLoadedContent";
    public static String USE_THIS_ADDRESS_BUTTON_XPATH = ".//*[@id='use_suggested_address_button']";
}
