package com.geempower.storefront.page_elements;

public class RebateCreation3PageElements {
    private final static String STEPS_ICONS_XPATH = "//ul[@class='return-wizard-section clearfix']";
    public final static String REBATE_REQUEST_SUMMARY_ACTIVE_STEP_XPATH = STEPS_ICONS_XPATH + "/li[@class='rebates-request-summary active']";
    public final static String ACCOUNT_DETAILS_VALUE_XPATH = "//li[@class='col-xs-12 col-md-9 col-lg-7']//span";
    public final static String SPA_QUOTE_NO_VALUE_XPATH = "//li[@class='col-xs-12 col-md-3 col-lg-3']//span";
    private final static String SUMMARY_REBATE_DETAILS_TABLE_XPATH = "//table[@class='table info-table spa-cliam-table-section1']";
    public final static String CATALOG_NO_VALUE_XPATH = SUMMARY_REBATE_DETAILS_TABLE_XPATH + "//td[1]";
    public final static String END_CUSTOMER_ACCOUNT_NO_VALUE_XPATH = SUMMARY_REBATE_DETAILS_TABLE_XPATH + "//td[2]";
    public final static String END_CUSTOMER_INVOICE_DATE_VALUE_XPATH = SUMMARY_REBATE_DETAILS_TABLE_XPATH + "//td[3]";
    public final static String DISTRIBUTOR_INVOICE_NO_VALUE_XPATH = SUMMARY_REBATE_DETAILS_TABLE_XPATH + "//td[4]";
    public final static String QTY_SOLD_VALUE_XPATH = SUMMARY_REBATE_DETAILS_TABLE_XPATH + "//td[5]";
    public final static String SUBMIT_REBATE_TOP_BUTTON_XPATH = "//div[contains(@class, 'return-order-title')]//button";
    public final static String TERMS_AND_CONDITIONS_POPUP_XPATH = "//*[@id='terms-condition-modal']//h4[@class='modal-title']";
    public final static String TERMS_AND_CONDITIONS_POPUP_CHECKBOX_XPATH = "//*[@id='terms-condition-modal']//ins[@class='iCheck-helper']";
    public final static String TERMS_AND_CONDITIONS_SUBMIT_BUTTON_XPATH = "//button[@id='submitRebate']";
    public final static String REQUEST_SUBMISSION_POPUP_TITLE_XPATH = "//h4[@id='return-success-header']";
    public final static String REQUEST_SUBMISSION_POPUP_CLOSE_BUTTON_XPATH = "//button[@class='btn secondary-btn cancel-rebate-request-btn-js']";
    public final static String REBATE_ID_XPATH = "//span[@id='rebateConfNumberSuccess']";
}
