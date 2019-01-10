package com.geempower.storefront.page_elements.rebate;

public class RebateCreation1PageElements {
    private final static String STEPS_ICONS_XPATH = "//ul[@class='return-wizard-section clearfix']";
    public final static String REBATE_CREATE_REQUEST_ACTIVE_STEP_XPATH = STEPS_ICONS_XPATH + "/li[@class='rebate-create-request active']";
    public final static String MANUAL_ENTRY_OPTION_XPATH = "//a[@href='#manual-entry']";
    public final static String ACCOUNT_NO_INPUT_XPATH = "//input[@class='form-control track-ship-modify-detail-input account-for-rebate mandatory-input']";
    public final static String FIRST_ACCOUNT_FROM_THE_RESULT_ACCOUNTS_LIST_XPATH = "//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content']/li[1]";
    public final static String SPA_NO_SEARCH_ICON_XPATH = "//a[@class='input-group-addon rebate-pricing-lookup-link']/i";
    public final static String SPECIAL_PRICING_LOOKUP_LIST_XPATH = "//tr[contains(@class,'select-spa-number')]/td[1]";
    public final static String SPECIAL_PRICING_LOOKUP_APPLY_BUTTON_XPATH ="//button[@class='btn primary-btn rebate-spl-pricing-apply']";
    public final static String CATALOG_NO_INPUT_XPATH = "//input[@class='form-control catalog-number-input mandatory-input']";
    public final static String END_CUSTOMER_ACCOUNT_NO_SEARCH_ICON_XPATH = "//a[@class='input-group-addon search-end-customer']/i";
    public final static String END_CUSTOMER_NO_LIST_XPATH = "//tr[contains(@class, 'select-end-customer')]/td[1]";
    public final static String END_CUSTOMER_NO_APPLY_BUTTON_XPATH = "//button[@class='btn primary-btn rebates-end-cus-no rebates-end-cus-no-apply-btn']";
    public final static String END_CUSTOMER_INVOICE_DATE_ICON_XPATH = "//i[@class='far fa-calendar-alt']";
    public final static String SOME_AVAILABLE_DAY_FROM_CALENDAR_XPATH = "//td[@class='day']";
    public final static String DISTRIBUTOR_INVOICE_NO_INPUT_XPATH = "//input[contains(@name, 'distributorInvoiceNumber')]";
    public final static String QTY_SOLD_INPUT_XPATH = "//input[@class='form-control numbersOnly mandatory-input']";
    public final static String NEXT_TOP_BUTTON_FIRST_STEP_XPATH = "//div[@class='panel clearfix']//button[@class='btn primary-btn pass-to-review-request-btn']";
    public final static String SPECIAL_PRICING_LOOKUP_POP_UP_TITLE_XPATH = "//div[@id='rebate-special-pricing-lookup-modal']//h4[@class='modal-title']";
    public final static String END_CUSTOMER_ACCOUNT_NO_POP_UP_TITLE_XPATH = "//div[@id='rebate-end-customer-modal']//h4[@class='modal-title']";
    public final static String UPLOAD_INPUT_PATH_XPATH = "//input[@id='rebate-upload-file']";
    public final static String QUESTION_ICON_XPATH = "//a[@class='text-grey2 popover-link']/i";
    public final static String TOOLTIP_QUESTION_ICON_XPATH = "//div[@class = 'popover fade top in']//div[@class = 'popover-content']";
    public final static String TOOLTIP_APPLY_AND_NEXT_BUTTONS_XPATH = "//div[@class='tooltip-inner']";
}