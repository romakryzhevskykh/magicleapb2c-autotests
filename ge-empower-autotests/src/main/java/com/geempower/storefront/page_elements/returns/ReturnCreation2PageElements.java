package com.geempower.storefront.page_elements.returns;

public class ReturnCreation2PageElements {
    public final static String REASON_FOR_REQUEST_ACTIVE_TITLE_XPATH = ".//li[@class='return-reason-request active']";
    public final static String FIRST_ROW_REASON_FOR_REQUEST_FIELD_XPATH = "(.//div[@class='dropdown-toggle multi-selection-box'])[2]//span[@class='return-selection']";
    public final static String ROW_BY_NUMBER_REASON_FOR_REQUEST_FIELD_XPATH = "//tr[@class='rowItem row_%s']//div[@class='dropdown-toggle multi-selection-box']//span[@class='return-selection']";
    public final static String REASON_FOR_REQUEST_DROP_DOWN_ELEMENTS_XPATH = "//*[contains(@class,'return-type-dropdown') and contains(@class ,'open')]//a[contains(@class,'reason-type')]";
    public final static String REQUEST_TYPE_LIST_XPATH = "//div[@class='dropdown-menu sub-menu request-type-list' and @style]/ul/li/a";
    public final static String REQUEST_SUB_TYPE_LIST_XPATH = "//div[@class='dropdown-menu sub-menu request-sub-type-list' and @style]/ul/li/a";
    public final static String FINAL_REASON_FOR_REQUEST_DROP_DOWN_ELEMENTS_XPATH = "//*[contains(@class,'return-type-dropdown') and contains(@class ,'open')]//a[contains(@class,'reason-type final')]";
    public final static String REQUESTED_ACTION_DROP_DOWN_ELEMENTS_XPATH = ".//ul[@class='select2-results__options']/li";
    public final static String FIRST_ROW_REQUESTED_ACTION_FIELD_XPATH = "(.//*[@class='select2 select2-container select2-container--default'])[1]";
    public final static String SELECTED_FIRST_ROW_REQUESTED_ACTION_FIELD_XPATH = "//table[@id='returnTrackingTableStep2']//*[@class='select2-selection select2-selection--single']//span[@class='select2-selection__rendered']";
    public final static String FIRST_QTY_FIELD_XPATH = "(.//*[@class='form-control qty-input-val done'])[1]";
    public final static String BOTTOM_NEXT_BUTTON_ID = "returnRequest2NextButton";
    public final static String CATALOG_NO_VALUE_XPATH = ".//*[@id='returnTrackingTableStep2']/tbody/tr/td[2]";
}