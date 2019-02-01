package com.geempower.storefront.page_elements;

public class MyCartPageElements {
    public final static String MY_CART_TITLE_XPATH = ".//*[@id='page']/header/section[2]/div/p";
    public final static String ADD_ITEM_BUTTON_XPATH = ".//button[@data-target='#list-new-item-modal']";
    public final static String SAVE_ITEMS_BUTTON_XPATH = ".//button[@data-target='#cart-save-list-modal']";
    public final static String CANCEL_BUTTON_XPATH = ".//button[@data-target='#discard-order-modal']";
    public final static String BUILD_ORDER_TOP_NEXT_BUTTON_XPATH = ".//*[@id='build-order']/div[1]/div[2]/div/ul/button";
    public final static String BUILD_ORDER_BOTTOM_NEXT_BUTTON_XPATH = "//*[@id='build-order']//div[7]/ul/li/button";
    public final static String BUILD_ORDER_STEP_ICON_XPATH = "//*[@class='active build-order']";
    public final static String SHIPPING_BILLING_INFO_STEP_ICON_XPATH = "//*[@class='shipping-billing-info']";
    public final static String ORDER_SUMMARY_STEP_ICON_XPATH = "//*[@class='order-summary']";
    public final static String BUILD_ORDER_INFORMATION_INPUT_ID = "orderNote";
    public final static String BUILD_ORDER_INFORMATION_INPUT_XPATH = "//textarea[@name='orderNote']";
    public final static String BUILD_ORDER_FORM_WRAPPER_XPATH = "//*[@class='add-new-order-form-wrapper']";
    public final static String BUILD_ORDER_HEADER_XPATH = "//div[@class='add-new-order-form-wrapper']/div/h4";
    public final static String DELETE_ITEM_BUTTON_XPATH = ".//button[@data-target='#delete-item-modal']";
    public final static String UPDATE_PRICE_AND_AVAILABILITY_BUTTON_XPATH = ".//button[@id='updatePricesBtn']";
    public final static String EXTENDED_PRICE_ON_MY_CART_XPATH = "//tr[contains(@class, 'price-item') and td/a[@data-product = '%s']]/td[contains(@class,'col extendedPrice')]";
    public final static String MAIN_ORDER_DATA_TOP_RIGHT_XPATH = "//div[@id='build-order']/div[@class='row']/div[contains(@class,'return-order-title')]";
    public final static String DISCARD_ORDER_BUTTON_XPATH = "//button[@class='btn primary-btn cancel-cart-btn']";
    public final static String QTY_VALUE_INPUT_XPATH = "//tr[contains(@class, 'price-item') and td/a[@data-product = '%s']]/td[contains(@class,'qty-input')]/input";
    public final static String ALL_CHECKBOXES_XPATH = ".//label[contains(@class,'myCheckbox select-all-desk-js')]";
    public final static String CLAIMBACK_MESSAGE_BELOW_AGREEMENT_NO_FIELD_ON_MY_CART_PAGE_XPATH = ".//p[@class='visible error-text-spa error-spa text-blue']";
    public final static String PRODUCT_LINK_ON_MY_CART_PAGE_XPATH = "//div[@id='priceTable_wrapper']//*[contains(@class,'catalog-name-input modal-toggle product-popup') and contains(text(),'%s')]";
    public final static String CATALOG_NO_ON_MY_CART_PAGE_XPATH = ".//table[@id='priceTable']//a[@class='catalog-name-input modal-toggle product-popup']";
    public final static String COUNTRY_OF_ORIGIN_DROP_DOWN_FIELD_ON_MY_CART_PAGE_XPATH = "//td[@class='data-table-value-col celaCust']//span[contains(@class,'rendered')]";
    public final static String COUNTRY_OF_ORIGIN_SINGLE_SOURCE_VALUE_ON_MY_CART_PAGE_XPATH = "//td[@class='data-table-value-col celaCust']";
    public final static String LIST_OF_PRODUCTS_XPATH = "//table[@id='priceTable']/tbody/tr";
    public final static String N_ITEMS_LABEL_XPATH = MAIN_ORDER_DATA_TOP_RIGHT_XPATH + "//p";
    public final static String NEW_ITEM_POP_UP_PRODUCT_FIRST_FIELD_XPATH = "//ul[@id='addProductList']//input[@name='rows[0].productNo']";
    public final static String CONFIRM_ADD_ITEM_ACTION_BUTTON_XPATH = "//button[@class='btn primary-btn add-checkout-product']";
    public final static String SAVE_TO_CART_POP_UP_TITLE_XPATH = "//div[@id='cart-save-list-modal']//h4";
    public final static String SAVE_TO_CART_POP_UP_CART_NAME_INPUT_XPATH = "//input[@class='form-control new-list-input']";
    public final static String SAVE_TO_CART_POP_UP_CREATE_NEW_LIST_BUTTON_XPATH = "//button[@class='btn primary-btn save-list-btn']";
    public final static String FIRST_PRODUCT_CATALOG_NO_XPATH = "//tr[@id='price-item-tr-1']/td[2]/a";
}