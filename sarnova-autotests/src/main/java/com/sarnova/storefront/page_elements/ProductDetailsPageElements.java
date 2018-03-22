package com.sarnova.storefront.page_elements;

public class ProductDetailsPageElements {

    public static final String MAIN_PAGE_CONTAINER_XPATH = "//div[contains(@class,'product-image-container')][img[@class='lazyOwl']]";
    public static final String MAIN_IMAGE_XPATH = MAIN_PAGE_CONTAINER_XPATH + "//img[@class='lazyOwl']";

    public static final String POP_UP_ID = "cboxLoadedContent";
    public static final String SUPPLY_POP_UP_IMAGES_XPATH = "//div[@id='colorbox']//img";

    public static final String ADD_TO_SUPPLY_LIST_BUTTONS_XPATH = "//button[contains(@class, 'js-add-to-supply-list-pdp')]";
    public static final String ADD_TO_CART_BUTTONS_XPATH = "//button[contains(@class, 'js-add-to-cart')]";

    public static final String PRODUCT_ROW_BY_SKU_XPATH = "//li[@class = 'product-listing-item nav' and div[@class='clearfix']/div[contains(@class,'product-action-button')][@data-product-code='%s']]";
    public static final String UOM_ROW_BY_SKU_AND_UOM_TYPE_XPATH = PRODUCT_ROW_BY_SKU_XPATH + "//div[@class='product-price-unit-row' and div[@class='unit-data']/span[@class='unit-code' and text()='%s']]";
    public static final String QTY_FIELD_BY_SKU_AND_UOM_TYPE_XPATH = UOM_ROW_BY_SKU_AND_UOM_TYPE_XPATH + "/div[@class='qty-data']//input[@type='text']";
}
