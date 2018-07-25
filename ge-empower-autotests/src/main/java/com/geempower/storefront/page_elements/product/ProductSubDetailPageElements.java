package com.geempower.storefront.page_elements.product;

public class ProductSubDetailPageElements {
    public final static String SELECTED_PRODUCT_CHECKBOX_XPATH = "//table[@id='DataTables_Table_0']//tr[@role='row' and td/a[@data-code-view='%s']]//div[@class='checkbox']//ins[@class='iCheck-helper']";
    public final static String ADD_TO_CART_BUTTON_XPATH = "//button[@class='btn primary-btn add-product-to-cart-btn']";
    public final static String LINE_ITEMS_VALUE_XPATH = "//p[contains(@class,'cart-total-lines')]";
    public final static String ORDER_VALUE_XPATH = ".//p[contains(@class,'cart-total-price')]";
    public final static String CATALOG_NO_LINK_XPATH = "//table[@id='DataTables_Table_0']/tbody//td[@class ='table-visible-lg-block sorting_1']//a[@data-code-view = '%s']";
}