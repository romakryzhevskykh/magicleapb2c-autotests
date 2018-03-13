package com.sarnova.storefront.page_elements;

public class CartPageElements {

    private static final String PRODUCTS_ROWS_BLOCK_XPATH = "//ul[@class='item__list item__list__cart']";
    public static final String PRODUCTS_ROWS_XPATH = PRODUCTS_ROWS_BLOCK_XPATH + "/table/tbody/tr/td/li[@class='item__list--item']";
    public static final String UOM_ROW_BY_SKU_AND_UOM_TYPE_XPATH = PRODUCTS_ROWS_XPATH + "[div[@class='item__info']/div[@class='item__code'][.='%s'] and div[@class= 'item__unit'][contains(., '%s')]]";
    public static final String UOM_QTY_BY_SKU_AND_UOM_TYPE_XPATH = UOM_ROW_BY_SKU_AND_UOM_TYPE_XPATH + "//input[@name = 'initialQuantity']";
    public static final String ADD_UOM_TO_SUPPLY_LIST_BUTTON_BY_SKU_AND_UOM_TYPE_XPATH = UOM_ROW_BY_SKU_AND_UOM_TYPE_XPATH + "//button[contains(@class,'js-add-to-wishlist')]";

    public static final String CHECKOUT_BUTTONS_XPATH = "//button[contains(@class, 'btn--continue-checkout')]";
    public static final String ADD_TO_SUPPLY_LIST_BUTTONS_XPATH = "//div[contains(@class,'cart-actions')]//button[contains(@class,'js-add-to-wishlist')]";

}
