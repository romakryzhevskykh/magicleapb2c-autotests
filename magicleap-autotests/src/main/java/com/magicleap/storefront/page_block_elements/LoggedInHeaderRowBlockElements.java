package com.magicleap.storefront.page_block_elements;

public class LoggedInHeaderRowBlockElements {

    private static final String RIGHT_TOP_ACCOUNT_MENU = "//div[@class='account-section']";
    public static final String MY_ACCOUNT_DROP_DOWN_XPATH = RIGHT_TOP_ACCOUNT_MENU + "//li[@class='account-item has-account-menu']";
    public static final String SIGN_OUT_BUTTON_XPATH = RIGHT_TOP_ACCOUNT_MENU + "//a[contains(., 'Logout')]";
    private static final String MY_ACCOUNT_DROP_DOWN_ITEMS_XPATH = "//div[@class = 'account-list']";
    public static final String MY_ACCOUNT_ADDRESS_BOOK_XPATH = MY_ACCOUNT_DROP_DOWN_ITEMS_XPATH + "//a[@title = 'Address Book']";
    public static final String MY_ACCOUNT_SETTINGS_XPATH = MY_ACCOUNT_DROP_DOWN_ITEMS_XPATH + "//a[contains(@href,'account/settings')]";

}
