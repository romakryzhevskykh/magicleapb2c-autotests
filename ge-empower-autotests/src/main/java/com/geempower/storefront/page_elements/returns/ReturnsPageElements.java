package com.geempower.storefront.page_elements.returns;

public class ReturnsPageElements {
    public final static String CASES_TITLE_XPATH = "//div[@class='return-tracking-section']//h3";
    public final static String CREATE_REQUEST_BUTTON_ID = "create_request";
    public final static String SAVED_REQUEST_TAB_XPATH = "//a[@href='#saved-request']";
    public final static String SAVED_REQUEST_TABLE_XPATH = "//div[@id='saved-request']//div[@class='panel accordion-section']";
    public final static String LAST_SAVED_RETURN_NAME_XPATH = "//div[@id='saved-request']//div[@class='panel accordion-section'][last()]//span[@class]";
    public final static String EDIT_ICON_FOR_APPROPRIATE_RETURN_XPATH = "//span[contains (text(), '%s')]/../..//i[@class ='fas fa-pencil-alt']";
    public final static String DELETE_ICON_FOR_APPROPRIATE_RETURN_XPATH = "//span[contains (text(), '%s')]/../..//i[@class ='fas fa-trash']";
    public final static String ALL_RETURNS_QUANTITY_XPATH = "//div[@class='return-status all-returns clearfix']//span[@class='status-number text-bold']";
    public final static String LAST_ADDED_RETURN_XPATH = "//div[@id='accordion-returns-information']/div[1]//span[@class='numRequest text-separator']";
    public final static String ALL_RETURNS_CONFIRM_NO_XPATH = "//span[@id='listName']";
    //ACCESS DENIED PAGE
    public final static String ACCESS_DENIED_TITLE_RETURNS_PAGE_XPATH = "//h1";
    public final static String ACCESS_DENIED_SUB_TITLE_RETURNS_PAGE_XPATH = "//div/span[contains(@class, 'text-center')]";
    public final static String ACCESS_DENIED_GO_HOME_BUTTON_XPATH = "//div[contains(@class,'center')]/a[contains(@class,'btn')]";
}