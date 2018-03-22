package com.sarnova.storefront.page_block_elements;

public class LoggedInHeaderRowBlockElements {

    private static final String RIGHT_TOP_ACCOUNT_MENU = "//div[@class='nav__right']";
    public static final String MY_ACCOUNT_DROP_DOWM_XPATH = RIGHT_TOP_ACCOUNT_MENU + "//a[. = 'My Account']";
    public static final String SIGN_OUT_BUTTON_XPATH = RIGHT_TOP_ACCOUNT_MENU + "//a[contains(., 'Sign Out')]";

    private static final String RIGHT_BOTTOM_NAVIGATION_BAR_XPATH = "//div[@class='yCmsContentSlot order-navigation-bar pull-right']";
    public static final String SUPPLY_LISTS_DROP_DOWN_XPATH = RIGHT_BOTTOM_NAVIGATION_BAR_XPATH + "/div[@class='yCmsComponent  pull-right order-navigation-bar-item']";
    public static final String SUPPLY_LIST_NAMES_FROM_SUPPLY_LISTS_DROP_DOWN_XPATH = SUPPLY_LISTS_DROP_DOWN_XPATH + "//ul/li/a/span[@class='name']";
}
