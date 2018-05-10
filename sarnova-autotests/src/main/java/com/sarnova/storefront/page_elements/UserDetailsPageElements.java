package com.sarnova.storefront.page_elements;

public class UserDetailsPageElements {
    private final static String ACCOUNT_SECTION_XPATH = "//div[@class='account-section-content']";
    private final static String GENERAL_USER_INFO_XPATH = ACCOUNT_SECTION_XPATH + "/div[contains(@class,'well-tertiary')]";
    public final static String USERNAME_FIELD_VALUE_XPATH = GENERAL_USER_INFO_XPATH + "//div[@class='col-sm-4'][1]/div[@class='item-group'][1]/span[@class='item-value']";
    public final static String EMAIL_FIELD_VALUE_XPATH = GENERAL_USER_INFO_XPATH + "//div[@class='col-sm-4'][1]/div[@class='item-group'][2]/span[@class='item-value']";
//    public final static String ROLES_FIELD_VALUE_XPATH = GENERAL_USER_INFO_XPATH + "//div[@class='col-sm-4'][3]/div[@class='item-group'][1]/span[@class='item-value']";
    public final static String STATUS_FIELD_VALUE_XPATH = GENERAL_USER_INFO_XPATH + "//div[@class='col-sm-4'][3]/div[@class='item-group'][1]/span[@class='item-value']";
    public final static String NAME_FIELD_VALUE_XPATH = GENERAL_USER_INFO_XPATH + "//div[@class='col-sm-4'][2]/div[@class='item-group'][1]/span[@class='item-value']";

    private final static String EDIT_USER_BUTTONS_XPATH = ACCOUNT_SECTION_XPATH + "/div[@class='accountActions-link']";
    public final static String RESET_PASSWORD_BUTTON_XPATH = EDIT_USER_BUTTONS_XPATH + "//a[contains(.,'Reset Password')]";
}
