package com.topcon.storefront.page_elements;

public class AddressBookPageElements {

    public static String SECTION_HEADER_XPATH = "//div[contains(@class, 'account-section-header ')]";
    public static String ADDRESSES_INFO_ITEMS_TEXT_XPATH = "//div[@class = 'account-cards card-select']/div[@class = 'row']/div/ul";

    //Add address page
    public static String ADD_ADDRESS_BUTTON_XPATH = "//a[@href = 'add-address']";
    public static String COUNTRY_DROP_DOWN_ID = "address.country";
    public static String COUNTRIES_IN_DROP_DOWN_XPATH = "//select[@id = 'address.country']/option[@value][not(contains(., 'Country'))]";
    public static String COUNTRY_IN_DROP_DOWN_BY_NAME_XPATH = "//select[@id = 'address.country']/option[translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '%s']";
    public static String TITLE_DROP_DOWN_ID = "address.title";
    public static String TITLES_IN_DROP_DOWN_XPATH = "//select[@id = 'address.title']/option[@value][not(contains(., 'Please select...'))]";
    public static String TITLE_IN_DROP_DOWN_BY_NAME_XPATH = "//select[@id = 'address.title']/option[translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '%s']";
    public static String FIRST_NAME_FIELD_ID = "address.firstName";
    public static String LAST_NAME_FIELD_ID = "address.surname";
    public static String ADDRESS_LINE_1_FIELD_ID = "address.line1";
    public static String TOWN_FIELD_ID = "address.townCity";
    public static String POST_CODE_FIELD_ID = "address.postcode";
    public static String SAVE_ADDRESS_BUTTON_XPATH = "//button[@type = 'submit'][contains(., 'Save')]";
    public static String ALERT_ERROR_MESSAGE_XPATH = "//div[@class = 'global-alerts']/div[contains(@class, 'danger')]";
}
