package com.template.storefront.page_elements;

public class CartPageElements {
    public static final String CHECKOUT_BUTTON_XPATH = "//button[contains(@class,'continue-checkout-button')]";
    public static final String PRODUCTS_LIST_XPATH = "//ul[@class='item__list item__list__cart']/li[contains(@class,'item')]";
    public static final String PRODUCT_NAME_CLASSNAME = "item__name";
    public static final String PRODUCT_SKU_CLASSNAME = "item__code";
    public static final String ITEM_PRICE_CLASSNAME = "item__price-inline";
    public static final String PRODUCT_SAVINGS_CLASSNAME = "price-savings";
    public static final String PRODUCT_QTY_FIELD_NAME_ATTRIBUTE = "quantity";
    public static final String EXTENDED_PRICE_XPATH = ".//div[@class='item__total js-item-total hidden-xs']";
}
