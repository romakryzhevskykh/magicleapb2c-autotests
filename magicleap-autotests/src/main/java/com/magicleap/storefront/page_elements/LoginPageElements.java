package com.magicleap.storefront.page_elements;

public class LoginPageElements {
    private static final String LOG_IN_FORM = "//div[@class = 'login']//form";
    public static final String USERNAME_FIELD_XPATH = LOG_IN_FORM + "/input[@placeholder='Email Address']";
    public static final String PASSWORD_FIELD_XPATH = LOG_IN_FORM + "/input[@type='password']";
    public static final String LOG_IN_BUTTON_XPATH = LOG_IN_FORM + "/button";
    public static final String SIGN_UP_BUTTON_XPATH = "//a[@href='#/signup']";
}
