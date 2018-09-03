package com.geempower.storefront.page_elements.rebate;

public class RebatesPageElements {
    public final static String REBATES_TITLE_XPATH = ".//div[@class='return-tracking-section']//h3";
    public final static String CREATE_REBATE_BUTTON_XPATH = "//button[@class='btn back-to-request-rebate btn-white']";
    public final static String REBATE_BY_ID_XPATH = "//div[@class='panel accordion-section']//a[text()='%s']";
    public final static String ALL_REBATES_COUNT_XPATH = "//span[@class='status-number text-bold']";
    public final static String SAVED_CREDIT_REQUEST_TAB_XPATH = "//a[@href='#saved-credit-request']";
    private final static String LAST_SAVED_REBATES_XPATH = "//div[@id='saved-credit-request']//div[@class='panel accordion-section'][last()]";
    public final static String LAST_SAVED_REBATE_NAME_XPATH = LAST_SAVED_REBATES_XPATH + "//span[@class]";
    public final static String EDIT_LAST_SAVED_REQUEST_ICON_XPATH = LAST_SAVED_REBATES_XPATH + "//i[@class='fas fa-pencil-alt']";
    public final static String DELETE_LAST_SAVED_REQUEST_ICON_XPATH = LAST_SAVED_REBATES_XPATH + "//i[@class='fas fa-trash']";
    public final static String CONFIRM_DELETE_ACTION_SAVED_REBATE_BUTTON_XPATH = "//button[@id='submitDeleteRebateDraft']";

}
