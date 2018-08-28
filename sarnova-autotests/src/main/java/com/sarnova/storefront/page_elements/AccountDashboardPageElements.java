package com.sarnova.storefront.page_elements;

public class AccountDashboardPageElements {
    public static final String LEFT_BAR_MENU_XPATH = "//div[contains(@class,'side-content')]";
    public static final String MENU_ITEMS_XPATH = LEFT_BAR_MENU_XPATH + "//li[@class='menu-item']";

    public static final String ACCOUNT_DASHBOARD_ITEMS_XPATH = "//div[contains(@class,'dashboard-menu-body') and not(@id)]/ul[@class='menu-body-list-container']";
    public static final String EXPAND_ACCOUNT_DASHBOARD_ITMES_XPATH = "//div[@class='dashboard-menu-header'][div/span/a[contains(text(), 'Account Dashboard')]]//i";
    public static final String ORDER_HISTORY_ITEM_XPATH = ACCOUNT_DASHBOARD_ITEMS_XPATH + "/li//a[@title='Order History']";
    public static final String PREVIOUSLY_ORDERED_ITEMS_ITEM_XPATH = ACCOUNT_DASHBOARD_ITEMS_XPATH + "/li//a[@title='Previously Ordered Items']";
    public static final String PURCHASE_REQUESTS_ITEM_XPATH = ACCOUNT_DASHBOARD_ITEMS_XPATH + "/li//a[@title='Purchase Requests']";
    public static final String QUOTES_ITEM_XPATH = ACCOUNT_DASHBOARD_ITEMS_XPATH + "/li//a[@title='Quotes']";
    public static final String REPLENISHMENT_ORDERS_ITEM_XPATH = ACCOUNT_DASHBOARD_ITEMS_XPATH + "/li//a[@title='Replenishment Orders']";
    public static final String SAVED_CARTS_ITEM_XPATH = ACCOUNT_DASHBOARD_ITEMS_XPATH + "/li//a[@title='Saved Carts']";
    public static final String SUPPLY_LISTS_ITEM_XPATH = ACCOUNT_DASHBOARD_ITEMS_XPATH + "/li//a[@title='Supply Lists']";

    public static final String REPORTS_ITEMS_XPATH = "//div[@id = 'dashboard-menu-body-Reports']/ul[@class='menu-body-list-container']";
    public static final String EXPAND_REPORTS_ITEMS_XPATH = "//div[@class='dashboard-menu-header'][div/span[contains(text(), 'Reports')]]//i";
    public static final String BACKORDERED_ITEMS_ITEM_XPATH = REPORTS_ITEMS_XPATH + "/li//a[@title='Backordered Items']";
    public static final String DISCONTINUED_PRODUCTS_ITEM_XPATH = REPORTS_ITEMS_XPATH + "/li//a[@title='Discontinued Products']";
    public static final String DSCSA_TRANSACTIONS_ITEM_XPATH = REPORTS_ITEMS_XPATH + "/li//a[@title='DSCSA Transactions']";
    public static final String PHARMACEUTICAL_BACKORDER_REPORT_ITEM_XPATH = REPORTS_ITEMS_XPATH + "/li//a[@title='Pharmaceutical Backorder Report']";
    public static final String PURCHASES_PER_MONTH_ITEM_XPATH = REPORTS_ITEMS_XPATH + "/li//a[@title='Purchases Per Month']";
    public static final String PURCHASE_SUMMARY_ITEM_XPATH = REPORTS_ITEMS_XPATH + "/li//a[@title='Purchase Summary']";

    public static final String ADMINISTRATION_ITEMS_XPATH = "//div[@id = 'dashboard-menu-body-Administration']/ul[@class='menu-body-list-container']";
    public static final String EXPAND_ADMINISTRATION_ITEMS_XPATH = "//div[@class='dashboard-menu-header'][div/span[contains(text(), 'Administration')]]//i";
    public static final String CUSTOM_CATEGORY_ITEM_XPATH = ADMINISTRATION_ITEMS_XPATH + "/li//a[@title='Custom Category']";
    public static final String USERS_ITEM_XPATH = ADMINISTRATION_ITEMS_XPATH + "/li//a[@title='Users']";
    public static final String USER_GROUPS_ITEM_XPATH = ADMINISTRATION_ITEMS_XPATH + "/li//a[@title='User Groups']";
    public static final String QUOTAS_AND_PAR_LEVELS_ITEM_XPATH = ADMINISTRATION_ITEMS_XPATH + "/li//a[@title='Quotas and Par Levels']";

    public static final String PREFERENCES_ITEMS_XPATH = "//div[@id = 'dashboard-menu-body-Preferences']/ul[@class='menu-body-list-container']";
    public static final String EXPAND_PREFERENCES_ITEMS_XPATH = "//div[@class='dashboard-menu-header'][div/span[contains(text(), 'Preferences')]]//i";
    public static final String ACCOUNT_SETTINGS_ITEM_XPATH = PREFERENCES_ITEMS_XPATH + "/li//a[@title='Account Settings']";
    public static final String SAVED_CREDIT_CARDS_ITEM_XPATH = PREFERENCES_ITEMS_XPATH + "/li//a[@title='Saved Credit Cards']";
    public static final String HELP_ITEM_XPATH = PREFERENCES_ITEMS_XPATH + "/li//a[@title='Help']";

}
