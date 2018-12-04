package com.geempower.storefront.page_elements.returns;

public class ReturnCreation4PageElements {
    public final static String REQUEST_SUMMARY_ACTIVE_TITLE_XPATH = "//li[@class='return-request-summary active']";
    public final static String BOTTOM_SUBMIT_REQUEST_BUTTON_XPATH = "//div[@class='return-tab-content']//*[@class='btn primary-btn bg-lightest-green']";
    public final static String ARROW_DOWN_ALL_BUTTON_XPATH = "//i[@class='fa fa-chevron-circle-down collapsed collapsedAll display-inline-block']";
    public final static String INVOICE_NO_VALUE_XPATH = "//td[@class='create-summary-invoice-col']/span";
    public final static String REASON_FOR_REQUEST_VALUE_XPATH = "//td[@class='create-summary-reason-col']/span";

    private final static String TABLE_INFO_XPATH = "//table[@class='table info-table return-tracking-table']";
    public final static String REQUEST_ACTION_VALUE_XPATH = TABLE_INFO_XPATH + "//label[contains (text(),'Requested Action')]/following-sibling::p";
    public final static String COLOR_OF_SHRINK_WRAP_VALUE_XPATH = TABLE_INFO_XPATH + "//label[contains (text(),'Color of Shrink Wrap')]/following-sibling::p";
    public final static String ADDITIONAL_INFO_VALUE_XPATH = TABLE_INFO_XPATH + "//label[contains (text(),'Additional Information')]/following-sibling::p";

    public final static String TERMS_AND_CONDITIONS_POP_UP_XPATH = "//*[@id='terms-condition-modal']//h4[@class='modal-title']";
    public final static String REQUEST_SUBMISSION_POP_UP_ID = "return-success-header";
    public final static String AGREED_CHECKBOX_POP_UP_XPATH = "//div[@id='terms-condition-modal']//ins[@class='iCheck-helper']";
    public final static String SUBMIT_TERMS_POPUP_BUTTON_ID = "submitReturnRequest";
    public final static String CATALOG_NO_VALUE_XPATH = "//td[@class='create-summary-catalog-col']";
    public final static String REQUEST_CONFIRM_NUMBER_ID = "requestConfNumberSuccess";
    public final static String CLOSE_REQUEST_BUTTON_XPATH = "//*[@class='btn secondary-btn cancel-return-request-btn-js']";
    public final static String QUESTION_ICON_XPATH = "//ul[@class='row form-row']//i[@class='fa fa-question-circle']";
    public final static String TOOLTIP_QUESTION_ICON_XPATH = "//div[@class = 'popover fade top in']//div[@class = 'popover-content']";
}