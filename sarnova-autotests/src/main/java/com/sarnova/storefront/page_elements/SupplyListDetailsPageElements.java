package com.sarnova.storefront.page_elements;

public class SupplyListDetailsPageElements {

    public static final String SUPPLY_LIST_NAME_ID = "wishlist-name";

    private static final String SUPPLY_LIST_HEADER_XPATH = "//div[@class = 'well well-tertiary well-lg']";
    public static final String SUPPLY_LIST_ACTIVE_STATUS_XPATH = SUPPLY_LIST_HEADER_XPATH + "//div[@class = 'col-sm-4 item-wrapper']/div/span[3]//span";
    public static final String SUPPLY_LIST_ID_VALUE_XPATH = SUPPLY_LIST_HEADER_XPATH + "//div[@class = 'col-sm-2 item-wrapper']//span[@class = 'item-value']";
    public static final String ADD_TO_CART_BUTTON_XPATH = "//button[contains(@id,'addGroupToCartButtonTop')]";

    private static final String ACTIVE_PRODUCTS_BLOCK_XPATH = "//div[@id='activeEntriesSection']";
    private static final String INACTIVE_PRODUCTS_BLOCK_XPATH = "//div[@id='inactiveEntriesSection']";
    public static final String SUPPLY_PRODUCTS_ROWS_XPATH = "//li[@class = 'product-listing-item nav']";
    public static final String ACTIVE_PRODUCTS_ROWS_XPATH = ACTIVE_PRODUCTS_BLOCK_XPATH + SUPPLY_PRODUCTS_ROWS_XPATH;
    public static final String INACTIVE_PRODUCTS_ROWS_XPATH = INACTIVE_PRODUCTS_BLOCK_XPATH + SUPPLY_PRODUCTS_ROWS_XPATH;
//    public static final String SUPPLY_PRODUCTS_SKUS_XPATH = SUPPLY_PRODUCTS_ROWS_XPATH + "//div[@class= 'item__code']";
    public static final String SUPPLY_PRODUCT_ROW_BY_SKU_XPATH = SUPPLY_PRODUCTS_ROWS_XPATH + "[@data-product-code='%s']";
    public static final String UOM_ROW_BY_SKU_AND_UOM_TYPE_XPATH = SUPPLY_PRODUCT_ROW_BY_SKU_XPATH + "//div[@class='product-price-unit-row'][div[@class='unit-data']/span[@class='unit-code' and text()='%s']]";
    public static final String SUPPLY_PRODUCT_ROW_QTY_FIELD_BY_SKU_AND_UOM_TYPE_XPATH = UOM_ROW_BY_SKU_AND_UOM_TYPE_XPATH + "//input[contains(@class, 'js-qty-selector-input')]";
}
