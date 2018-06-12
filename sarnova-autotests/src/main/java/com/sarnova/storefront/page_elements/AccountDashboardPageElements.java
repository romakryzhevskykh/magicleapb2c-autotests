package com.sarnova.storefront.page_elements;

public class AccountDashboardPageElements {
    public static final String LEFT_BAR_MENU_XPATH = "//div[@class='side-content col-md-3']";
    public static final String MENU_ITEMS_XPATH = LEFT_BAR_MENU_XPATH + "//li[@class='menu-item']";

    private static final String ACCOUNT_DASHBOARD_ITEMS_XPATH = "//div[@class='dashboard-menu-body']/ul[@class='menu-body-list-container']";
    public static final String ORDER_HISTORY_ITEM_XPATH = ACCOUNT_DASHBOARD_ITEMS_XPATH + "/li//a[@title='Order History']";
    public static final String PREVIOUSLY_ORDERED_ITEMS_ITEM_XPATH = ACCOUNT_DASHBOARD_ITEMS_XPATH + "/li//a[@title='Previously Ordered Items']";
    public static final String PURCHASE_REQUESTS_ITEM_XPATH = ACCOUNT_DASHBOARD_ITEMS_XPATH + "/li//a[@title='Purchase Requests']";
    public static final String QUOTES_ITEM_XPATH = ACCOUNT_DASHBOARD_ITEMS_XPATH + "/li//a[@title='Quotes']";
    public static final String REPORTS_ITEM_XPATH = ACCOUNT_DASHBOARD_ITEMS_XPATH + "/li//a[@title='Reports']";
    public static final String SAVED_CARTS_ITEM_XPATH = ACCOUNT_DASHBOARD_ITEMS_XPATH + "/li//a[@title='Saved Carts']";
    public static final String SUPPLY_LISTS_ITEM_XPATH = ACCOUNT_DASHBOARD_ITEMS_XPATH + "/li//a[@title='Supply Lists']";

    private static final String ADMINISTRATION_ITEMS_XPATH = "//div[@id = 'dashboard-menu-body-Administration']/ul[@class='menu-body-list-container']";
    public static final String BUSINESS_INFO_ITEM_XPATH = ADMINISTRATION_ITEMS_XPATH + "/li//a[@title='Business Info']";
    public static final String CUSTOM_CATEGORY_ITEM_XPATH = ADMINISTRATION_ITEMS_XPATH + "/li//a[@title='Custom Category']";
    public static final String USERS_ITEM_XPATH = ADMINISTRATION_ITEMS_XPATH + "/li//a[@title='Users']";
    public static final String USER_GROUPS_ITEM_XPATH = ADMINISTRATION_ITEMS_XPATH + "/li//a[@title='User Groups']";

    private static final String PREFERENCES_ITEMS_XPATH = "//div[@id = 'dashboard-menu-body-Preferences']/ul[@class='menu-body-list-container']";
    public static final String ACCOUNT_INFORMATION_ITEM_XPATH = PREFERENCES_ITEMS_XPATH + "/li//a[@title='Account Information']";
    public static final String HELP_ITEM_XPATH = PREFERENCES_ITEMS_XPATH + "/li//a[@title='Help/New to Boundtree?']";

}
