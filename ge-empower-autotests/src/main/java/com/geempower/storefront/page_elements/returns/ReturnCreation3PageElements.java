package com.geempower.storefront.page_elements.returns;

public class ReturnCreation3PageElements {
    public final static String ADDITIONAL_INFORMATION_ACTIVE_TITLE_XPATH = ".//li[@class='return-additional-info active']";
    public final static String ADDITIONAL_INFORMATION_BUTTON_XPATH = ".//td[@class='create-reason-request-col ']//i[@class='info-icon']";

    private final static String INFO_TABLE_XPATH = "//*[@class='info-table-wrapper visible-lg-block']";
    public final static String COLOR_OF_SHRINK_FIELD_XPATH = INFO_TABLE_XPATH + "//input[@name='colorOfShrinkSharp']";
    public final static String ADDITIONAL_INFO_FIELD_XPATH = INFO_TABLE_XPATH + "//textarea[@name='shortageAdditionalInformation']";
    public final static String SAVE_BUTTON_XPATH = INFO_TABLE_XPATH + "//button[@class='btn primary-btn pull-right return-info-flyout-submit']";

    public final static String BOTTOM_NEXT_BUTTON_XPATH = "//*[@class='return-tab-content']//button[@class='btn primary-btn next-button-step3']";
    public final static String REASON_FOR_REQUEST_VALUE_XPATH = ".//td[@class='create-reason-request-col ']/span[1]";
    public final static String REQUESTED_ACTION_VALUE_XPATH = ".//td[@class='create-requested-action-col']";
    public final static String CATALOG_NO_VALUE_XPATH = "//table[@class='table info-table create-return-table create-return-additional-info-table']//td[@class='create-catalog-col']";
}