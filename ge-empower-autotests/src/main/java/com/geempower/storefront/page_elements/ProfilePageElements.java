package com.geempower.storefront.page_elements;

public class ProfilePageElements {
    public final static String PROFILE_TITLE_XPATH = ".//*[@id='page']/div[1]/header/section[2]/div/p";
    public final static String USER_FIRST_NAME_XPATH = "//label[contains(.,'First Name')]/following::p[1]";
    public final static String USER_LAST_NAME_XPATH = "//label[contains(.,'Last Name')]/following::p[1]";
    public final static String USER_ID_XPATH = "//label[contains(.,'User ID')]/following::p[1]";
    public final static String USER_EMAIL_ADDRESS_XPATH = "//label[contains(.,'Email')]/following::p[1]";
    public final static String USER_ALT_EMAIL_ADDRESS_XPATH = "//label[contains(.,'Email')]/following::p[2]";
    public final static String USER_COMPANY_NAME_XPATH = "//input[@name='companyName']";
    public final static String USER_PHONE_NUMBER_XPATH = "//input[@name='phoneNumber']";
    public final static String USER_LANGUAGE_XPATH = "//span[contains(@id,'select2-defaultLanguage')]";
    public final static String USER_ROLE_XPATH = "//span[contains(@id,'select2-role')]";
    public final static String USER_REGION_XPATH = "//span[contains(@id,'select2-region')]";
    public final static String USER_RELATIONSHIP_XPATH = "//span[contains(@id,'select2-relationship')]";
    public final static String USER_ROLE_IN_EACH_REGION_XPATH = "//div[@class='form-group']/div/label[text()='%s']/../p";
    public final static String UNREGISTER_SECTION_TITLE_XPATH = "//div[@class='row unregister']//p";
    public final static String DEACTIVATE_BUTTON_XPATH = "//button[@data-target='#deactivate-my-account-modal']";
    public final static String DEACTIVATE_ACTION_DESCRIPTION_XPATH = DEACTIVATE_BUTTON_XPATH + "/../../div[1]";
    private final static String DEACTIVATE_MY_ACCOUNT_FORM_XPATH = "//form[@class='deactivate-my-account-form']";
    public final static String CONFIRMATION_TEXT_DEACTIVATE_ACTION_POP_UP_XPATH = DEACTIVATE_MY_ACCOUNT_FORM_XPATH + "//span[@class='warning-text']";
    public final static String CONFIRMATION2_TEXT_DEACTIVATE_ACTION_POP_UP_XPATH = DEACTIVATE_MY_ACCOUNT_FORM_XPATH + "//div[@class='icheckbox_minimal-purple']/..";
    public final static String CHECKBOX_DEACTIVATE_ACTION_POP_UP_XPATH = DEACTIVATE_MY_ACCOUNT_FORM_XPATH + "//div[@class='icheckbox_minimal-purple']/ins";
    public final static String DEACTIVATE_MY_USER_ID_XPATH = "//button[@id='deactivate-my-account']";
    public final static String PERMANENTLY_DELETE_MY_USER_ID_XPATH = "//button[@data-target='#delete-my-account-modal']";
    public final static String CHECKBOX_PERMANENTLY_DELETE_ACTION_POP_UP_XPATH = "//div[@id='delete-my-account-modal']//div[@class='icheckbox_minimal-purple']";
    public final static String CONFIRM_PERMANENTLY_DELETE_ACTION_BUTTON_IN_POP_UP_ID = "delete-my-account";
}

