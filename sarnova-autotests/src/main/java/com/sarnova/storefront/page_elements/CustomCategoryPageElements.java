package com.sarnova.storefront.page_elements;

public class CustomCategoryPageElements {
    public static final String CATEGORIES_TREE_XPATH = "//div[@class='col-xs-3 left-content']";
    public static final String NEW_CUSTOM_CATEGORY_NAME_FIELD_XPATH = "//input[@class='cat-item-input js-cat-add']";
    public static final String ADD_NEW_CUSTOM_CATEGORY_BUTTON_XPATH = "//span[@class='cat-item-icon js-cat-add']";
    public static final String MANAGE_EXISTING_PRODUCTS_ITEM_XPATH = CATEGORIES_TREE_XPATH + "//div[@class='cat-menu-container' and not(@data-category-code)]";
    public static final String OPEN_MANAGE_EXISTING_PRODUCTS_BLOCK_XPATH = MANAGE_EXISTING_PRODUCTS_ITEM_XPATH + "//span[@class='cat-item-icon']";
    public static final String PARENT_CATEGORY_ITEM_BY_ID_XPATH = CATEGORIES_TREE_XPATH + "//div[@class='cat-menu-container menu-item' and @data-category-code='%s']";
    public static final String REMOVE_PARENT_CATEGORY_BUTTON_BY_ID_XPATH = PARENT_CATEGORY_ITEM_BY_ID_XPATH + "//span[@class='cat-item-icon-hover js-cat-delete']";
    public static final String EXPAND_PARENT_CATEGORY_ARROW_XPATH = PARENT_CATEGORY_ITEM_BY_ID_XPATH + "//span[@data-toggle='collapse']";
    public static final String CHILDS_BLOCK_BY_PARENT_ID_XPATH = "//div[@id='custom-subcategory-menu-%s']";
    public static final String ADD_CHILD_BLOCK_BY_PARENT_ID_XPATH = CHILDS_BLOCK_BY_PARENT_ID_XPATH + "/div[@class='subcat-menu-item menu-item subcat-add']";

    public static final String ADD_CHILD_TO_PARENT_CATEGORY_BUTTON_BY_ID_XPATH = PARENT_CATEGORY_ITEM_BY_ID_XPATH + "//span[@class='subcat-item-icon js-subcat-add']";
    public static final String ADD_CHILD_TO_PARENT_CATEGORY_TEXT_FIELD_BY_ID_XPATH = PARENT_CATEGORY_ITEM_BY_ID_XPATH + "//input[@class='subcat-item-input js-subcat-add']";
    public static final String CHILD_CATEGORY_BLOCK_BY_ID_XPATH = CATEGORIES_TREE_XPATH + "//div[@data-category-code='%s']";
    public static final String SHOW_CHILD_CATEGORY_BY_ID_XPATH = CHILD_CATEGORY_BLOCK_BY_ID_XPATH + "/span[@class='subcat-item-title js-subcat-title-span']";
    public static final String REMOVE_CHILD_CATEGORY_BUTTON_BY_ID_XPATH = CHILD_CATEGORY_BLOCK_BY_ID_XPATH + "/span[@class='subcat-item-icon js-subcat-delete']";

    public static final String PRODUCTS_BLOCK_XPATH = "//div[@id='productListWithCustomCategory']";
    public static final String PRODUCTS_ROWS_XPATH = PRODUCTS_BLOCK_XPATH + "/ul/li[@class='product-listing-item nav']";
    public static final String REMOVE_PRODUCT_FROM_CATEGORY_BY_PRODUCT_ID_BUTTON_XPATH = PRODUCTS_ROWS_XPATH + "[@data-product-code='%s']//span[@class='glyphicon glyphicon-remove']";

    public static final String QUICK_ADD_BLOCK_XPATH = "//div[@id='quickAddContainer']";
    public static final String TOGGLE_QUICK_ADD_CHECKBOX_ID = "toggleQuickAdd";
}
