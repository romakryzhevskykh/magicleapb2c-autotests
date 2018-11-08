package com.magicleap.storefront.page_block_elements;

public class MiniCartSidebarBlockElements {
    public static final String MINI_CART_SIDEBAR_XPATH = "//aside[@class='cart-section']";
    public static final String MINI_CART_TITLE_XPATH = MINI_CART_SIDEBAR_XPATH + "//div[@class='section-title']";
    public static final String MINI_CART_CLOSE_BUTTON_XPATH = MINI_CART_SIDEBAR_XPATH + "//a[@class='close']";
    public static final String VIEW_CART_BUTTON_XPATH = MINI_CART_SIDEBAR_XPATH + "//a[@class='btn-gray']";
    public static final String CONTINUE_SHOPPING_BUTTON_XPATH = "//a[contains(@class, 'js-mini-cart-close-button')]";
    public static final String CONTENT_BLOCK_TEXT_XPATH = MINI_CART_SIDEBAR_XPATH + "//div[@class='callout-block']";
    public static final String CART_EMPTY_TEXT_XPATH = MINI_CART_SIDEBAR_XPATH + "//div[@class='no-records']";
    public static final String MINI_CART_IMAGES_XPATH = MINI_CART_SIDEBAR_XPATH + "//div[@class='cart-info-item']//a[@class='info-item-img']";
    public static final String CART_POP_UP_BANNER_IMAGE_XPATH = "//div[@id = 'cboxLoadedContent']//div[contains(@class,'banner__component')]/img[@src[(string())]]";
}