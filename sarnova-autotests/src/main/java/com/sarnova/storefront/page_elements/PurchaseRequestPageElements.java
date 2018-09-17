package com.sarnova.storefront.page_elements;

public class PurchaseRequestPageElements {
        public static final String QUICK_ADD_PRODUCTS_CHECKBOX_ID = "toggleQuickAdd";
        public static final String PRODUCT_SEARCH_ID = "productsSearchTerm";
        public static final String QUANTITY_CONTAINER_XPATH = "//[contains(@id, 'quantity')]";
        public static final String ADD_PRODUCTS_BY_SKU_FIELD_IN_QUICK_ADD_PRODUCTS_XPATH = "//input[@class='js-sku-input-field form-control',placeholder='Enter SKU']";
        public static final String CLEAR_SEARCH_BUTTON_XPATH = "//[@id='productsClearSearchButton']/span";
        public static final String REJECT_ORDER_BUTTON_XPATH = "//button[contains(@class,'approverDecisionRejectButton')]";
        public static final String FORWARD_ORDER_BUTTON_XPATH = "//button[contains(@class,'forward-order-btn')]";
}
