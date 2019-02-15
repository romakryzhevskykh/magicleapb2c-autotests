package com.template.storefront.page_elements.address_page;

public class AddressBookPageElements {

    public static String ADDRESS_BLOCK = "//div[@class = 'account-cards card-select']/div[@class = 'row']";
    public static String ADDRESS_ITEMS_XPATH = ADDRESS_BLOCK + "/div[contains(@class,'card')]";
    public static String FLASH_INFO_MESSAGE_XPATH = "//div[@class = 'global-alerts']//div[contains(@class,'alert-info')]/p[@class='alert-text']";
    public static String TITLE_XPATH = "//div[contains(@class,'account-section-content')]/div[contains(@class,'account-section-header')]";

    public static String EMPTY_LIST_MESSAGE_XPATH = "//div[@class = 'account-section-content content-empty']";
    public static String ADD_ADDRESS_BUTTON_XPATH = TITLE_XPATH + "//a[@href='add-address']";

    public static String ADDRESS_ITEM_BY_ID_XPATH = ADDRESS_ITEMS_XPATH + "[div[contains(@class,'account-cards-actions')]/a[contains(@class,'removeAddressFromBookButton')][@data-address-id='%s']]";

    public static String PRACTICE_NAME_BY_ID_XPATH = ADDRESS_ITEM_BY_ID_XPATH + "/ul/li[contains(text(), 'Practice name:')]";
    public static String PHONE_NUMBER_BY_ID_XPATH = ADDRESS_ITEM_BY_ID_XPATH + "/ul/div[contains(@class,'phone-placeholder')]";

    public static String ADDRESS_ITEMS_ACTIONS_BLOCK_XPATH = ADDRESS_ITEMS_XPATH + "/div[contains(@class,'account-cards-actions')]";
    public static String DELETE_ADDRESS_BUTTON_BY_ID_XPATH = ADDRESS_ITEMS_ACTIONS_BLOCK_XPATH + "/a[contains(@class,'removeAddressFromBookButton')][@data-address-id='%s']";
    public static String SET_AS_DEFAULT_BUTTON_BY_ID_XPATH = ADDRESS_ITEMS_XPATH + "//a[@href='set-default-address/%s']";
    public static String EDIT_ADDRESS_BUTTON_BY_ID_XPATH = ADDRESS_ITEMS_ACTIONS_BLOCK_XPATH + "/a[@href='edit-address/%s']";
}
