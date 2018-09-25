package com.geempower.storefront.page_elements;

public class ShipmentsPageElements {
    public final static String SHIPMENTS_TITLE_XPATH = "//section[@class='main-content-section shipment-dashboard-section']//h3";
    public final static String LAST_SHIPMENTS_DROPDOWN_ID = "select2-shipmentRowNumber-container";
    public final static String FILTERS_BUTTON_XPATH = "//i[@class='fa fa-filter']";
    public final static String BELL_ICON_XPATH = "//i[@class='fa fa-bell']";
    public final static String DOWNLOAD_BUTTON_XPATH = "//i[@class='fa fa-download']";
    public final static String COLOR_BOXES_XPATH = "//div[@class='color-blocks clearfix']";
    public final static String SHIPMENTS_TABLE_FILTERS_XPATH = "//*[@id='shipment-table']/thead/tr";
    public final static String EXCEL_BUTTON_ID = "exportShipmentsToEXCEL";
    public final static String ACTIVE_N_SHIPMENTS_VALUE_XPATH = "//span[@id='select2-shipmentRowNumber-container']";
    public final static String COUNT_OF_SHIPMENTS_IN_EACH_STATUS_XPATH = "//div[@class='color-blocks-item-inner']//span";
    public final static String EXPAND_ALL_STATUS_BOXES_XPATH = "//i[@class='fa fa-chevron-down']";
    public final static String ALL_SHIPMENTS_IN_TABLE_XPATH = "//tbody/tr[contains(@class,'item-account')]";
    public final static String OPEN_LAST_N_SHIPMENTS_DROPDOWN_XPATH = "//span[@aria-labelledby='select2-shipmentRowNumber-container']//b";
    public final static String LAST_N_SHIPMENTS_VALUE_FILTER_XPATH = "//ul[@id='select2-shipmentRowNumber-results']/li[contains(text(), '%s')]";
    public final static String PAGING_XPATH = "//div[@id='shipment-table_paginate']";
    public final static String COUNT_OF_PAGES_SHIPMENT_DASHBOARD_XPATH = "//span[@class='paginate_of']";
    public final static String NEXT_SHIPMENT_PAGE_XPATH = "//i[@class='fa fa-angle-right']";
    public final static String ALL_DATES_XPATH = "//td[@class='table-visible-lg-block sorting_1']";
}