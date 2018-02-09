package com.sarnova.storefront.page_elements;

public class ProductDetailsPageElements {

    public static final String ADD_TO_SUPPLY_LIST_BUTTONS_XPATH = "//button[contains(@class, 'js-add-to-supply-list-pdp')]";

    public static final String PRODUCT_ROW_BY_SKU_XPATH = "//tr[@class = 'individualProductRow' and td[contains(., '%s')]]";
    public static final String UOM_ROW_BY_SKU_AND_UOM_TYPE_XPATH = PRODUCT_ROW_BY_SKU_XPATH + "/td[2]/table/tbody/tr[td[3][. = '%s']]";
    public static final String QTY_FIELD_BY_SKU_AND_UOM_TYPE_XPATH = UOM_ROW_BY_SKU_AND_UOM_TYPE_XPATH + "//input[contains(@class, 'js-qty-selector-input')]";

    private static final String ADD_TO_SUPPLY_LIST_POP_UP_XPATH = "//div[@id = 'colorbox']";
    public static final String ADD_TO_SUPPLY_LIST_POP_UP_CONTENT_XPATH = ADD_TO_SUPPLY_LIST_POP_UP_XPATH + "//div[@id = 'cboxLoadedContent']";
    public static final String ADD_TO_SUPPLY_LIST_POP_UP_CREATE_NEW_SUPPLY_LIST_RADIO_BUTTON_XPATH = ADD_TO_SUPPLY_LIST_POP_UP_XPATH + "//div[@class='wishlist-names']//input[@value='newWishlist']";
    public static final String ADD_TO_SUPPLY_LIST_POP_UP_SELECT_SUPPLY_LIST_RADIO_BUTTON_XPATH = ADD_TO_SUPPLY_LIST_POP_UP_XPATH + "//div[@class='wishlist-names']//input[@value='existingWishlist']";
    public static final String ADD_TO_SUPPLY_LIST_POP_UP_EXISTING_LISTS_DROP_DOWN_ID = "selectedWishList";
    public static final String ADD_TO_SUPPLY_LIST_POP_UP_EXISTING_SUPPLY_LISTS_IN_DROP_DOWN_XPATH = "//select[@id = 'selectedWishList']/option[not(@value = 'not-selected')]";
    public static final String ADD_TO_SUPPLY_LIST_POP_UP_EXISTING_SUPPLY_LIST_IN_DROP_DOWN_BY_NAME_XPATH = ADD_TO_SUPPLY_LIST_POP_UP_EXISTING_SUPPLY_LISTS_IN_DROP_DOWN_XPATH + "[.='%s']";
    public static final String ADD_TO_SUPPLY_LIST_POP_UP_NEW_SUPPLY_LIST_NAME_FIELD_ID = "newWishlistName";
    public static final String ADD_TO_SUPPLY_LIST_POP_UP_ADD_TO_SUPPLY_LIST_BUTTON_XPATH = ADD_TO_SUPPLY_LIST_POP_UP_XPATH + "//button[contains(@class, 'add-to-wishlist-popup-button')]";
    public static final String ADD_TO_SUPPLY_LIST_POP_UP_VIEW_SUPPLY_LIST_BUTTON_XPATH = ADD_TO_SUPPLY_LIST_POP_UP_XPATH + "//a[contains(@class, 'wishlist-link')]";
    public static final String ADD_TO_SUPPLY_LIST_POP_UP_CONTINUE_BUTTON_XPATH = ADD_TO_SUPPLY_LIST_POP_UP_XPATH + "//button[contains(@class, 'js-close-popup')]";
}
