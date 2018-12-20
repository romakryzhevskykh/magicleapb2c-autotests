package com.geempower.storefront.page_elements.rebate;

public class RebateCreation2PageElements {
    private final static String STEPS_ICONS_XPATH = "//ul[@class='return-wizard-section clearfix']";
    public final static String REBATE_REVIEW_REQUEST_ACTIVE_STEP_XPATH = STEPS_ICONS_XPATH + "/li[@class='rebates-review-request active']";
    public final static String ACCOUNT_NO_VALUE_XPATH = "//li[@class='col-xs-12 col-md-6 col-lg-6']/div/input[contains(@class, 'account-for-rebate')]";
    public final static String SPA_NO_VALUE_XPATH = "//input[contains(@name, 'spaNumber')]";
    public final static String CATALOG_NO_VALUE_XPATH = "//input[contains(@class, 'catalog-number')]";
    public final static String END_CUSTOMER_NO_VALUE_XPATH = "//input[contains(@name, 'endCustomerAccountNumber')]";
    public final static String END_CUSTOMER_INVOICE_DATE_VALUE_XPATH = "//input[contains(@name, 'endCustomerInvoiceDateStr')]";
    public final static String DISTRIBUTOR_INVOICE_NO_VALUE_XPATH = "//input[contains(@name, 'distributorInvoiceNumber')]";
    public final static String QTY_SOLD_VALUE_XPATH = "//input[contains(@name, 'qtySold')]";
    public final static String NEXT_TOP_BUTTON_XPATH = "//div[contains(@class,'return-order-title')]//button[@class='btn primary-btn btnRequestSummary reviewRequestsValidate']";
    public final static String END_CUSTOMER_INVOICE_DATE_VALIDATION_MESSAGE_XPATH = "//p[@class='text-red font-12']";
    public final static String ERROR_MESSAGE_ON_REBATE_CREATION_SECOND_PAGE_XPATH = "//div[@class='errors-rebates warning-message']";
    public final static String SAVE_FOR_LATER_REBATE_BUTTON_XPATH = "//button[@class='btn btn-white save-for-later']";
    public final static String SAVE_FOR_LATER_POP_UP_TITLE_XPATH = "//div[@id='save-rebate-request-modal']//h4";
    public final static String SAVE_FOR_LATER_POP_UP_HEADER_XPATH = "//p[@class='save-list-heading']";
    public final static String SAVE_FOR_LATER_POP_UP_LIST_NAME_INPUT_XPATH = "//input[@class='form-control new-list-input']";
    public final static String SAVE_FOR_LATER_POP_UP_SAVE_BUTTON_XPATH = "//button[@class='btn primary-btn save-rebate-request-btn-js']";
}