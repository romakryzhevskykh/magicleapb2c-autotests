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
    public final static String NEXT_TOP_BUTTON = "//div[contains(@class,'return-order-title')]//button[@class='btn primary-btn btnRequestSummary reviewRequestsValidate']";
}
