package com.sarnova.storefront.page_block_elements;

public class CheckoutShippingAddressStepBlockElements {
    public static final String NEXT_BUTTON_ID = "addressSubmit";
    public static final String CREATE_NEW_SHIPPING_ADDRESS_CHECKBOX_XPATH = "//label[@for='saveAddressInMyAddressBook']/span[@class='control__indicator']";

    public static final String SELECT_COUNTRY_DROP_DOWN_ID = "address.country";
    public static final String ITEMS_IN_COUNTRY_DROP_DOWN_XPATH = "//select[@id='address.country']/option[not(@disabled)]";
    public static final String ITEM_IN_COUNTRY_DROP_DOWN_BY_VALUE_XPATH = "//select[@id='address.country']/option[@value='%s']";

    public static final String SELECT_TITLE_DROP_DOWN_ID = "address.title";
    public static final String ITEMS_IN_TITLE_DROP_DOWN_XPATH = "//select[@id='address.title']/option[not(@disabled)]";
    public static final String ITEM_IN_TITLE_DROP_DOWN_BY_VALUE_XPATH = "//select[@id='address.title']/option[@value='%s']";

    public static final String FIRST_NAME_FIELD_ID = "address.firstName";
    public static final String LAST_NAME_FIELD_ID = "address.surname";
    public static final String ADDRESS_LINE_1_FIELD_ID = "address.line1";
    public static final String ADDRESS_LINE_2_FIELD_ID = "address.line2";
    public static final String TOWN_CITY_FIELD_ID = "address.townCity";

    public static final String STATE_DROP_DOWN_ID = "address.region";
    public static final String ITEMS_IN_STATE_DROP_DOWN_XPATH = "//select[@id='address.region']/option[not(@disabled)]";
    public static final String ITEM_IN_STATE_DROP_DOWN_BY_VALUE_XPATH = "//select[@id='address.region']/option[@value='%s']";

    public static final String POSTCODE_FIELD_ID = "address.postcode";
    public static final String PHONE_FIELD_ID = "address.phone";
}
