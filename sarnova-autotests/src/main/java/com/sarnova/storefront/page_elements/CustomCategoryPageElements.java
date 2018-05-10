package com.sarnova.storefront.page_elements;

public class CustomCategoryPageElements {
    public static final String CATEGORIES_TREE_XPATH = "//div[@id='categoryTreeView']";
    public static final String NEW_CUSTOM_CATEGORY_NAME_FIELD_ID = "rootCategoryName";
    public static final String ADD_NEW_CUSTOM_CATEGORY_BUTTON_ID = "rootCategoryAddBtn";
    public static final String PARENT_CATEGORY_ITEM_BY_ID_XPATH = CATEGORIES_TREE_XPATH + "/div[@class='expanded_panel' and @id='%s']";
    public static final String REMOVE_PARENT_CATEGORY_BUTTON_BY_ID_ID = "removeCustomCategory-%s";
    public static final String ADD_CHILD_TO_PARENT_CATEGORY_BUTTON_BY_ID_ID = "addCustomSubCategory-%s";
    public static final String ADD_CHILD_TO_PARENT_CATEGORY_TEXT_FIELD_BY_ID_ID = "text-%s";
    public static final String CHILD_CATEGORY_BLOCK_BY_ID_XPATH = CATEGORIES_TREE_XPATH + "//div[@class='expanded_content']/div[@id='%s']";
    public static final String SHOW_CHILD_CATEGORY_BY_ID_XPATH = CHILD_CATEGORY_BLOCK_BY_ID_XPATH + "/a";
    public static final String REMOVE_CHILD_CATEGORY_BUTTON_BY_ID_ID = "removeCustomSubCategory-%s";
    public static final String PRODUCTS_BLOCK_XPATH = "//div[@id='productListWithCustomCategory']";
    public static final String PRODUCTS_ROWS_XPATH = PRODUCTS_BLOCK_XPATH + "//div[@class='row product']";
    public static final String REMOVE_PRODUCT_FROM_CATEGORY_BY_PRODUCT_ID_BUTTON_XPATH = PRODUCTS_ROWS_XPATH + "[@id='%s']//input[@class='productCategoryCheckBox']";

    public static final String ADD_ITEMS_BUTTON_ID = "add-products";
}
