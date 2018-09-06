package com.sarnova.storefront.page_block_elements;

public class LoggedInHeaderRowBlockElements {

    private static final String MY_ACCOUNT_CONTAINER_XPATH = "//div[@class='my-account-container']";
    private static final String RIGHT_TOP_ACCOUNT_MENU = MY_ACCOUNT_CONTAINER_XPATH + "//div[@class='nav__right']";
    public static final String MY_ACCOUNT_DROP_DOWN_XPATH = RIGHT_TOP_ACCOUNT_MENU + "//a[. = 'My Account']";
    public static final String MY_ACCOUNT_DROP_DOWN_CONTENT_XPATH = MY_ACCOUNT_CONTAINER_XPATH + "//ul[@class='nav__links']";
    public static final String MY_ACCOUNT_MENU_LINK_ITEMS_XPATH = MY_ACCOUNT_DROP_DOWN_CONTENT_XPATH + "/li[@class='auto col-md-4']";
    public static final String MY_ACCOUNT_MENU_LINK_ITEM_NAMES_XPATH = MY_ACCOUNT_MENU_LINK_ITEMS_XPATH + "/a";

    public static final String ACCOUNT_DASHBOARD_ITEM_XPATH = MY_ACCOUNT_MENU_LINK_ITEMS_XPATH + "/a[@title = 'Account Dashboard']";
    public static final String ORDER_HISTORY_ITEM_XPATH = MY_ACCOUNT_MENU_LINK_ITEMS_XPATH + "/a[@title = 'Order History']";
    public static final String SUPPLY_LISTS_ITEM_XPATH = MY_ACCOUNT_MENU_LINK_ITEMS_XPATH + "/a[@title = 'Supply Lists']";
    public static final String PURCHASE_REQUESTS_ITEM_XPATH = MY_ACCOUNT_MENU_LINK_ITEMS_XPATH + "/a[@title = 'Purchase Requests']";
    public static final String SAVED_CARTS_ITEM_XPATH = MY_ACCOUNT_MENU_LINK_ITEMS_XPATH + "/a[@title = 'Saved Carts']";
    public static final String PREVIOUSLY_ORDERED_ITEMS_ITEM_XPATH = MY_ACCOUNT_MENU_LINK_ITEMS_XPATH + "/a[@title = 'Previously Ordered Items']";
    public static final String SAVED_CREDIT_CARDS_ITEM_XPATH = MY_ACCOUNT_MENU_LINK_ITEMS_XPATH + "/a[@title = 'Saved Credit Cards']";
    public static final String QUOTES_ITEM_XPATH = MY_ACCOUNT_MENU_LINK_ITEMS_XPATH + "/a[@title = 'Quotes']";
    public static final String REPORTS_ITEM_XPATH = MY_ACCOUNT_MENU_LINK_ITEMS_XPATH + "/a[@title = 'Reports']";
    public static final String ACCOUNT_INFORMATION_ITEM_XPATH = MY_ACCOUNT_MENU_LINK_ITEMS_XPATH + "/a[@title = 'Account Information']";
    public static final String CUSTOM_CATEGORY_ITEM_XPATH = MY_ACCOUNT_MENU_LINK_ITEMS_XPATH + "/a[@title = 'Custom Category']";
    public static final String QUOTAS_AND_PAR_LEVELS_ITEM_XPATH = MY_ACCOUNT_MENU_LINK_ITEMS_XPATH + "/a[@title = 'Quotas and Par Levels']";
    public static final String BUSINESS_INFO_ITEM_XPATH = MY_ACCOUNT_MENU_LINK_ITEMS_XPATH + "/a[@title = 'Business Info']";
    public static final String HELP_NEW_TO_BOUNDTREE_ITEM_XPATH = MY_ACCOUNT_MENU_LINK_ITEMS_XPATH + "/a[@title = 'Help']";
    public static final String USERS_ITEM_XPATH = MY_ACCOUNT_MENU_LINK_ITEMS_XPATH + "/a[@title = 'Users']";
    public static final String USER_GROUPS_ITEM_XPATH = MY_ACCOUNT_MENU_LINK_ITEMS_XPATH + "/a[@title = 'User Groups']";
    public static final String SIGN_OUT_ITEM_XPATH = MY_ACCOUNT_MENU_LINK_ITEMS_XPATH + "/a[contains(@title, 'Sign Out')]";

    private static final String RIGHT_BOTTOM_NAVIGATION_BAR_XPATH = "//div[@class='yCmsContentSlot order-navigation-bar pull-right']";
    public static final String SUPPLY_LISTS_DROP_DOWN_XPATH = RIGHT_BOTTOM_NAVIGATION_BAR_XPATH + "/div[@class='yCmsComponent  pull-right order-navigation-bar-item'][div[contains(@class, 'supply-lists')]]";
    public static final String SUPPLY_LIST_NAMES_FROM_SUPPLY_LISTS_DROP_DOWN_XPATH = SUPPLY_LISTS_DROP_DOWN_XPATH + "//ul/li/a/span[@class='name']";
    public static final String SUPPLY_LIST_ALL_SUPPLY_LISTS_LINK_FROM_SUPPLY_LISTS_DROP_DOWN_XPATH = SUPPLY_LISTS_DROP_DOWN_XPATH + "//ul/li/a[@href='/my-account/supply-lists/']";
}
