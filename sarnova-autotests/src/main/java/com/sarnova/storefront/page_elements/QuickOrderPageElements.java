package com.sarnova.storefront.page_elements;

public class QuickOrderPageElements {
    public static final String POP_UP_ID = "cboxLoadedContent";

    public static final String ADD_TO_SUPPLY_LIST_BUTTONS_XPATH = "//button[contains(@class, 'add-to-supply-list')]";
    public static final String ADD_TO_CART_BUTTONS_XPATH = "//button[contains(@id, 'add-to-cart')]";
    public static final String RESET_FORM_BUTTONS_XPATH = "//button[contains(@id, 'reset-quick-order')]";

    private static final String QUICK_ORDER_TABLE_XPATH = "//div[contains(@class, 'quick-order-form-component')]";
    public static final String QUICK_ADD_ROW_XPATH = QUICK_ORDER_TABLE_XPATH + "//li[contains(@class,'item__list--ite')]";
    public static final String QUICK_ADD_ROW_BY_NUMBER_XPATH = QUICK_ADD_ROW_XPATH + "[%s]";
    public static final String QUICK_ADD_ROW_TEXT_FIELD_BY_NUMBER_XPATH = QUICK_ADD_ROW_BY_NUMBER_XPATH + "//input[@type='text']";
    public static final String QUICK_ADD_ROW_ERROR_TEXT_BY_ROW_NUMBER_XPATH = QUICK_ADD_ROW_BY_NUMBER_XPATH + "//div[contains(@class, 'js-sku-validation-container')]";
    public static final String EMPTY_PRODUCTS_SKU_ROW_XPATH = QUICK_ADD_ROW_XPATH + "[div/input[@class='js-hidden-sku-field'][not(@value) or @value='']]//input[@placeholder='Enter SKU']";
    public static final String QTY_FIELDS_XPATH = QUICK_ORDER_TABLE_XPATH + "//li[contains(@class,'item__list--item')]//div[contains(@class,'qty-selector')]/input[@type='text'][@data-product-code][@data-unit]";
    public static final String QTY_FIELD_BY_SKU_AND_UOM_XPATH = QUICK_ORDER_TABLE_XPATH + "//li[contains(@class,'item__list--item')]//div[contains(@class,'qty-selector')]/input[@type='text'][@data-product-code='%s'][@data-unit='%s']";
    public static final String MINUS_BUTTON_BY_SKU_AND_UOM_XPATH = QUICK_ORDER_TABLE_XPATH + "//li[contains(@class,'item__list--item')]//div[contains(@class,'qty-selector')][input[@type='text'][@data-product-code='%s'][@data-unit='%s']]//button[contains(@class,'dec-quantity')]";
    public static final String PLUS_BUTTON_BY_SKU_AND_UOM_XPATH = QUICK_ORDER_TABLE_XPATH + "//li[contains(@class,'item__list--item')]//div[contains(@class,'qty-selector')][input[@type='text'][@data-product-code='%s'][@data-unit='%s']]//button[contains(@class,'inc-quantity')]";
}
