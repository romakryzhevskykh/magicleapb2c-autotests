package com.template.helpers.managers.constants;

public class CartXSoupElements {

    public static final String PRODUCT_ITEMS_IN_CART_XSOUPPATH = "//ul[@class*=item__list__cart]//li[@class*=item__list--item]";
    public static final String PRODUCT_ITEMS_ID_XSOUPPATH = "//div[@class=item__info]/div[@class=item__code]/text()";
    public static final String PRODUCT_ITEMS_QTY_XSOUPPATH = "//input[@name=initialQuantity]";
    public static final String PRODUCT_ENTRY_XSOUPPATH = "//li[@data-entry-action=REMOVE and @data-entry-product-code=%s]";
}
