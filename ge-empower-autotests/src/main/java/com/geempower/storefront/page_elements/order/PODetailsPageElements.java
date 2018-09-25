package com.geempower.storefront.page_elements.order;

public class PODetailsPageElements {
    public final static String PURCHASE_ORDER_TITLE_XPATH = "//section[@class='main-content-section']//h4";
    public final static String PO_NUMBERS_ORDER_TABLE_ID = "po-number-orders";
    public final static String PO_NUMBERS_ORDER_TABLE_SELECT_ALL_CHECKBOX_XPATH = "//th[@class='checkbox-col select-all-link no-sort sorting_disabled']//ins";
    public final static String ACTIVE_NEXT_BUTTON_ABOVE_PO_NUMBERS_ORDER_TABLE_XPATH = "//button[contains(@id, 'po-show-selected-orders')and (not(@disabled))] ";
    public final static String PO_NO_TITLE_NUMBER_XPATH = "//input[@id='po-number']";
    public final static String EMAIL_DOWNLOAD_ICON_XPATH = "//i[@class='fa fa-download']";
    public final static String EXPAND_CLOSE_STATUS_BOXES_ARROW_BUTTON_XPATH = "//i[@class = 'fa fa-chevron-down']";
}

