package com.geempower.storefront.page_block_elements;

public class IwantToBlockElements {
    public final static String MODIFY_AN_ACCOUNT_TAB_XPATH = ".//span[contains (text(), 'Modify an Account')]";
    public final static String SALES_OFFICE_CODES_TAB_XPATH = ".//*[@href='#approved-salesofficecode']";
    public final static String SALES_ENGINEER_CODES_TAB_XPATH = ".//*[@href='#approved-salesengineer']";
    public final static String ALL_ACCOUNTS_TABLE_ID = "activeRequestsTableForCustomer";
    public final static String ACCOUNT_NAME_IN_ACCOUNTS_TABLE_XPATH = ".//*[@id='activeRequestsTableForCustomer']/tbody/tr[1]/td[3]";
    public final static String ALL_ACCOUNT_NAMES_IN_ACCOUNTS_TABLE_XPATH = ".//*[@id='activeRequestsTableForCustomer']/tbody/tr/td[3]";
    public final static String SALES_OFFICE_CODE_TABLE_XPATH = ".//table[contains (@class, 'approved-sales-office-request-table')]";
    public final static String SALES_OFFICE_CODE_XPATH = ".//table[contains (@class, 'approved-sales-office-request-table')]//td[@class='account-number-col']";
    public final static String SALES_ENGINEER_CODE_XPATH = ".//table[contains (@class, 'approved-sales-engineer-request-table')]//td[@class='account-number-col']";
    public final static String ALL_SO_CODES_CHECKBOX_XPATH = ".//div[@id='approved-salesofficecode']//*[contains(@class, 'select-all-user-accounts')]/label";
    public final static String ALL_SE_CODES_CHECKBOX_XPATH = ".//div[@id='approved-salesengineer']//*[contains(@class, 'select-all-user-accounts')]/label";
    public final static String REMOVE_SO_CODES_BUTTON_XPATH = ".//*[@data-target='#remove-salesoffice-modal']";
    public final static String REMOVE_SE_CODES_BUTTON_XPATH = ".//*[@data-target='#remove-salesengineer-modal']";
    public final static String REMOVE_ACCOUNT_POP_UP_TITLE_SO_CODES_XPATH = ".//*[@id='remove-salesoffice-modal']//h4";
    public final static String REMOVE_ACCOUNT_POP_UP_TITLE_SE_CODES_XPATH = ".//*[@id='remove-salesengineer-modal']//h4";
    public final static String REMOVE_BUTTON_IN_REMOVE_ACC_POP_UP_XPATH = ".//*[@class='btn primary-btn remove-salesoffice-btn']";
    public final static String REMOVE_BUTTON_IN_REMOVE_ACC_POP_UP_IN_SE_CODES_TABLE_XPATH = ".//*[@class='btn primary-btn remove-salesengineer-btn']";
    public final static String EMPTY_SO_CODES_TABLE_XPATH = ".//*[@id='approved-salesofficecode']//*[@class='dataTables_empty']";
    public final static String EMPTY_SE_CODES_TABLE_XPATH = ".//*[@id='approved-salesengineer']//*[@class='dataTables_empty']";
    public final static String REMOVE_ACCOUNT_POP_UP_SO_CODES_XPATH = ".//*[@id='remove-salesoffice-modal']//div[@class='modal-content']";
    public final static String REMOVE_ACCOUNT_POP_UP_SE_CODES_XPATH = ".//*[@id='remove-salesengineer-modal']//div[@class='modal-content']";
}
