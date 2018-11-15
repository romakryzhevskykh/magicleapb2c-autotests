package com.geempower.storefront.page_elements;

public class RegistrationPageElements {
    private final static String USER_INFO_TABLE_XPATH = "//ul[@class='row form-row']";
    public final static String USER_NAME_VALUE_XPATH = USER_INFO_TABLE_XPATH + "/li[1]//p";
    public final static String USER_LAST_NAME_VALUE_XPATH = USER_INFO_TABLE_XPATH + "/li[2]//p";
    public final static String USER_ID_VALUE_XPATH = USER_INFO_TABLE_XPATH + "/li[3]//p";
    public final static String USER_EMAIL_VALUE_XPATH = USER_INFO_TABLE_XPATH + "/li[4]//p";
    public final static String COMPANY_INPUT_ID = "companyName";
    public final static String PHONE_INPUT_ID = "phone";
    public final static String DEFAULT_LANGUAGE_VALUE_ID = "select2-language-container";
    public final static String OPEN_REGIONS_LIST_ICON_XPATH = "//span[@aria-labelledby='select2-region-container']//b";
    public final static String ALL_REGION_VALUES_IN_REGIONS_LIST_XPATH = "//li[contains(@id, 'select2-region-result')]";
    public final static String CHOSEN_REGION_VALUE_ID = "select2-region-container";
    public final static String OPEN_COUNTRIES_LIST_ICON_XPATH = "//span[@aria-labelledby='select2-country-container']//b";
    public final static String ALL_COUNTRY_VALUES_IN_COUNTRIES_LIST_XPATH = "//li[contains(@id, 'select2-country-result')]";
    public final static String OPEN_RELATIONSHIP_LIST_ICON_XPATH = "//span[@aria-labelledby='select2-userRelationType-container']//b";
    public final static String RELATIONSHIP_TO_INDUSTRIAL_SOLUTION_VALUE_IN_LIST_XPATH = "//ul[@id='select2-userRelationType-results']/li[contains(@id, '%s')]";
    public final static String RELATIONSHIP_TO_INDUSTRIAL_SOLUTION_VALUE_ID = "select2-userRelationType-container";
    public final static String OPEN_ROLES_LIST_ICON_XPATH = "//span[@aria-labelledby='select2-role-container']//b";
    public final static String APPROPRIATE_USER_ROLE_VALUE_IN_ROLES_LIST_XPATH = "//li[contains(@id, '%s')]";
    public final static String ALL_ROLE_VALUES_IN_ROLES_LIST_XPATH = "//ul[@id='select2-role-results']/li[contains(@id, 'select2-role-result')]";
    public final static String REGISTER_BUTTON_ID = "registration_form_submit";
    public final static String REGISTRATION_SUCCESSFUL_POP_UP_HEADER_XPATH = "//div[@id='registration-confirmation-modal']//h4";
    public final static String CLOSE_SUCCESS_REGISTRATION_POP_UP_XPATH = "//div[@class='modal-footer']/button[@onclick]";
    public final static String ACCOUNT_INFORMATION_SECTION_XPATH = "//div[@class='account-info-wrapper']";
}
