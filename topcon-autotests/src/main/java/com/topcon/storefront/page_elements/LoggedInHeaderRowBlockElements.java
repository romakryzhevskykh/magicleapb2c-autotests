package com.topcon.storefront.page_elements;

public class LoggedInHeaderRowBlockElements {

    private static final String RIGHT_TOP_ACCOUNT_MENU = "//div[@class='nav__right']";
    public static final String MY_ACCOUNT_DROP_DOWM_XPATH = RIGHT_TOP_ACCOUNT_MENU + "//div[. = 'My Account']";
    public static final String SIGN_OUT_BUTTON_XPATH = RIGHT_TOP_ACCOUNT_MENU + "//a[contains(., 'Sign Out')]";
    private static final String MY_ACCOUNT_DROP_DOWN_ITEMS_XPATH = "//div[@id = 'accNavComponentDesktopOne']";
    public static final String MY_ACCOUNT_ADDRESS_BOOK_XPATH = MY_ACCOUNT_DROP_DOWN_ITEMS_XPATH + "//a[@title = 'Address Book']";

}
