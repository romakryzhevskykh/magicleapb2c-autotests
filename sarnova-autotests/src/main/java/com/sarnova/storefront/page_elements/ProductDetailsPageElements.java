package com.sarnova.storefront.page_elements;

public class ProductDetailsPageElements {

    public static final String MAIN_PAGE_CONTAINER_XPATH = "//div[contains(@class,'product-image-container')][img[@class='lazyOwl']]";
    public static final String MAIN_IMAGE_XPATH = MAIN_PAGE_CONTAINER_XPATH + "//img[@class='lazyOwl']";

    public static final String POP_UP_ID = "cboxLoadedContent";

    public static final String ADD_TO_SUPPLY_LIST_BUTTONS_XPATH = "//button[contains(@class, 'js-add-to-supply-list-pdp')]";
    public static final String ADD_TO_CART_BUTTONS_XPATH = "//button[contains(@class, 'js-add-to-cart')]";
    public static final String QTY_FIELD_BY_SKU_AND_UOM_TYPE_XPATH = ".//div[contains(@class,'qty-selector')][input[@value='%s'] and input[@value='%s']]/input[contains(@class,'js-qty-selector-input')]";
}
