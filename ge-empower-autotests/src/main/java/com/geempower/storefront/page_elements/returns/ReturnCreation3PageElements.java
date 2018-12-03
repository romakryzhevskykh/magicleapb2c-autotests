package com.geempower.storefront.page_elements.returns;

public class ReturnCreation3PageElements {
    public final static String ADDITIONAL_INFORMATION_ACTIVE_TITLE_XPATH = ".//li[@class='return-additional-info active']";
    public final static String ADDITIONAL_INFORMATION_BUTTON_XPATH = "//td[@class='create-reason-request-col ']//i[@class='info-icon']";
    public final static String ADDITIONAL_INFORMATION_BUTTON_TOOLTIP_XPATH = "//span[@class='return-info-table-flyout-tooltip']";
    private final static String INFO_TABLE_XPATH = "//*[@class='info-table-wrapper visible-lg-block']";
    public final static String COLOR_OF_SHRINK_FIELD_XPATH = INFO_TABLE_XPATH + "//input[@name='colorOfShrinkSharp']";
    public final static String ADDITIONAL_INFO_FIELD_XPATH = INFO_TABLE_XPATH + "//textarea[contains(@name,'AdditionalInformation')]";
    public final static String SAVE_BUTTON_XPATH = INFO_TABLE_XPATH + "//button[@class='btn primary-btn pull-right return-info-flyout-submit']";
    public final static String BOTTOM_NEXT_BUTTON_XPATH = "//*[@class='return-tab-content']//button[@class='btn primary-btn next-button-step3']";
    public final static String REASON_FOR_REQUEST_VALUE_XPATH = ".//td[@class='create-reason-request-col ']/span[1]";
    public final static String REQUESTED_ACTION_VALUE_XPATH = ".//td[@class='create-requested-action-col']";
    public final static String CATALOG_NO_VALUE_XPATH = "//table[@class='table info-table create-return-table create-return-additional-info-table']//td[@class='create-catalog-col']";
    public final static String MESSAGE_FOR_NON_RETURNABLE_PRODUCTS_XPATH = "//div[@class='warning-message catalog-error-message']/span[2]";
    public final static String EXCLAMATION_MARK_FOR_NON_RETURNABLE_PRODUCT_XPATH = "//td[contains(text(),'%s') and @class]//../td//i[@class='fa fa-exclamation-triangle error-mark']";
    public final static String ALL_NON_RETURNABLE_PRODUCTS_REMOVE_ICON_XPATH = "//td[contains(text(),'No') and @class]//../td//i[@class='fas fa-trash']";
    public final static String ALL_CATALOG_NUMBERS_TEXT_XPATH = "//td[@class='create-catalog-col']";
    public final static String ALL_REASONS_FOR_REQUEST_XPATH = "//td[contains(@class,'create-reason-request-col')]";
    public final static String ALL_REQUESTED_ACTION_XPATH = "//td[contains(@class,'create-requested-action')]";
    public final static String ADDITIONAL_INFO_PATH_INPUT_XPATH = "//td[@colspan='7']//label/span//input[@class='upload-file-input']";
    public final static String GREEN_ADDITIONAL_INFO_BUTTON_XPATH = "//div[@class='info-table-wrapper visible-lg-block']//a[@class='return-info-table-flyout'][@style]";
}