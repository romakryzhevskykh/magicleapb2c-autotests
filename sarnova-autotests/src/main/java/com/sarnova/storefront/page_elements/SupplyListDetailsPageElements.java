package com.sarnova.storefront.page_elements;

public class SupplyListDetailsPageElements {

    public static final String SUPPLY_LIST_NAME_ID = "wishlist-name";

    private static final String SUPPLY_LIST_HEADER_XPATH = "//div[@class = 'well well-tertiary well-lg']";
    public static final String SUPPLY_LIST_ACTIVE_STATUS_XPATH = SUPPLY_LIST_HEADER_XPATH + "//div[@class = 'col-sm-4 item-wrapper']/div/span[3]//span";
    public static final String SUPPLY_LIST_ID_VALUE_XPATH = SUPPLY_LIST_HEADER_XPATH + "//div[@class = 'col-sm-2 item-wrapper']//span[@class = 'item-value']";
    public static final String ADD_TO_CART_BUTTON_XPATH = "//button[contains(@id,'addGroupToCartButtonTop')]";
    public static final String FAVORITE_CHECKBOX_XPATH = "//input[@class='js-savedlist-favorite-checkbox']";

    public static final String SHOW_INACTIVE_ENTRIES_BUTTON_ID = "toggleInactive";

    public static final String SUPPLY_PRODUCTS_ROWS_XPATH = "//li[@class = 'product-listing-item nav']";
    public static final String SUPPLY_PRODUCT_ROW_BY_SKU_XPATH = SUPPLY_PRODUCTS_ROWS_XPATH + "[@data-product-code='%s']";

    private static final String ACTIVE_PRODUCTS_BLOCK_XPATH = "//div[@id='activeEntriesSection']";
    public static final String ACTIVE_PRODUCTS_ROWS_XPATH = ACTIVE_PRODUCTS_BLOCK_XPATH + SUPPLY_PRODUCTS_ROWS_XPATH;
    public static final String ACTIVE_PRODUCT_ROW_BY_SKU_XPATH = ACTIVE_PRODUCTS_BLOCK_XPATH + SUPPLY_PRODUCT_ROW_BY_SKU_XPATH;
    public static final String ACTIVE_PRODUCT_DEACTIVATE_BUTTON_BY_SKU_XPATH = ACTIVE_PRODUCT_ROW_BY_SKU_XPATH + "//button[span[contains(@class,'remove')]]";
    public static final String ACTIVE_PRODUCTS_BLOCK_TEXT_CONTENT = ACTIVE_PRODUCTS_BLOCK_XPATH + "//div[@class='account-section-content']/span";

    public static final String INACTIVE_PRODUCTS_BLOCK_XPATH = "//div[@id='inactiveEntriesSection']";
    public static final String INACTIVE_PRODUCTS_ROWS_XPATH = INACTIVE_PRODUCTS_BLOCK_XPATH + SUPPLY_PRODUCTS_ROWS_XPATH;
    public static final String INACTIVE_PRODUCT_ROW_BY_SKU_XPATH = INACTIVE_PRODUCTS_BLOCK_XPATH + SUPPLY_PRODUCT_ROW_BY_SKU_XPATH;
    public static final String INACTIVE_PRODUCT_ACTIVATE_BUTTON_BY_SKU_XPATH = INACTIVE_PRODUCT_ROW_BY_SKU_XPATH + "//button[span[contains(@class,'remove')]]";

    public static final String UOM_ROW_BY_SKU_AND_UOM_TYPE_XPATH = SUPPLY_PRODUCT_ROW_BY_SKU_XPATH + "//div[@class='product-price-unit-row'][div[@class='unit-data']/span[@class='unit-code' and text()='%s']]";
    public static final String SUPPLY_PRODUCT_ROW_QTY_FIELD_BY_SKU_AND_UOM_TYPE_XPATH = UOM_ROW_BY_SKU_AND_UOM_TYPE_XPATH + "//input[contains(@class, 'js-qty-selector-input')]";

    public static final String QUICK_ADD_CHECKBOX_ID = "toggleQuickAdd";
    public static final String QUICK_ADD_SUPPLY_LIST_BLOCK_XPATH = "//div[@id='quickAddToSupplyListTable']";
    public static final String QUICK_ADD_ROWS = QUICK_ADD_SUPPLY_LIST_BLOCK_XPATH + "//li[@class='item__list--item js-li-container']";
    public static final String QUICK_ADD_ROW_BY_NUMBER_XPATH = QUICK_ADD_ROWS + "[%s]";
    public static final String QUICK_ADD_ROW_TEXT_FIELD_BY_NUMBER_XPATH = QUICK_ADD_ROW_BY_NUMBER_XPATH + "//input[@type='text']";
    public static final String QUICK_ADD_ROW_ERROR_TEXT_BY_ROW_NUMBER_XPATH = QUICK_ADD_ROW_BY_NUMBER_XPATH + "//div[contains(@class, 'js-sku-validation-container')]";
    public static final String QUICK_ADD_ROW_TEXT_FIELDS_XPATH = QUICK_ADD_ROWS + "//input[@type='text']";
    public static final String QUICK_ADD_TO_THIS_SUPPLY_LIST_BUTTON_XPATH = "//button[@class='btn btn-block btn-default js-add-to-list-btn']";
}
