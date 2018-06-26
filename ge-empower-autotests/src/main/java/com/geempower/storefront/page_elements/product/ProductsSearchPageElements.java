package com.geempower.storefront.page_elements.product;

public class ProductsSearchPageElements {
    public final static String SEARCH_RESULT_TITLE_XPATH = "//div[@class='results-filter-wrapper catalog-results-filter-wrapper']//h3";
    public final static String ALTERNATE_CAT_NO_XPATH = ".//th[@name ='alter-numb-column']";
    public final static String PRODUCT_LINK_ON_PRODUCT_SEARCH_PAGE_XPATH = ".//td[contains(@class,'table-visible-lg-block sorting')]//a[@data-product-number = '%s']";
    public final static String ALL_PRODUCTS_CHECKBOX_ON_PRODUCT_SEARCH_PAGE_XPATH = ".//*[@id='DataTables_Table_0']/thead//ins";
    public final static String APPROPRIATE_PRODUCT_CHECKBOX_ON_PRODUCT_SEARCH_PAGE_XPATH = ".//td[contains(@class,'table-visible-lg-block sorting')]//a[@data-product-number = '%s']/../../td[1]//ins";
    public final static String SAVE_TO_LIST_BUTTON_ON_PRODUCT_SEARCH_PAGE_XPATH = ".//button[@data-target='#product-save-list-modal']";
    public final static String SAVE_TO_LIST_POP_UP_ON_PRODUCT_SEARCH_PAGE_XPATH = ".//div[@id='product-save-list-modal']//div[@class ='modal-content']";
    public final static String GET_P_AND_A_BUTTON_ON_PRODUCT_SEARCH_PAGE_XPATH = ".//button[@class='btn primary-btn getprice']";
    public final static String ADD_TO_CART_BUTTON_ON_PRODUCT_SEARCH_PAGE_XPATH = ".//button[@class='btn primary-btn add-product-to-cart-btn']";

    public final static String NEW_LIST_FIELD_IN_SAVE_LIST_POP_UP_XPATH = ".//input[@class='form-control new-list-input']";
    public final static String SAVE_NEW_LIST_BUTTON_IN_SAVE_LIST_POP_UP_XPATH = ".//button[@class='btn primary-btn save-list-btn']";
}
