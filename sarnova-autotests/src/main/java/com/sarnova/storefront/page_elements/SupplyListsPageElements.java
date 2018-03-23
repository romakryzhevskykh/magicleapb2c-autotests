package com.sarnova.storefront.page_elements;

public class SupplyListsPageElements {

    public static final String SHOW_INACTIVE_ENTRIES_CHECKBOX_XPATH = "//input[@class='js-toggle-show-inactive-supply-lists']";
    public static final String INACTIVE_SUPPLY_LISTS_BLOCK_XPATH = "//div[@id='inactiveListContainer']";
    public static final String INACTIVE_SUPPLY_LISTS_ITEMS_XPATH = INACTIVE_SUPPLY_LISTS_BLOCK_XPATH + "//table[@class='responsive-table']//tr[@class='responsive-table-item']";
    public static final String INACTIVE_SUPPLY_LISTS_NAMES_XPATH = INACTIVE_SUPPLY_LISTS_ITEMS_XPATH + "//a[contains(@class,'js-saved-cart-name')]";

    public static final String ACTIVE_SUPPLY_LISTS_BLOCK_XPATH = "//div[@id='activeListContainer']";
    public static final String ACTIVE_SUPPLY_LISTS_ITEMS_XPATH = ACTIVE_SUPPLY_LISTS_BLOCK_XPATH + "//table[@class='responsive-table']//tr[@class='responsive-table-item']";
    public static final String ACTIVE_SUPPLY_LISTS_NAMES_XPATH = ACTIVE_SUPPLY_LISTS_ITEMS_XPATH + "//a[contains(@class,'js-saved-cart-name')]";

    public static final String IS_FAVORITE_SUPPLY_LIST_CHECKBOX_BY_ID_XPATH = "//input[@type='checkbox' and @class = 'js-savedlist-favorite-checkbox' and @data-saved-list-code = '%s']";
    public static final String DEACTIVATE_SUPPLY_LIST_BUTTON_BY_ID_XPATH = "//a[@class = 'js-delete-saved-list remove-item-link' and @data-savedlist-id = '%s']";
}
