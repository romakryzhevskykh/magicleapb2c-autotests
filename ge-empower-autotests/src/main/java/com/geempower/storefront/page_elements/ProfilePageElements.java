package com.geempower.storefront.page_elements;

public class ProfilePageElements {
    public final static String PROFILE_TITLE_XPATH = ".//*[@id='page']/div[1]/header/section[2]/div/p";
    public final static String USER_FIRST_NAME_XPATH = "//label[contains(.,'First Name')]/following::p[1]";
    public final static String USER_LAST_NAME_XPATH = "//label[contains(.,'Last Name')]/following::p[1]";
    public final static String USER_ROLE_IN_EACH_REGION_XPATH = "//div[@class='form-group']/div/label[text()='%s']/../p";
}
