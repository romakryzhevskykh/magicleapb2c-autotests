package com.geempower.storefront.page_block_elements;

public class HeaderBlockElements {
    public final static String PROFILE_DROPDOWN_XPATH = "//li[@class='dropdown user-profile']";
    public final static String CART_COUNT_ICON_XPATH = ".//span[@class='badge cart-count']";
    public final static String GREEN_CONFIRMATION_POP_UP_ID = "toast-container";
    public final static String CART_ICON_XPATH = "//span[@class='badge cart-count']";
    public final static String LINE_ITEMS_VALUE_XPATH = "//p[contains(@class,'cart-total-lines')]";
    public final static String ORDER_VALUE_XPATH = ".//p[contains(@class,'cart-total-price')]";
    public final static String CHECKOUT_BUTTON_XPATH = ".//p[contains(@class,'cart-total-price')]";
    public final static String PRODUCT_SEARCH_FIELD_XPATH = ".//input[@name = 'product']";
    public final static String PRODUCT_SEARCH_ICON_ID = "searchProductBut";
    //main menu
    public final static String MENU_SECTION_XPATH = "//li/a[text()='%s']";
    public final static String POST_SALES_SECTION_XPATH = "//div[text()[contains(.,'Post Sales')]]";
    public final static String EXPAND_POST_SALES_SECTION_XPATH = POST_SALES_SECTION_XPATH + "/b";
    public final static String RETURNS_SECTION_XPATH = "//ul[@class='dropdown-menu dropdown-list']/li/a[text()='Returns']";
}
