package com.geempower.storefront.page_block_elements;

public class IwantToBlockElements {
    //MODIFY AN ACCOUNT TAB
    public final static String MODIFY_AN_ACCOUNT_TAB_XPATH = "//span[contains (text(), 'Modify an Account')]";
    public final static String SALES_OFFICE_CODES_TAB_IN_MODIFY_ACC_TAB_XPATH = "//*[@href='#approved-salesofficecode']";
    public final static String SALES_ENGINEER_CODES_TAB_IN_MODIFY_ACC_TAB_XPATH = "//*[@href='#approved-salesengineer']";
    public final static String ALL_SO_CODES_CHECKBOX_IN_MODIFY_AN_ACC_TAB_XPATH = "//div[@id='approved-salesofficecode']//*[contains(@class, 'select-all-user-accounts')]/label";
    public final static String ALL_SE_CODES_CHECKBOX_IN_MODIFY_AN_ACC_TAB_XPATH = "//div[@id='approved-salesengineer']//*[contains(@class, 'select-all-user-accounts')]/label";
    public final static String REMOVE_BUTTON_IN_SO_CODES_TAB_IN_MODIFY_AN_ACC_TAB_XPATH = "//*[@data-target='#remove-salesoffice-modal']";
    public final static String REMOVE_BUTTON_IN_SE_CODES_TAB_IN_MODIFY_AN_ACC_TAB_XPATH = "//*[@data-target='#remove-salesengineer-modal']";
    public final static String REMOVE_BUTTON_IN_ALL_ACCOUNTS_TAB_XPATH = "//button[not(@disabled)][@data-target]";
    public final static String REMOVE_ACCOUNT_POP_UP_TITLE_SO_CODES_XPATH = "//*[@id='remove-salesoffice-modal']//h4";
    public final static String REMOVE_ACCOUNT_POP_UP_TITLE_SE_CODES_XPATH = "//*[@id='remove-salesengineer-modal']//h4";
    public final static String REMOVE_ACCOUNT_POP_UP_TITLE_ALL_ACCOUNTS_XPATH = "//*[@id='remove-user-modal']//h4";
    public final static String REMOVE_BUTTON_IN_REMOVE_ACC_POP_UP_IN_SO_CODES_TAB_XPATH = "//*[@class='btn primary-btn remove-salesoffice-btn']";
    public final static String REMOVE_BUTTON_IN_REMOVE_ACC_POP_UP_IN_SE_CODES_TAB_XPATH = "//*[@class='btn primary-btn remove-salesengineer-btn']";
    public final static String REMOVE_BUTTON_IN_REMOVE_ACC_POP_UP_IN_ALL_ACCOUNTS_TAB_XPATH = "//*[@class='btn primary-btn remove-user-btn']";
    public final static String EMPTY_SO_CODES_TABLE_XPATH = "//*[@id='approved-salesofficecode']//*[@class='dataTables_empty']";
    public final static String EMPTY_SE_CODES_TABLE_XPATH = "//*[@id='approved-salesengineer']//*[@class='dataTables_empty']";
    public final static String EMPTY_ALL_ACCOUNTS_TABLE_XPATH = "//table[@id = 'activeRequestsTableForCustomer']//td[@class = 'dataTables_empty']";
    public final static String REMOVE_ACCOUNT_POP_UP_SO_CODES_XPATH = "//*[@id='remove-salesoffice-modal']//div[@class='modal-content']";
    public final static String REMOVE_ACCOUNT_POP_UP_SE_CODES_XPATH = "//*[@id='remove-salesengineer-modal']//div[@class='modal-content']";
    public final static String COUNT_OF_PAGES_ALL_ACCOUNTS_TAB_XPATH = "//div[@id = 'activeRequestsTableForCustomer_paginate'][not(contains(@style,'display: none;'))]//span[@class='paginate_of']";
    public final static String NEXT_PAGINATION_BUTTON_ALL_ACCOUNTS_TAB_XPATH = "//span[@id = 'activeRequestsTableForCustomer_next']";
    public final static String APPROPRIATE_SO_CODE_CHECKBOX_XPATH = "//tr[contains(@class, '%s')]//label";

    //APPROVE PENDING ACCOUNTS TAB
    public final static String PENDING_SALES_OFFICE_CODES_TAB_APPROVED_PENDING_ACC_TAB_XPATH = "//*[@href='#pending-sales-office-codes-tab']";
    public final static String PENDING_SALES_ENGINEER_CODES_TAB_APPROVED_PENDING_ACC_TAB_XPATH = "//*[@href='#pending-sales-enginner-codes-tab']";
    public final static String ALL_CHECKBOX_SALES_OFFICE_CODES_IN_PENDING_SALES_OFFICE_TAB_XPATH = "//th[@class='checkbox-col pending-select-all-user-sales-office no-sort sorting_disabled']/label";
    public final static String ALL_ACCOUNTS_TABLE_ID = "activeRequestsTableForCustomer";
    public final static String ALL_ACCOUNT_NO_IN_ACCOUNTS_TABLE_XPATH = "//*[@id='activeRequestsTableForCustomer']/tbody/tr/td[2]";
    public final static String ALL_SO_CODES_IN_PENDING_SO_CODES_TABLE_XPATH = "//*[@id='pending-salesoffice']//tr[@class='odd']/td[2]";
    public final static String SALES_OFFICE_CODE_TABLE_XPATH = "//table[contains (@class, 'approved-sales-office-request-table')]";
    public final static String ALL_APPROVED_SALES_OFFICE_CODE_XPATH = "//*[@id='approved-salesofficecode']//tr[contains(@class,'odd')]/td[2]";
    public final static String ALL_APPROVED_SALES_ENGINEER_CODES_XPATH = "//*[@id='approved-salesengineer']//tr[contains(@class,'odd')]/td[2]";
    private final static String APPROVE_PENDING_ACCOUNTS_SECTION_XPATH = "//div[@class='account-detail-desc-wrapper manageuser-accordion']//a[@href='#pending-panel']";
    public final static String APPROVE_PENDING_ACCOUNTS_SECTION_TITLE_XPATH = APPROVE_PENDING_ACCOUNTS_SECTION_XPATH + "/span";
    public final static String APPROVE_PENDING_ACCOUNTS_SECTION_EXPAND_ICON_XPATH = APPROVE_PENDING_ACCOUNTS_SECTION_XPATH + "/i";
    public final static String PENDING_ACCOUNTS_TABLE_ROWS_XPATH = "//table[contains(@id,'DataTables_Table_')]/tbody/tr[contains(@class, 'item-account')]";
    public final static String PENDING_ACCOUNTS_TABLE_ROWS_BY_INDEX_XPATH = PENDING_ACCOUNTS_TABLE_ROWS_XPATH + "[%s]";
    public final static String ALL_PENDING_ACCOUNT_CHECKBOX_XPATH = "//th[@class='checkbox-col pending-select-all-user-accounts no-sort table-visible-lg-block sorting_disabled']/label";
    public final static String TOTAL_ACCOUNT_REQUESTS_XPATH = "//span[@id='totalRequests']";
    public final static String ACCEPT_ACCOUNT_BUTTON_XPATH = "//button[@data-target='#accept-selected-account-modal']";

    public final static String ACCEPT_SO_CODES_BUTTON_XPATH = "//button[@data-target='#accept-selected-salesoffice-modal']";
    public final static String REJECT_SO_CODES_BUTTON_XPATH = "//button[@data-target='#reject-selected-salesoffice-modal']";
    public final static String ACCEPT_ACCOUNT_POP_UP_TITLE_SO_CODES_IN_PENDING_SALES_OFFICE_TAB_XPATH = "//*[@id='accept-selected-salesoffice-modal']//h4";
    public final static String REJECT_ACCOUNT_POP_UP_TITLE_SO_CODES_IN_PENDING_SALES_OFFICE_TAB_XPATH = "//*[@id='reject-selected-salesoffice-modal']//h4";
    public final static String ACCEPT_BUTTON_IN_ACCEPT_ACC_POP_UP_IN_PENDING_S0_CODES_TAB_XPATH = "//*[@class='btn primary-btn accept-request-salesoffice-btn']";
    public final static String REJECT_BUTTON_IN_REJECT_ACC_POP_UP_IN_PENDING_S0_CODES_TAB_XPATH = "//*[@class='btn primary-btn reject-request-salesoffice-btn']";
    public final static String REJECT_ACCOUNT_BUTTON_XPATH = "//button[@data-target='#reject-selected-account-modal']";
    public final static String ACCEPT_THE_ACTION_IN_ACCEPT_ACCOUNT_POP_UP_XPATH = "//button[@class='btn primary-btn accept-request-account-btn']";
    public final static String ACCEPT_THE_ACTION_IN_REJECT_ACCOUNT_POP_UP_XPATH = "//button[@class='btn primary-btn reject-request-account-btn']";
    public final static String PENDING_ACCOUNTS_TABLE_NO_DATA_TITLE_XPATH = "//table[contains(@id,'DataTables_Table_')]/tbody/tr/td[@colspan='8']";
    public final static String ACTIVE_USER_ACCOUNTS_NAME_TABLE_XPATH = "//table[@id='activeRequestsTableForCustomer']/tbody/tr/td[2]";
    public final static String REMOVE_ACCOUNT_POP_UP_ALL_ACCOUNTS_XPATH = "//*[@id='remove-user-modal']//div[@class='modal-content']";
    public final static String ACCOUNT_CHECKBOX_XPATH = "//td[contains (text(),'%s')]/../td[1]/label";
    public final static String EMPTY_SO_CODES_TABLE_IN_PENDING_SO_CODES_XPATH = "//*[@id='pending-salesoffice']//*[@class='dataTables_empty']";

    public final static String EXPAND_CHANGE_EMPOWER_PRIVILEGES_ROLES_ICON_XPATH = "//a[@href='#additem1']/i";
    public final static String ROLE_FOR_APPROPRIATE_REGION_XPATH = "//label[contains(text(),'%s')]//..//span[contains(@aria-labelledby, 'select2-regionuserrole')]/span[@id]";
    public final static String OPEN_ROLES_LIST_FOR_APPROPRIATE_REGION_ICON_XPATH = ROLE_FOR_APPROPRIATE_REGION_XPATH + "/..//b";
    public final static String ALL_ROLES_IN_ROLES_DROPDOWN_XPATH = "//ul[@class='select2-results__options']/li";
    public final static String ROLE_BY_TEXT_IN_DROPDOWN_ROLES_XPATH = "//ul[@class='select2-results__options']/li[normalize-space()='%s']";
    public final static String ASSIGN_ROLES_OR_PRIVILEGES_BUTTON_ID = "assignUserRoles-new";
}