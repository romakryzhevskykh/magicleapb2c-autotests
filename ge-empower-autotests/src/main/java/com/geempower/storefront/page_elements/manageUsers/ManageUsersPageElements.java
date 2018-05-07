package com.geempower.storefront.page_elements.manageUsers;

public class ManageUsersPageElements {
    //GENERAL
    public final static String MANAGE_USERS_TITLE_XPATH = ".//*[@id='page']/header/section[2]/div/p";

    //PENDING REQUESTS TAB
    public final static String PENDING_REQUEST_TAB_XPATH = "//a[@aria-controls='pending-requests']";

    //USERS TAB
    public final static String USERS_TAB_XPATH = "//a[@aria-controls='users']";
    public final static String USER_TERM_INPUT_XPATH = "//input[@id='userterm']";
    public final static String ACCOUNT_DETAIL_SEARCH_INPUT_XPATH = "//input[@class='form-control account-detail-search ui-autocomplete-input']";
    public final static String SEARCH_USER_BY_PARAMS_BUTTON_XPATH = "//button[@class='btn primary-btn user-search-btn']";
    public final static String USERS_TABLE_XPATH = "//table[@id='examl']/tbody/";
    public final static String FIRST_USER_XPATH = "tr[1]";
    public final static String USER_NAME_FIELD_XPATH = USERS_TABLE_XPATH + FIRST_USER_XPATH + "/td[2]";

    public final static String FIRST_NAME_LINK_XPATH = USER_NAME_FIELD_XPATH + "/a";
    public final static String USER_EMAIL_FIELD_XPATH = USERS_TABLE_XPATH + FIRST_USER_XPATH + "/td[5]";
    public final static String USER_ROLE_FIELD_XPATH = USERS_TABLE_XPATH + FIRST_USER_XPATH + "/td[4]";
    public final static String USER_ID_FIELD_XPATH = USERS_TABLE_XPATH + FIRST_USER_XPATH + "/td[3]";
    public final static String USER_PHONE_FIELD_XPATH = USERS_TABLE_XPATH + FIRST_USER_XPATH + "/td[6]";
    public final static String USER_REVALIDATION_DATE_FIELD_XPATH = USERS_TABLE_XPATH + FIRST_USER_XPATH + "/td[7]";
    public final static String USER_STATUS_FIELD_XPATH = USERS_TABLE_XPATH + FIRST_USER_XPATH + "/td[8]";

    public final static String USER_DETAILS_BLOCK_XPATH = "//div[@class='info-wrapper no-info-wrapper-link p-0']";
    public final static String USER_DELAILS_USER_ID_XPATH = USER_DETAILS_BLOCK_XPATH + "//li[@class='col-xs-6 col-sm-3']//label[contains(.,'User ID')]/following::p[1]";
    public final static String ACTIVE_USER_STATUS_LABEL_XPATH = "//span[@class='ml-10 manage-user-revalidate']/span";
    public final static String FULL_USER_SUB_STATUS_XPATH = "//span[@class='ml-10 manage-user-revalidate']";
    public final static String USER_ACTIONS_LIST_OPEN_ICON_XPATH = "//button[@class='btn btn-blue dropdown-toggle']/span";
    public final static String APPROPRIATE_USER_OPTION_XPATH = "//a[text()='%s']";

    //REVALIDATION TAB
    public final static String REVALIDATION_TAB_XPATH = "//a[@aria-controls='revalidation']";

    //USER DETAIL BLOCK
    public final static String ADD_ACCOUNT_BUTTON_XPATH = ".//i[@data-original-title='Add Account']";

    //Add Account pop-up
    public final static String ADD_ACCOUNT_TITLE_XPATH = ".//*[@id='add-account-modal']//h4[@class='modal-title']";
    public final static String ADD_ACCOUNT_POP_UP_XPATH = "//*[@id='add-account-modal']//div[@class='modal-content']";
    public final static String SALES_OFFICE_CODE_FIELD_ID = "requestSalesOfficeCode";
    public final static String SALES_ENGINEER_CODE_FIELD_ID = "requestSalesEngCode";
    public final static String MODIFY_ACTIVE_BUTTON_XPATH = ".//*[@class='btn primary-btn request-account-search-btn sales-update add-sales-btn' and not(@disabled)]";
    public final static String SELECT_REGION_FIELD_ID = "select2-searchRegion-container";
    public final static String REGION_DROP_DOWN_LIST_ELEMENTS_XPATH = ".//*[@id='select2-searchRegion-results']/li";
    public final static String SALES_OFFICE_CODE_SECOND_FIELD_ID = "salesOfficeCodeInput";
    public final static String SALES_ENGINEER_CODE_SECOND_FIELD_ID = "salesEngCodeInput";
    public final static String SEARCH_BUTTON_XPATH = ".//*[@class='btn primary-btn manageuser-account-search-btn']";
    public final static String ADD_NEW_ACCOUNTS_TABLE_ID = "addNewAccountsTable";
    public final static String ACCOUNT_NAME_NEW_ACC_TABLE_XPATH = ".//*[@id='addNewAccountsTable']/tbody/tr[1]/td[3]";
    public final static String ACCOUNT_FIELD_XPATH = ".//*[contains(@class,'account-new-search')]";
    public final static String SELECT_ALL_CHECKBOX_XPATH = ".//*[@id='add-account-modal']//li[@class='select-all-link']//ins[@class='iCheck-helper']";
    public final static String ADD_BUTTON_ID = "addAccountBtn";
}