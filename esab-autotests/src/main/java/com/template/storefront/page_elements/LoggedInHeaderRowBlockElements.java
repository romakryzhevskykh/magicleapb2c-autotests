package com.template.storefront.page_elements;

public class LoggedInHeaderRowBlockElements {

    private static final String RIGHT_TOP_ACCOUNT_MENU = "//div[@class='nav__right']";
    public static final String MY_ACCOUNT_DROP_DOWM_XPATH = RIGHT_TOP_ACCOUNT_MENU + "//div[. = 'My Account']";
    public static final String SIGN_OUT_BUTTON_XPATH = RIGHT_TOP_ACCOUNT_MENU + "//a[contains(., 'Sign Out')]";
    private static final String MY_ACCOUNT_DROP_DOWN_ITEMS_XPATH = "//div[@id = 'accNavComponentDesktopOne']";
    public static final String MY_ACCOUNT_ADDRESS_BOOK_XPATH = MY_ACCOUNT_DROP_DOWN_ITEMS_XPATH + "//a[@title = 'Address Book']";
    public static final String WELCOME_TO_DASHBOARD_NAME = "//div[@class='top-info']//h2[normalize-space(text())]";
    public static final String CUSTOMER_NAME = "Customer";
    public static final String CART_ICON_XPATH="//a[@href='/esab/en/cart']";
    public static final String XPATH_SAVED_CARTS_PAGE="//li[@class='yCmsComponent']//a[@href='/my-account/saved-carts']";

}
