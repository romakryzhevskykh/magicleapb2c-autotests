package com.geempower.storefront.page_elements.order;

public class PODetailsPageElements {
    public final static String PURCHASE_ORDER_TITLE_XPATH = "//section[@class='main-content-section']//h4";
    public final static String PO_NUMBERS_ORDER_TABLE_ID = "po-number-orders";
    public final static String PO_NUMBERS_ORDER_TABLE_SELECT_ALL_CHECKBOX_XPATH = "//th[@class='checkbox-col select-all-link no-sort sorting_disabled']//ins";
    public final static String ACTIVE_NEXT_BUTTON_ABOVE_PO_NUMBERS_ORDER_TABLE_XPATH = "//button[contains(@id, 'po-show-selected-orders')and (not(@disabled))] ";
    public final static String PO_NO_TITLE_NUMBER_XPATH = "//input[@id='po-number']";
    public final static String EMAIL_DOWNLOAD_ICON_XPATH = "//i[@class='fa fa-download']";
    public final static String EXPAND_CLOSE_STATUS_BOXES_ARROW_BUTTON_XPATH = "//i[@class = 'fa fa-chevron-down']";
    public final static String EXPANDED_STATUS_BOXES_LINE_XPATH = "//div[@class='details-graphical clearfix active']";
    public final static String STATUS_BOX_TITLES_XPATH = "//div[@class='order-item']//span[@class = 'item-name']";
    public final static String LABEL_VALUES_IN_PO_DETAILS_BLOCK_XPATH = "//label[contains(text(),'%s')]/following-sibling::p";
    public final static String TIME_STATUSES_DROP_DOWN_FIELD_XPATH = "//span[@class='select2-selection__arrow']";
    public final static String TIME_STATUSES_VALUES_IN_DROP_DOWN_XPATH = "//li[contains(@class,'select2-results__option') and not(contains(@class,'highlight'))]";

}

