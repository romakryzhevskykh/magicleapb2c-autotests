package com.sarnova.storefront.page_elements;

public class QuickOrderPageElements {
    public static final String ADD_TO_SUPPLY_LIST_BUTTONS_XPATH = "//button[contains(@class, 'add-to-supply-list')]";
    public static final String ADD_TO_CART_BUTTONS_XPATH = "//button[contains(@id, 'add-to-cart')]";
    public static final String RESET_FORM_BUTTONS_XPATH = "//button[contains(@id, 'reset-quick-order')]";

    private static final String QUICK_ORDER_TABLE_XPATH = "//div[contains(@class, 'quick-order-form-component')]";
    public static final String EMPTY_PRODUCTS_SKU_ROW_XPATH = QUICK_ORDER_TABLE_XPATH + "//li[contains(@class,'item__list--ite')][div/input[@class='js-hidden-sku-field'][not(@value)]]//input[@placeholder='Enter SKU']";
    public static final String QTY_FIELDS_XPATH = QUICK_ORDER_TABLE_XPATH + "//li[contains(@class,'item__list--item')]//div[contains(@class,'qty-selector')]//input[@type='text'][@data-product-code][@data-unit]";


}
