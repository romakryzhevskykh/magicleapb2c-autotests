package com.sarnova.storefront.page_elements;

public class SavedCartsPageElements {
    public final static String HEADER_TITLE_XPATH = "//div[@class='account-section-header']";

    public final static String SAVED_CARTS_TABLE_XPATH = "//div[contains(@class, 'saved__carts__overview--table')]";
    public final static String SAVED_CART_ROW_BY_ID_XPATH = SAVED_CARTS_TABLE_XPATH + "//tbody/tr[td[contains(@class, 'responsive-table-cell')][2][contains(text(), '%s')]]";
    public final static String SAVED_CARTS_IDS_XPATH = SAVED_CARTS_TABLE_XPATH + "//tbody/tr/td[contains(@class, 'responsive-table-cell')][2]";
    public final static String SAVED_CART_REMOVE_BUTTON_BY_ID_XPATH = SAVED_CART_ROW_BY_ID_XPATH + "/td[contains(@class, 'remove-item-column')]/a";
    public final static String SAVED_CART_RESTORE_BUTTON_BY_ID_XPATH = SAVED_CART_ROW_BY_ID_XPATH + "/td[contains(@class, 'restore-item-column')]/a";
}
