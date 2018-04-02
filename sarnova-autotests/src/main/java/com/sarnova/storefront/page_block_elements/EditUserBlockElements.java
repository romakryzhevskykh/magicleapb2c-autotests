package com.sarnova.storefront.page_block_elements;

public class EditUserBlockElements {
    public final static String TITLE_DROP_DOWN_XPATH = "//select[@id = 'user.title']";
    public final static String TITLE_ITEM_IN_DROP_DOWN_BY_NAME_XPATH = TITLE_DROP_DOWN_XPATH + "/option[@value='%s']";
    public final static String FIRST_NAME_FIELD_ID = "user.firstName";
    public final static String LAST_NAME_FIELD_ID = "user.lastName";
    public final static String EMAIL_FIELD_ID = "user.email";
    public final static String ROLE_CHECKBOX_BY_CODE_XPATH = "//input[@name='roles' and @value='%s']";
    public final static String ROLE_CHECKBOXES_XPATH = "//input[@name='roles']";

    public final static String SAVE_BUTTON_XPATH = "//div[@class = 'accountActions-bottom']//button[@type='submit']";

}
