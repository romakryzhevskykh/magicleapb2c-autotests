package com.sarnova.storefront.page_elements;

public class ProductDetailsPageElements {

    public static final String ADD_TO_SUPPLY_LIST_BUTTONS_XPATH = "//button[contains(@class, 'js-add-to-supply-list-pdp')]";
    public static final String ADD_TO_CART_BUTTONS_XPATH = "//button[contains(@class, 'js-add-to-cart')]";

    public static final String PRODUCT_ROW_BY_SKU_XPATH = "//tr[@class = 'individualProductRow' and td[contains(., '%s')]]";
    public static final String UOM_ROW_BY_SKU_AND_UOM_TYPE_XPATH = PRODUCT_ROW_BY_SKU_XPATH + "/td[2]/table/tbody/tr[td[3][. = '%s']]";
    public static final String QTY_FIELD_BY_SKU_AND_UOM_TYPE_XPATH = UOM_ROW_BY_SKU_AND_UOM_TYPE_XPATH + "//input[contains(@class, 'js-qty-selector-input')]";
}
