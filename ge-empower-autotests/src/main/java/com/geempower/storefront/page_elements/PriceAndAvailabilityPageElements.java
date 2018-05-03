package com.geempower.storefront.page_elements;

public class PriceAndAvailabilityPageElements {
    public final static String ALL_CHECKBOXES_XPATH = ".//label[contains(@class,'myCheckbox select-all-desk-js')]";
    public final static String ADD_TO_CARD_BUTTON_XPATH = ".//button[@class='btn primary-btn add-to-cart-btn']";
    public final static String DESCRIPTION_FIELD_XPATH = ".//td[@class='product-col']";
    public final static String LIST_PRICE_FIELD_XPATH = ".//td[@class='data-table-value-col listPrice']";
    public final static String FINAL_NET_PRICE_FIELD_XPATH = ".//td[@class='data-table-final-value-col primaryNetPrice']";
    public final static String AVAILABILITY_FIELD_XPATH = "//table[contains(@class, 'price-availability-table')]//tr[contains(@class, 'price-item') and td/a[@data-product = '%s']]/td[contains(@class,'productWrHouse')]";
    public final static String QUANTITY_INPUT_XPATH = "//table[contains(@class, 'price-availability-table')]//tr[contains(@class, 'price-item') and td/a[@data-product = '%s']]/td[contains(@class,'qty-input')]/input";
    public final static String EXTENDED_PRICE_XPATH = "//table[contains(@class, 'price-availability-table')]//tr[contains(@class, 'price-item') and td/a[@data-product = '%s']]/td[contains(@class,'col extendedPrice')]";
    public final static String UPDATE_PRICE_AND_AVAILABILITY_BUTTON_XPATH = "//button[@id='upd_pr_and_av_btn']";
    public final static String CART_COUNT_ICON_XPATH = ".//span[@class='badge cart-count']";
    public final static String CART_ICON_XPATH = "//span[@class='badge cart-count']";
    public final static String LINE_ITEMS_VALUE_XPATH = "//p[contains(@class,'cart-total-lines')]";
    public final static String ORDER_VALUE_XPATH = ".//p[contains(@class,'cart-total-price')]";
    public final static String CHECKOUT_BUTTON_XPATH = ".//p[contains(@class,'cart-total-price')]";
    public final static String PRODUCT_ERROR_MESSAGES_XPATH = "//div[@class='warning-message catalog-error-message mt-10 mb-10']/span[@class='warning-text']";
    public final static String SEARCH_SPA_NO_ICON_XPATH = "//table[@id='priceTable']//tr[1]//td[@class='special-pricing-input-col']//i[@class='fa fa-search']";
    public final static String SEARCH_SPA_NO_INPUT_XPATH = "//div[@class='special-pricing-form-body']//input[@id='searchSpaInp']";
    public final static String SEARCH_SPA_NO_ICON_SPECIAL_PRICING_POP_UP_XPATH = "//div[@class='special-pricing-form-body']//i[@class='fa fa-search']";
    public final static String FIRST_SPA_ON_THE_SPECIAL_PRICING_POP_UP_XPATH = "//table[@id='DataTables_Table_0']/tbody/tr[1]/td[1]";
    public final static String APPLY_TO_ALL_BUTTON_SPECIAL_PRICING_POP_UP_XPATH = "//button[@class='btn primary-btn spl-pricing-apply-all']";
    public final static String SPA_NO_VALUES_FOR_ALL_PRODUCTS_XPATH = "//td[@class='special-pricing-input-col']//input";
    public final static String ADD_ITEM_BUTTON_XPATH = "//button[@class='btn btn-white']";
    public final static String ADD_ITEM_POP_UP_FIRST_PRODUCT_FIELD_XPATH = "//ul[@id='addProductList']/li[1]//input[contains(@name, 'productNo')]";
    public final static String ADD_ITEM_POP_UP_ADD_PRODUCT_BUTTON_XPATH = "//button[@id='addProduct']";
    public final static String UPDATE_PRICE_AND_AVAILABILITY_BUTTON_ID = "upd_pr_and_av_btn";
    public final static String SPECIAL_PRICING_POP_UP_TITLE_XPATH = "//div[@id='special-pricing-lookup-modal']//h4[@class='modal-title']";
}
