package com.geempower.storefront.page_elements.order;

public class OrderDetailsPageElements {
    public final static String GE_ORDER_NO_XPATH = "//a[@class='text-dark-grey']";
    public final static String TOTAL_NET_PRICE_VALUE_XPATH = "//span[@class='orderTotalPrice']";
    public final static String EXPAND_ORDER_DETAILS_ICON_XPATH = "//i[@class='fa fa-angle-down table-collpase display-inline-block collapsed'][1]";
    public final static String INVOICE_DOWNLOAD_HYPERLINK_XPATH = "//div[@id='description-1-0-0']//a[@class='check-invoice-href']";
    public final static String CHECKBOX_RELATES_TO_CATALOG_NO_XPATH = "//td[@class= 'create-summary-catalog']//a[@data-code-view='%s']/../../../td[@class='checkbox-col']//ins";
    public final static String CAT_NO_QUANTITY_XPATH = "//a[@data-code-view = '%s']/../../../td[@class='create-summary-qty']/span";
    public final static String ALL_CATALOG_NO_XPATH = "//table[@id='order-description-table']//a[@class='catalog-name-input modal-toggle product-popup']";
    public final static String REORDER_BUTTON_XPATH = "//a[@class='re-order-btn']";
}