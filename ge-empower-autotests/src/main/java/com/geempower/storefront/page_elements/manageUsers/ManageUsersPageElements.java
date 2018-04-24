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
    private final static String USERS_TABLE_XPATH = "//table[@id='examl']/tbody/";
    private final static String FIRST_USER_XPATH = "tr[1]/";
    public final static String USER_SSO_FIELD_XPATH = USERS_TABLE_XPATH + FIRST_USER_XPATH + "td[2]";
    public final static String USER_EMAIL_FIELD_XPATH = USERS_TABLE_XPATH + FIRST_USER_XPATH + "td[5]";
    public final static String USER_ROLE_FIELD_XPATH = USERS_TABLE_XPATH + FIRST_USER_XPATH + "td[4]";
    public final static String USER_ID_FIELD_XPATH = USERS_TABLE_XPATH + FIRST_USER_XPATH + "td[3]";
    public final static String USER_PHONE_FIELD_XPATH = USERS_TABLE_XPATH + FIRST_USER_XPATH + "td[6]";
    public final static String USER_REVALIDATION_DATE_FIELD_XPATH = USERS_TABLE_XPATH + FIRST_USER_XPATH + "td[7]";
    public final static String USER_STATUS_FIELD_XPATH = USERS_TABLE_XPATH + FIRST_USER_XPATH + "td[8]";

    //REVALIDATION TAB
    public final static String REVALIDATION_TAB_XPATH = "//a[@aria-controls='revalidation']";
}
