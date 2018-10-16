package com.sarnova.storefront.page_elements;

public class CartPageElements {
    private static final String PAGE_CONTENT_CONTAINER_XPATH = "//div[@class='page-content-container']";

    private static final String PRODUCTS_ROWS_BLOCK_XPATH = "//ul[@class='item__list item__list__cart table-sorting']";
    public static final String PRODUCTS_ROWS_XPATH = PRODUCTS_ROWS_BLOCK_XPATH + "//table/tbody/tr/td/li[@class='item__list--item']";
    public static final String UOM_ROW_BY_SKU_AND_UOM_TYPE_XPATH = PRODUCTS_ROWS_XPATH + "[div[@class='item__info']/div[@class='item__code product-article'][.='Item #: %s'] and div[@class= 'item__unit'][contains(., '%s')]]";
    public static final String UOM_QTY_BY_SKU_AND_UOM_TYPE_XPATH = UOM_ROW_BY_SKU_AND_UOM_TYPE_XPATH + "//input[@name = 'initialQuantity']";
    public static final String ADD_UOM_TO_SUPPLY_LIST_BUTTON_BY_SKU_AND_UOM_TYPE_XPATH = UOM_ROW_BY_SKU_AND_UOM_TYPE_XPATH + "//button[contains(@class,'js-add-to-wishlist')]";
    public static final String CHECKOUT_BUTTONS_XPATH = "//button[contains(@class, 'btn--continue-checkout')]";
    public static final String ADD_TO_SUPPLY_LIST_BUTTONS_XPATH = "//div[contains(@class,'cart-actions-bottom')]//button[contains(@class,'js-add-to-wishlist')]";
    public static final String SAVE_CART_BUTTON_XPATH = "//button[contains(@class, 'js-save-cart-link')]";
    public static final String SAVED_CARTS_BUTTON_XPATH = PAGE_CONTENT_CONTAINER_XPATH + "//a[@href='/my-account/saved-carts']";
    public static final String SUBMIT_PURCHASE_REQUEST_BUTTON_XPATH = "//button[contains(@class,'btn btn-secondary js-continue-checkout-button js-enable-btn')]";;
}
