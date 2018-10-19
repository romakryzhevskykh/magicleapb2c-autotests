package com.geempower.storefront.page_elements;

public class AccountManagementPageElements {

    public final static String CANCEL_BUTTON_XPATH = ".//*[@class='btn btn-white']";
    public final static String REGION_COMBOBOX_XPATH = ".//*[@id='select2-region-container']";
    public final static String APPROPRIATE_REGION_BY_NAME_XPATH = ".//ul[@class='select2-results__options']/li[text()='%s']";
    public final static String SEARCH_FIELD_XPATH = ".//input[@id='searchAccount']";
    public final static String SEARCH_BUTTON_XPATH = ".//button[.='Search'and@class='btn primary-btn account-search-btn']";
    public final static String FIRST_ACCOUNT_FROM_LIST_OF_ACCOUNTS_XPATH = ".//div[@id='recently-viewed']//tr[@class='odd'or@class='even']/*[2]/a[1]";
    public final static String ACCOUNT_WITH_APPROPRIATE_SALES_DIVISION_FROM_LIST_OF_ACCOUNTS_XPATH = ".//div[@id='recently-viewed']//tr[@class='odd'or@class='even']/*[2]/a[contains(@href, '%s')]";
    public final static String REQUEST_ACCOUNT_BUTTON_XPATH = "//button[@class='btn btn-white request-account-btn']";
    private final static String ACCOUNT_ROW_IN_POP_UP_XPATH = "//div[@class='request-account-form-body']/div[@class='row']";
    private final static String ACCOUNT_ROW_IN_POP_UP_BY_COUNTER_XPATH = ACCOUNT_ROW_IN_POP_UP_XPATH + "[%s]";
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
    public final static String FAVORITES_ACCOUNTS_TAB_XPATH = "//a[@href='#favorites']";
    public final static String STAR_ICON_FOR_APPROPRIATE_ACCOUNT_ON_APPROVED_ACCOUNT_TAB_XPATH = ".//*[@id='activeRequestsTable']/tbody/tr[1]/td[text()='%s']/..//td[@class=' table-visible-lg-block']//i[@class='fa-star far']";
    public final static String STAR_ICON_FOR_APPROPRIATE_ACCOUNT_ON_FAVORITES_TAB_XPATH = "//table[@id='favoritesTable']/tbody/tr/td[text()='%s']/..//td[@class=' table-visible-lg-block']//i[@class='fa-star  fas']";
    public final static String APPROVED_ACCOUNT_ROW_XPATH = "//*[@class='my-pending-accounts-wrapper']//tr[@role='row' and @class='odd' or @class='even']";
    public final static String ACCOUNT_NAME_VALUE_IN_TABLE_XPATH = ".//*[@id='activeRequestsTable']/tbody/tr[1]/td[3]";
    public final static String FULL_INFO_OF_FIRST_ACCOUNT_APPROVED_ACC_TAB_XPATH = ".//*[@id='activeRequestsTable']/tbody/tr[1]/td[2]/a";
    public final static String PENDING_FOR_APPROVAL_TABLE_NO_DATA_TITLE_XPATH = "//*[@id='pendingApprovalTable']//td";
    public final static String APPROVED_ACCOUNTS_TAB_XPATH = "//a[@href='#recently-viewed']";
    public final static String APPROVED_ACCOUNTS_NAME_IN_APPROVED_ACCOUNTS_TABLE_XPATH = "//table[@id='activeRequestsTable']/tbody/tr/td[2]";
    public final static String REMOVE_ACCOUNT_ACTION_FOR_APPROPRIATE_ACCOUNT_THREE_DOT_ICON_XPATH = "//td[@class=' table-visible-lg-block']/a[contains(text(), '%s')]/../..//td[@class=' table-visible-lg-block']/ul//i[@class='fa fa-ellipsis-v']";
    public final static String THREE_DOT_ICON_REMOVE_ACCOUNT_XPATH = "//td[@class=' table-visible-lg-block']/a[contains(text(),'%s')]/../..//td[@class=' table-visible-lg-block']/ul//i[@class='fas fa-trash']";
    public final static String CONFIRMATION_FOR_REMOVE_ACTIVE_ACCOUNT_BUTTON_XPATH = "//button[@id='removeActiveBtn']";
    public final static String FAVORITES_ACTIVE_TAB_XPATH = "//li[contains(@class,'active') and contains(@tab-id ,'1')]";
    public final static String APPROVED_ACCOUNTS_LIST_XPATH = "//table[@id='activeRequestsTable']/tbody/tr/td[2]/a";
    public final static String APPROVED_ACCOUNTS_TABLE_XPATH = "//table[@id='activeRequestsTable']/tbody/tr/td[1]";
    public final static String FAVORITES_ACCOUNTS_TABLE_ID = "favoritesTable";
    public final static String LIST_OF_FAVORITES_ACCOUNTS_FULL_INFO_XPATH = "//table[@id='favoritesTable']/tbody/tr/td[2]/a";
    public final static String WE_ARE_NOW_ABB_POP_UP_XPATH = "//img[contains(@src, 'WEAREABB')]";
    public final static String WE_ARE_NOW_ABB_OK_BUTTON_XPATH = WE_ARE_NOW_ABB_POP_UP_XPATH + "//..//..//../div/button";
    public final static String PRE_AUTHORIZATION_CODE_SECTION_FIRST_PART_TITLE_XPATH = "//label[@class='control-label']";
    public final static String PRE_AUTH_INPUT_XPATH = "//input[@id='preauthorizedCode']";
    public final static String PRE_AUTH_GO_BUTTON_XPATH = "//button[@class='btn primary-btn pre-authorized-btn-ma-js']";
    public final static String PRE_AUTH_ACCOUNTS_TABLE_XPATH = "//table[@id='preauthorizedAccountsTbl']";
    public final static String PRE_AUTH_ACCOUNTS_TABLE_BODY_XPATH = "//table[@id='preauthorizedAccountsTbl']/tbody";
    public final static String PRE_AUTH_SEND_REQUEST_BUTTON_XPATH = "//button[@id='sendPreauthorizeRequestBtn']";
    public final static String MODAL_DIALOG_XPATH = "//div[@class='modal-dialog']";
    public final static String COUNT_OF_FAVORITE_ACCOUNTS_ON_FAVORITES_TAB_ID = "favoritesTable_info";
    public final static String LIST_OF_NOT_FAVORITES_ACCOUNTS_XPATH = "//tr[td[@class=' table-visible-lg-block']//i[@class='fa-star far']]/td[2]/a";
    public final static String NOT_FAVORITE_ACCOUNT_STAR_ICON_XPATH = "//tr/td[2]/a[contains(@href, '%s')]/../../td[@class=' table-visible-lg-block']/ul//i[@class='fa-star far']";
    //Request Account pop-up
    public final static String SALES_OFFICE_CODE_FIELD_ID = "requestSalesOfficeCode";
    public final static String SALES_ENGINEER_CODE_FIELD_ID = "requestSalesEngCode";
    public final static String MODIFY_ACTIVE_BUTTON_XPATH = ".//*[@class='btn primary-btn request-account-search-btn sales-update request-sales-btn' and not(@disabled)]";
    public final static String LIST_OF_REJECTED_INFO_MESSAGES_XPATH = "//ul[@class='rejected-request-list']/li/p";
}
