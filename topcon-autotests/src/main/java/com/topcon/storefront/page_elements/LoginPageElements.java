package com.topcon.storefront.page_elements;

public class LoginPageElements {
    private static final String LOG_IN_FORM_XPATH = "//form[@id='loginForm']";
    public static final String USERNAME_FIELD_XPATH = LOG_IN_FORM_XPATH + "//input[@id='j_username']";
    public static final String PASSWORD_FIELD_XPATH = LOG_IN_FORM_XPATH + "//input[@id='j_password']";
    public static final String LOG_IN_BUTTON_XPATH = LOG_IN_FORM_XPATH + "//button";
}
