package com.template.storefront.page_elements.checkout_page_elements;

public class CheckoutShippingAddressPageElements {


    public static final String COUNTRY_DROP_DOWN_ID = "address.country";
    public static final String TITLE_DROPDOWN_ID = "address.title";
    public static final String STATE_DROP_DOWN_ID = "address.region";


    public static final String SHIPPING_ADDRESS_HEADER_XPATH = "//div[contains(@class,'checkout-steps')]/a[contains(@data-url, 'delivery-address')]/div[@class='title']";

    public static final String SHIPPING_ADDRESS_BOOK_BUTTON_XPATH = "//button[contains(@class,'address-book')]";
    public static final String PRACTICE_NAME_FIELD_ID = "address.practiceName";
    public static final String PRACTICE_NAME_LABEL_XPATH = "//label[@for='" + PRACTICE_NAME_FIELD_ID + "']";
    public static final String ADDRESS_TITLE_DROP_DOWN_ID = "address.title-button";
    public static final String ADDRESS_TITLE_LABEL_XPATH = "//label[@for='" + ADDRESS_TITLE_DROP_DOWN_ID + "']";
    public static final String TITLE_FROM_DROP_DOWN_BY_NAME_XPATH = "//ul[@id='address.title-menu']/li[contains(text(),'%s')]";
    public static final String FIRST_NAME_FIELD_ID = "address.firstName";
    public static final String FIRST_NAME_LABEL_XPATH = "//label[@for='" + FIRST_NAME_FIELD_ID + "']";
    public static final String LAST_NAME_FIELD_ID = "address.surname";
    public static final String LAST_NAME_LABEL_XPATH = "//label[@for='" + LAST_NAME_FIELD_ID + "']";
    public static final String ADDRESS1_FIELD_ID = "address.line1";
    public static final String ADDRESS1_LABEL_XPATH = "//label[@for='" + ADDRESS1_FIELD_ID + "']";
    public static final String ADDRESS2_FIELD_ID = "address.line2";
    public static final String ADDRESS2_LABEL_XPATH = "//label[@for='" + ADDRESS2_FIELD_ID + "']";
    public static final String CITY_ID = "address.townCity";
    public static final String CITY_LABEL_XPATH = "//label[@for='" + CITY_ID + "']";
//    public static final String STATE_DROP_DOWN_ID = "address.region-button";
    public static final String STATE_LABEL_XPATH = "//label[@for='" + STATE_DROP_DOWN_ID + "']";
    public static final String STATE_FROM_DROP_DOWN_BY_FULL_NAME_XPATH = "//ul[@id='address.region-menu']/li[contains(text(),'%s')]";
    public static final String POSTCODE_FIELD_ID = "address.postcode";
    public static final String POSTCODE_LABEL_XPATH = "//label[@for='" + POSTCODE_FIELD_ID + "']";
    public static final String TELEPHONE_FIELD_ID = "address.phone";
    public static final String TELEPHONE_LABEL_XPATH = "//label[@for='" + TELEPHONE_FIELD_ID + "']";

    public static final String SAVE_SHIPPING_ADDRESS_CHECKBOX_ID = "saveAddressInMyAddressBook";
    public static final String SAVE_SHIPPING_ADDRESS_LABEL_XPATH = "//label[@for='" + SAVE_SHIPPING_ADDRESS_CHECKBOX_ID + "']";
    public static final String NEXT_BUTTON_ID = "addressSubmit";

    public static final String ADDRESS_VERIFICATION_POPUP_ID = "cboxLoadedContent";
    public static final String USE_THIS_ADDRESS_BUTTON_XPATH = ".//*[@id='use_suggested_address_button']";
}
