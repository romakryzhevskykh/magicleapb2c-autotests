package com.geempower.storefront.page_elements;

public class SavedItemsPageElements {
    public final static String ALL_ITEMS_TITLE_XPATH = ".//*[@id='page']/section/div/div/div/div[1]/div/div[1]/h3";
    public final static String ACTIVE_CART_TABLE_TITLE_XPATH = "//div[@class='revalidation-action-wrapper clearfix']/p";
    public final static String SAVED_ITEMS_TABLE_TITLE_XPATH = "//div[@class='revalidation-action-wrapper mt-20 clearfix']/p";
    public final static String ADD_NEW_LIST_BUTTON_XPATH = "//button[@data-target='#new-list-modal']";
    public final static String NEW_LIST_NAME_FIELD_XPATH = "//input[@class='form-control new-list-input']";
    public final static String ADD_NEW_LIST_BUTTON_IN_NEW_LIST_POP_UP_XPATH = "//button[@class='btn primary-btn add-list-btn']";
    public final static String ASCENDING_SORTING_LISTS_TABLE_BY_CREATION_DATE_XPATH = "//table[@id='savedListTable']//th[@aria-label='Created On: activate to sort column ascending']";
    public final static String DESCENDING_SORTING_LISTS_TABLE_BY_CREATION_DATE_XPATH = "//table[@id='savedListTable']//th[@aria-label='Created On: activate to sort column descending']";
    private final static String FIRST_LIST_FROM_THE_SAVED_LISTS_TABLE_XPATH ="//table[@id='savedListTable']/tbody/tr[1]";
    public final static String NO_DATA_TITLE_IN_SAVED_ITEMS_TABLE_XPATH = FIRST_LIST_FROM_THE_SAVED_LISTS_TABLE_XPATH + "/td";
    public final static String FIRST_LIST_NAME_FROM_THE_SAVED_LISTS_TABLE_XPATH = FIRST_LIST_FROM_THE_SAVED_LISTS_TABLE_XPATH + "/td[1]/a";
    public final static String FIRST_LIST_CREATED_ON_FROM_THE_SAVED_LISTS_TABLE_XPATH = FIRST_LIST_FROM_THE_SAVED_LISTS_TABLE_XPATH + "/td[2]";
    public final static String FIRST_LIST_LAST_EDITED_ON_FROM_THE_SAVED_LISTS_TABLE_XPATH = FIRST_LIST_FROM_THE_SAVED_LISTS_TABLE_XPATH + "/td[3]";
    public final static String FIRST_LIST_NO_OF_ITEMS_FROM_THE_SAVED_LISTS_TABLE_XPATH = FIRST_LIST_FROM_THE_SAVED_LISTS_TABLE_XPATH + "/td[4]";
    public final static String ADD_ITEM_BUTTON_XPATH = ".//button[@data-target='#list-new-item-modal']";
    public final static String ADD_PRODUCT_LIST_FIRST_PRODUCT_NUMBER_INPUT_XPATH = "//ul[@id='addProductList']//input[@name='rows[0].productNo']";
    public final static String ADD_PRODUCT_BUTTON_IN_NEW_ITEM_POP_UP_ID = "addProduct";
    public final static String ADDED_NEW_ITEM_CATALOG_NO_TO_THE_SAVED_LIST_XPATH = "//tbody//a[@class='catalog-name-input modal-toggle product-popup']";
    public final static String EXTENDED_PRICE_OF_ADDED_PRODUCT_XPATH = "//td[@class='data-table-value-col extendedPrice']";
    public final static String GO_BACK_TO_ALL_SAVED_ITEMS_ICON_XPATH = "//a[@class='back-link']/i";
    public final static String THREE_DOT_ICON_XPATH = FIRST_LIST_FROM_THE_SAVED_LISTS_TABLE_XPATH + "/td[5]//i[@class='fa fa-ellipsis-v']";
    public final static String THREE_DOT_ICON_DELETE_OPTION_XPATH = FIRST_LIST_FROM_THE_SAVED_LISTS_TABLE_XPATH + "//td[5]//a[contains(@data-target, 'delete-list-modal')]";
    public final static String DELETE_BUTTON_IN_CONFIRMATION_DELETE_POP_UP_XPATH = "//div[@class='modal fade delete-list-modal in']//button[@class='btn primary-btn delete-list-btn']";
    //SAVED CART
    private final static String SAVED_CART_TABLE_XPATH = "//table[@id='savedCartTable']";
    public final static String SAVED_CART_LIST_OF_NAMES_XPATH =  SAVED_CART_TABLE_XPATH + "//tbody/tr/td[1]/a";
    public final static String SAVED_CART_TABLE_COLUMNS_NAMES_XPATH = SAVED_CART_TABLE_XPATH + "//th[contains(@class,'table-visible-lg-block sorting')]";
    private final static String APPROPRIATE_SAVED_CART_BY_NAME_XPATH = SAVED_CART_TABLE_XPATH + "//tbody/tr/td[1]/a[text()='%s']/../../";
    public final static String APPROPRIATE_SAVED_CART_NAME_VALUE_XPATH = APPROPRIATE_SAVED_CART_BY_NAME_XPATH + "/td[1]/a";
    public final static String APPROPRIATE_SAVED_CART_CREATED_ON_VALUE_XPATH = APPROPRIATE_SAVED_CART_BY_NAME_XPATH + "td[2]";
    public final static String APPROPRIATE_SAVED_CART_CREATED_BY_VALUE_XPATH = APPROPRIATE_SAVED_CART_BY_NAME_XPATH + "td[3]";
    public final static String APPROPRIATE_SAVED_CART_LAST_EDITED_ON_VALUE_XPATH = APPROPRIATE_SAVED_CART_BY_NAME_XPATH + "td[4]";
    public final static String APPROPRIATE_SAVED_CART_NO_OF_ITEMS_VALUE_XPATH = APPROPRIATE_SAVED_CART_BY_NAME_XPATH + "td[5]";
    public final static String THREE_DOT_ICON_SAVED_CART_XPATH = "//tbody//a[text()='%s']/../../td[6]//a[@data-toggle='dropdown']/i";
    public final static String THREE_DOT_ICON_SAVED_CART_DELETE_OPTION_XPATH = "//tbody//a[text()='%s']/../../td[6]//ul[@class='dropdown-menu dropdown-list more-action-dropdown']/li/a";
    public final static String DELETE_BUTTON_IN_CONFIRMATION_DELETE_CART_POP_UP_XPATH = "//button[@class='btn primary-btn delete-cart-btn']";
}