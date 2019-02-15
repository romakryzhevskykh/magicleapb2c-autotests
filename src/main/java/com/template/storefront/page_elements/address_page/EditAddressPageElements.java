package com.template.storefront.page_elements.address_page;

public class EditAddressPageElements {
    public static String PAGE_HEADER_TITLE_XPATH = "//div[@class='account-section']//span[@class='label']";
    public static String ADDRESS1_FIELD_ID = "address.line1";
    public static String ADDRESS2_FIELD_ID = "address.line2";
    public static String COUNTRY_DROPDOWN_ID = "address.country";
    public static String TITLE_DROPDOWN_ID = "address.title";
    public static String CITY_ID = "address.townCity";
    public static String POSTCODE_FIELD_ID = "address.postcode";
    public static String STATE_DROPDOWN_ID = "address.region";
    public static String FLASH_MESSAGE_XPATH = "//div[@class='global-alerts']//div[contains(@class, 'alert')]";
    public static String INFO_FLASH_MESSAGE_XPATH = FLASH_MESSAGE_XPATH + "/p";
    public static String TELEPHONE_FIELD_ID = "address.phone";
    public static String CANCEL_BUTTON_XPATH = "//div[@id='addressform_button_panel']//a";
    public static String SAVE_ADDRESS_BUTTON_XPATH = "//button[@type = 'submit'][contains(., 'Save')]";
    public static String FIRST_NAME_FIELD_ID = "address.firstName";
    public static String LAST_NAME_FIELD_ID = "address.surname";
}
