package com.geempower.storefront.page_elements.order;

public class OrdersPageElements {
    public final static String ORDERS_TITLE_XPATH = "//section[@class='main-content-section']//h3[(text() ='Orders')]";
    public final static String COUNT_OF_PAGES_WITH_ORDERS_XPATH = "//div[(@id = 'DataTables_Table_0_paginate')]//span[@class='paginate_of']";
    public final static String ORDER_TABLE_SIZE_PER_PAGE_XPATH = "//table[@id='DataTables_Table_0']/tbody/tr";
    public final static String NEXT_ORDER_PAGE_XPATH = "//i[@class='fa fa-angle-right']";
    public final static String EMPTY_ORDERS_TABLE_XPATH = "//div[@class = 'content-result-list-wrapper']//td[@class='dataTables_empty']";
    public final static String FIRST_ORDER_IN_APPROPRIATE_STATUS_XPATH = "//td[@class='table-visible-lg-block sorting_1' and contains(text(), '%s')]//..//../tr[1]/td[1]/a";
    public final static String SORTING_ORDERS_TABLE_ICON_BY_STATUS_ID = "sortStatus";
    public final static String ORDER_LINK_BY_ORDER_NO_XPATH = "//td/a[contains(@href, '%s')]";
    public final static String LIST_OF_ORDER_NO_LINKS_XPATH = "//table[contains(@class,'all-order-list-table')]//td[@class = 'table-visible-lg-block']/a[contains(@href,'openOrderDetails')]";
    public final static String OPEN_ORDER_REPORT_TEXT_XPATH = "//span[@class='mr-10 hidden-sm']";
    public final static String OPEN_ORDER_REPORT_OPEN_BUTTON_XPATH = "//i[@class='fas fa-file-alt']";
    public final static String OPEN_ORDER_REPORT_WINDOW_TITLE_XPATH = "//header/h3";
    public final static String OPEN_PRICING_OPTIONS_ICON_XPATH = "//span[@id='select2-open-order-report-pricing-container']//../span[2]/b";
    public final static String PRICING_OPTION_BY_OPTION_LABEL_XPATH = "//li[contains(text(),'%s')]";
    public final static String GENERATE_NOW_OPEN_ORDER_REPORT_BUTTON_XPATH = "//button[@id='openOrdersReport']";
    private final static String OPEN_ORDER_REPORT_TABLE_XPATH = "//table[@id='open-order-report-table']/tbody/";
    private final static String OPEN_ORDER_REPORT_FIRST_ROW_XPATH = OPEN_ORDER_REPORT_TABLE_XPATH + "tr[1]/";
    public final static String OPEN_ORDER_REPORT_FIRST_ROW_POST_DATE_XPATH = OPEN_ORDER_REPORT_FIRST_ROW_XPATH + "td[1]";
    public final static String OPEN_ORDER_REPORT_FIRST_ROW_PRICING_OPTION_XPATH = OPEN_ORDER_REPORT_FIRST_ROW_XPATH + "td[2]";
    public final static String OPEN_ORDER_REPORT_FIRST_ROW_COMMENT_XPATH = OPEN_ORDER_REPORT_FIRST_ROW_XPATH + "td[3]";
    public final static String OPEN_ORDER_REPORT_WINDOW_CLOSE_ICON_XPATH = "//button[@class='btn btn-link close-order-report-icon']/i";
    public final static String FILTER_ORDERS_ICON_XPATH = "//i[@class='fa fa-filter']";
    public final static String FIRST_ORDER_NUMBER_FROM_ORDERS_LIST_XPATH = "//table[@id='DataTables_Table_0']/tbody/tr/td[1]/a";
    //FILTER SLIDER ELEMENTS
    public final static String ORDER_NO_FIELD_FILTER_SLIDER_XPATH = "//input[@id='order-filter-by-order-number']";
    public final static String PO_NO_FIELD_FILTER_SLIDER_XPATH = "//input[@id='order-filter-by-po-number']";
    public final static String JOB_NAME_FIELD_FILTER_SLIDER_XPATH = "//input[@id='order-filter-by-job-name']";
    public final static String APPLY_FILTER_BUTTON_XPATH = "//button[@id='order-filter-go-button']";
    public final static String CANCEL_FILTER_BUTTON_XPATH = "//button[@class='btn primary-btn border filter-canvas-close'][2]";


}