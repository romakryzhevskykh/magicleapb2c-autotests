package com.sarnova.storefront.page_elements;

public class SupplyListDetailsPageElements {

    public static final String SUPPLY_LIST_NAME_ID = "wishlist-name";

    private static final String SUPPLY_LIST_HEADER_XPATH = "//div[@class = 'well well-tertiary well-lg']";
    public static final String SUPPLY_LIST_ACTIVE_STATUS_XPATH = SUPPLY_LIST_HEADER_XPATH + "//div[@class = 'col-sm-4 item-wrapper']/div/span[3]//span";

    public static final String SUPPLY_PRODUCTS_ROWS_XPATH = "//ul[@class = 'item__list']/table/tbody/tr/td";
}
