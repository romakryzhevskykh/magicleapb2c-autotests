package com.geempower.storefront.page_elements;

public class AccountManagementPageElements {

    public final static String CANCEL_BUTTON_XPATH = ".//*[@class='btn btn-white']";
    public final static String REGION_COMBOBOX_XPATH = ".//*[@id='select2-region-container']";
    public final static String APPROPRIATE_REGION_BY_NAME_XPATH = ".//ul[@class='select2-results__options']/li[text()='%s']";
    public final static String SEARCH_FIELD_XPATH = ".//input[@id='searchAccount']";
    public final static String SEARCH_BUTTON_XPATH = ".//button[.='Search'and@class='btn primary-btn account-search-btn']";
    public final static String FIRST_ACCOUNT_FROM_LIST_OF_ACCOUNTS_XPATH = ".//div[@id='recently-viewed']//tr[@class='odd'or@class='even']/*[2]/a";

}
