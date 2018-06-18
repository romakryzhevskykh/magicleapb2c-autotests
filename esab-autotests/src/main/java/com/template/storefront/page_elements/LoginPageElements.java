package com.template.storefront.page_elements;

public class LoginPageElements {
    private static final String LOG_IN_FORM = "//form[@id='loginForm']";
    public static final String USERNAME_FIELD_XPATH = LOG_IN_FORM + "//input[@id='j_username']";
    public static final String PASSWORD_FIELD_XPATH = LOG_IN_FORM + "//input[@id='j_password']";
    public static final String LOG_IN_BUTTON_XPATH = LOG_IN_FORM + "//button[@type='submit']";
    public static final String REGISTER_BUTTON_XPATH = LOG_IN_FORM + "//button[@type='button']";
    public static final String REGISTRATION_CONFIRMATION_MESSAGE = "//div[@class='global-alerts']/div";
}
