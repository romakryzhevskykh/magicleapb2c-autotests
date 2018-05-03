package com.geempower.storefront.page_elements;

public class AccountManagementPageElements {

    public final static String CANCEL_BUTTON_XPATH = ".//*[@class='btn btn-white']";
    public final static String REGION_COMBOBOX_XPATH = ".//*[@id='select2-region-container']";
    public final static String APPROPRIATE_REGION_BY_NAME_XPATH = ".//ul[@class='select2-results__options']/li[text()='%s']";
    public final static String SEARCH_FIELD_XPATH = ".//input[@id='searchAccount']";
    public final static String SEARCH_BUTTON_XPATH = ".//button[.='Search'and@class='btn primary-btn account-search-btn']";
    public final static String FIRST_ACCOUNT_FROM_LIST_OF_ACCOUNTS_XPATH = ".//div[@id='recently-viewed']//tr[@class='odd'or@class='even']/*[2]/a[1]";
    public final static String ACCOUNT_WITH_APPROPRIATE_SALES_DIVISION_FROM_LIST_OF_ACCOUNTS_XPATH = ".//div[@id='recently-viewed']//tr[@class='odd'or@class='even']/*[2]/a[contains(@href, '%s')]";
    public final static String REQUEST_ACCOUNT_BUTTON = "//button[@class='btn btn-white request-account-btn']";
    public final static String ACCOUNT_ROW_IN_POP_UP_XPATH = "//div[@class='request-account-form-body']/div[@class='row']";
    public final static String ACCOUNT_ROW_IN_POP_UP_BY_COUNTER_XPATH = ACCOUNT_ROW_IN_POP_UP_XPATH + "[%s]";
    public final static String REGIONS_DROP_DOWN_BY_COUNTER_IN_POPUP_XPATH = ACCOUNT_ROW_IN_POP_UP_BY_COUNTER_XPATH + "//span[contains(@class,'select2-container')]";
    public final static String REGIONS_ACCOUNT_FIELD_BY_COUNTER_IN_POPUP_XPATH = ACCOUNT_ROW_IN_POP_UP_BY_COUNTER_XPATH + "//input[@class='form-control account-input']";
    public final static String SEND_EXTERNAL_REQUEST_BUTTON_ID = "sendExternalRequestBtn";
    public final static String PENDING_FOR_APPROVAL_TAB_XPATH = "//ul[@class='my-pending-account-list mytabs dynamic-tabs']/li[3]";
    public final static String PENDING_ACCOUNTS_COLUMN_ON_PENDING_FOR_APPROVAL_TAB_XPATH = "//table[@id='pendingApprovalTable']/tbody/tr[%s]/td[2]";
    public final static String MORE_ACTIONS_THREE_DOT_ICON_XPATH = "//table[@id='pendingApprovalTable']/tbody/tr[1]/td[last()]/ul/li/a/i";
    public final static String CANCEL_REQUEST_BUTTON_XPATH = "//table[@id='pendingApprovalTable']/tbody/tr[1]/td[last()]/ul/li[@class='action-detail open']/ul[@class='dropdown-menu dropdown-list more-action-dropdown']/li/a";
    public final static String CONFIRMATION_FOR_CANCELING_REQUEST_XPATH = "//button[@id='cancelPendingBtn']";
    public final static String CANCEL_REQUEST_CONFIRMATION_POPUP_XPATH = "//body[@id='empower']/div[@id='page']/div[@id='cancel-am-request-modal']/div[@class='modal-dialog']/div[@class='modal-content']";
    public final static String FULL_SCREEN_PROGRESS_INDICATOR_XPATH = "//div[@id='FullScreenProgressIndicatorModalDialog']";
    public final static String APPROVED_ACCOUNT_ROW_XPATH = "//*[@class='my-pending-accounts-wrapper']//tr[@role='row' and @class='odd' or @class='even']";
    public final static String ACCOUNT_NAME_VALUE_IN_TABLE_XPATH = ".//*[@id='activeRequestsTable']/tbody/tr[1]/td[3]";

}
