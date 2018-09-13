package com.geempower.storefront.page_elements;

public class UserNotActivePageElements {
    public final static String USER_NOT_ACTIVE_PAGE_TITLE_XPATH = "//p[@class ='navigation-navbar-heading']";
    public final static String REQUEST_ACCOUNT_BUTTON_XPATH = "//button[@data-target='#request-external-account-modal']";
    public final static String REQUEST_ACCOUNT_TITLE_IN_POP_UP_XPATH = "//div[@id='request-external-account-modal']//h4";
    public final static String PRE_AUTHORIZATION_CODE_TITLE_IN_POP_UP_XPATH = "//div[@id='pre-authorization-code-modal']//h4";
    public final static String CLOSE_BUTTON_IN_REQUEST_ACCOUNT_POP_UP_XPATH = "//div[@class = 'modal fade request-external-account-modal manage-account-modal in']//button[@id = 'cancelBtn']";
    public final static String CANCEL_BUTTON_IN_PRE_AUTH_CODE_POP_UP_XPATH = "//div[@id = 'pre-authorization-code-modal']//button[@class = 'btn secondary-btn']";
    public final static String ADD_ACCOUNT_FIELD_BUTTON_XPATH = "//button[@id = 'addAccountInput']";
    public final static String ACCOUNT_NO_FIELD_XPATH = "//input[@name = 'accountsList']";
    public final static String REQUESTED_ACCOUNT_FIELD_XPATH = "//div[@class = 'accRequestPage_haveAcc']//input[@class = 'form-control request-account-input']";
    public final static String ACTIVE_SUBMIT_FOR_APPROVAL_BUTTON_XPATH = "//button[contains(@id,'requestNewAccountsBtn') and not(contains(@disabled,'disabled'))]";
    public final static String MAIN_BLOCK_HELLO_MESSAGE_SCREEN_1_XPATH = "//div[@class='accRequestPageHi']";
    public final static String MAIN_BLOCK_HOW_TO_FIND_TEXT_SCREEN_1_XPATH = "//div[@class='accRequestPageNavTitle']";
    public final static String MAIN_BLOCK_INVOICE_TEXT_SCREEN_1_XPATH = "//div[@class='accRequestPageInvoiceRow']";
    public final static String MAIN_BLOCK_ACCOUNT_MANAGER_TEXT_SCREEN_1_XPATH = "//div[@class='accRequestPageManageRow']";
    public final static String FOOTER_NOTE_TEXT_SCREEN_1_XPATH = "//div[@class='accRequestPageFooter_title']";
    public final static String FOOTER_LOCATE_A_DISTRIBUTOR_LINK_TEXT_SCREEN_1_XPATH = "//a[@id='locate-distributor']";
    public final static String FOOTER_CONTACT_US_LINK_TEXT_SCREEN_1_XPATH = "//a[@id='contact-us']";
    public final static String MAIN_BLOCK_HELLO_MESSAGE_SCREEN_2_XPATH = "//div[@class = 'accRequestPage_haveAcc']/div[1]";
    public final static String MAIN_BLOCK_HELLO_MESSAGE_2_SCREEN_2_XPATH = "//div[@class = 'accRequestPage_haveAcc']/div[2]";
    public final static String MAIN_BLOCK_REQUESTED_ACCOUNTS_TEXT_2_SCREEN_2_XPATH = "//div[@class = 'accRequestPage_haveAcc']/div[3]";
    public final static String MAIN_BLOCK_AUTHORIZATION_CODE_TEXT_SCREEN_2_XPATH = "//div[@class = 'accRequestPage_haveAcc']/p";
    public final static String MAIN_BLOCK_PLEASE_ALLOW_US_TEXT_SCREEN_2_XPATH = "//div[@class = 'accRequestPage_haveAcc']/div[5]";
    public final static String YES_PRE_AUTH_BUTTON_XPATH = "//button[@class = 'btn primary-btn pre-authorization-btn-popup-js']";
}