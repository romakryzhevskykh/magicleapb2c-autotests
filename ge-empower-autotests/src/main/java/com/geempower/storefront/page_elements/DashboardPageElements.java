package com.geempower.storefront.page_elements;

public class DashboardPageElements {
    public final static String ORDER_STATUS_WIDGET_XPATH = ".//div[contains(@class,'trainingLayerOrderDashboardTooltip')]";
    public final static String FEATURED_UPDATES_WIDGET_XPATH = ".//div[contains(@class,'trainingLayerWhatsNewTooltip')]";
    public final static String FEATURED_UPDATES_WIDGET_TITLE_XPATH = FEATURED_UPDATES_WIDGET_XPATH + "//h3";
    public final static String FEATURED_UPDATES_WIDGET_VIEW_ALL_LINK_XPATH = FEATURED_UPDATES_WIDGET_XPATH + "//div[contains(@class,'view-all-text')]/a";
    public final static String COUNT_OF_AVAILABLE_FEATURES_XPATH = FEATURED_UPDATES_WIDGET_XPATH + "//ol/li";
    public final static String ORDER_SEARCH_WIDGET_XPATH = ".//div[contains(@class,'trainingLayerSearchOrderTooltip')]";
    public final static String RECENT_ORDERS_WIDGET_XPATH = ".//div[contains(@class,'trainingLayerOrderDetailsTooltip')]";
    public final static String PRICE_AND_AVAILABILITY_WIDGET_XPATH = ".//div[contains(@class,'trainingCatalogSearchListsTooltip')]";
    public final static String RECENT_LIST_WIDGET_XPATH = ".//div[contains(@class,'trainingLayerRecentListsTooltip')]";
    public final static String SKIP_BUTTON_XPATH = "//a[contains(@class,'introjs-button')]";
    public final static String ACCOUNT_INFO_XPATH = ".//span[@class='account-info-text']/span";
    public final static String CLOSE_COOKIES_BUTTON_ID = "_evh-ric-c";
    public final static String WE_ARE_NOW_ABB_POP_UP_XPATH = "//img[contains(@src, 'WEAREABB')]";
    public final static String WE_ARE_NOW_ABB_OK_BUTTON_XPATH = WE_ARE_NOW_ABB_POP_UP_XPATH + "//..//..//../div/button";
    public final static String ORDER_SEARCH_INPUT_XPATH = "//input[@name='orderNum']";
    public final static String SEARCH_ORDER_BY_PARAMS_BUTTON_XPATH = "//input[@class='btn primary-btn pull-right']";
    public final static String T_AND_B_ACCESS_WIDGET_XPATH = "//div[@class='panel accessTandB-panel']";
    public final static String T_AND_B_ACCESS_WIDGET_TITLE_XPATH = T_AND_B_ACCESS_WIDGET_XPATH + "//p";
    public final static String T_AND_B_ACCESS_BUTTON_XPATH = T_AND_B_ACCESS_WIDGET_XPATH + "//a[@class='pull-right button primary-btn btn']";
    public final static String SELECT_SHIP_ADDRESS_MODAL_XPATH = "//*[@id='select-ship-address-modal']//*[@class='modal-dialog']";
    public final static String SELECT_SHIP_ADDRESS_FIELD_ID = "select2-shippingAddress-container";
    public final static String SUBMIT_SHIP_ADDRESS_BUTTON_XPATH = "//button[@class='btn primary-btn js-submit-modal']";
    public final static String ACCOUNT_INFO_DROPDOWN_XPATH = "//span[@class='fa fa-caret-down collapse-icon']";
    public final static String COUNT_OF_FAVORITE_ACCOUNTS_XPATH = "//ul/li[@class='text-line-heading']";
    public final static String LIST_OF_FAVORITE_ACCOUNTS_XPATH = "//ul[@class='dropdown-item-link-list']/li/a";
    public final static String ACCOUNT_INFO_DROPDOWN_MESSAGE_IN_RED_BLOCK_IN_XPATH = "//div[contains (@class ,'alert-block-account')]";
    public final static String RED_TRIANGLE_ICON_NEAR_ACCOUNT_NO_XPATH = "//i[@class='fas fa-exclamation-triangle']";
    public final static String EXPIRED_TAX_CERT_POP_UP_TITLE_XPATH = "//div[@id='expired-tax-certificate-modal']//h4";
    public final static String EXPIRED_TAX_CERT_POP_UP_XPATH = "//div[@id='expired-tax-certificate-modal']//div[@class='modal-content']";
    public final static String HERE_LINK_IN_ACCOUNT_INFO_DROP_DOWN_ID = "activate-tax-modal";
    public final static String MAIN_TEXT_IN_EXPIRED_TAX_CERT_POP_UP_XPATH = "//div[@id='expired-tax-certificate-modal']//div[@class='d-flex']/div[2]";
    public final static String DISMISS_BUTTON_XPATH = "//button[contains (text(), 'Dismiss')]";
}