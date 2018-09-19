package com.geempower.storefront.page_elements.order;

public class OrderDetailsPageElements {
    public final static String GE_ORDER_NO_XPATH = "//span[@class='text-dark-grey']";
    public final static String TOTAL_NET_PRICE_VALUE_XPATH = "//span[@class='orderTotalPrice']";
    public final static String EXPAND_ORDER_DETAILS_ICON_XPATH = "//i[@class='fa fa-angle-down table-collpase display-inline-block collapsed'][1]";
    public final static String INVOICE_DOWNLOAD_HYPERLINK_XPATH = "//div[@id='description-1-0-0']//a[@class='check-invoice-href']";
    public final static String CHECKBOX_RELATES_TO_CATALOG_NO_XPATH = "//td[@class= 'create-summary-catalog']//a[@data-code-view='%s']/../../../td[@class='checkbox-col']//ins";
    public final static String QUANTITY_OF_APPROPRIATE_PRODUCT_XPATH = "//a[@data-code-view = '%s']/../../../td[@class='create-summary-qty']/span";
    public final static String ALL_CATALOG_NO_XPATH = "//table[@id='order-description-table']//a[@class='catalog-name-input modal-toggle product-popup']";
    public final static String ALL_CATALOG_NO_BY_ROW_XPATH = "//tr[contains(@class,'show-item')]['%s']//a[@data-code]";
    public final static String ALL_DESCRIPTION_BY_ROW_XPATH = "//tr[contains(@class,'show-item')]['%s']//td[@class = 'create-summary-invoice']/span";
    public final static String ALL_EXTENDED_PRICE_BY_ROW_XPATH = "//tr[contains(@class, 'order-line show-item')]['%s']//td[@class = 'create-summary-ext-total text-center']/input";
    public final static String REORDER_BUTTON_XPATH = "//a[@class='re-order-btn']";
    public final static String REORDER_BUTTON_TEXT_FIRST_PART_XPATH = "//a[contains(@class,'re-order-btn')]/../..//span[@class='hidden-xs']";
    public final static String REORDER_BUTTON_TEXT_SECOND_PART_XPATH = "//a[contains(@class,'re-order-btn')]/../..//span[@class='text-red hidden-xs']";
    public final static String STATUS_BOXES_XPATH = "//div[@class='order-item']";
    public final static String ALL_STATUS_BOX_XPATH = "//div[@class='order-item orders-item-all']/a";
    public final static String SELECTED_ALL_STATUS_BOX_XPATH = "//div[@class='order-item orders-item-all']/a[@class='selected']";
    public final static String TABLE_WITH_PRODUCTS_XPATH = "//table[@id='order-description-table']//tr[contains(@class,'show-item')]";

    public final static String BOTTOM_ROW_IN_DETAILS_QUOTES_BLOCK_XPATH = "//ul[@class ='quote-bottom-section row m-0']";
    public final static String EXPAND_QUOTES_BLOCK_ARROW_BUTTON_XPATH = "//i[@class='fa fa-angle-down']";
    public final static String HIDE_QUOTES_BLOCK_ARROW_BUTTON_XPATH = "//i[@class='fa fa-angle-up']";

    public final static String EXPAND_CLOSE_STATUS_BOXES_ARROW_BUTTON_XPATH = "//i[@class = 'fa fa-chevron-down']";

    public final static String LABEL_VALUES_IN_QUOTES_BLOCK_XPATH = "//label[contains(text(),'%s')]/following-sibling::p";
    public final static String LABELS_IN_QUOTES_BLOCK_XPATH = "//label[contains(text(),'%s')]";
    public final static String SHIP_TO_LABEL_VALUE_XPATH = "//div[@class='quote-details clearfix']//label[contains(text(),'%s')]/following-sibling::p";

    public final static String EXPANDED_STATUS_BOXES_LINE_XPATH = "//div[@class='details-graphical clearfix active']";
    public final static String STATUS_BOX_TITLES_XPATH = "//div[@class='order-item']//span[@class = 'item-name']";



}