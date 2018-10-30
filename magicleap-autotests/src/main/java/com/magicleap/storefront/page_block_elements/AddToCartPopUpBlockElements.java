package com.magicleap.storefront.page_block_elements;

public class AddToCartPopUpBlockElements {
    public static final String POP_UP_ID = "cboxLoadedContent";
    public static final String CHECKOUT_BUTTON_XPATH = "//a[contains(@class, 'add-to-cart-button')]";
    public static final String CONTINUE_SHOPPING_BUTTON_XPATH = "//a[contains(@class, 'js-mini-cart-close-button')]";
    public static final String CONTENT_MESSAGE_TEXT_XPATH = "//div[@id = 'cboxLoadedContent']//div[@class='cart_popup_error_msg']";
    public static final String CART_POP_UP_IMAGES_XPATH = "//div[@id='colorbox']//ol[@class='mini-cart-list']//img";
    public static final String CART_POP_UP_BANNER_IMAGE_XPATH = "//div[@id = 'cboxLoadedContent']//div[contains(@class,'banner__component')]/img[@src[(string())]]";
}