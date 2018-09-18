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
    public final static String STATUS_BOXES_XPATH = "//div[@class='order-item']";
    public final static String ALL_STATUS_BOX_XPATH = "//div[@class='order-item orders-item-all']/a";
    public final static String SELECTED_ALL_STATUS_BOX_XPATH = "//div[@class='order-item orders-item-all']/a[@class='selected']";
    public final static String TABLE_WITH_PRODUCTS_XPATH = "//table[@id='order-description-table']//tr[contains(@class,'show-item')]";
    public final static String TRACKING_INFO_HYPERLINK_XPATH = "//td[@class='create-summary-restock-amount ']/a";
    public final static String LIST_OF_TRACKING_NUMBERS_XPATH = "//table[@id='DataTables_Table_0']//tr/td[@class='po-track-link']/a";
    //TRACKING DETAILS SLIDER ELEMENTS
    public final static String TRACKING_DETAILS_SLIDER_XPATH = "//tbody//div[@class='filter-setting-overlay filter-canvas order-filter order-tracking-info-panel-multiple open']";
    public final static String TRACKING_DETAILS_SLIDER_HEADER_XPATH = TRACKING_DETAILS_SLIDER_XPATH + "/div[@class='filter-header']/h4";
    public final static String TRACKING_DETAILS_ERROR_MESSAGE_XPATH = TRACKING_DETAILS_SLIDER_XPATH + "//span[@class='warning-text']";
    public final static String ERROR_EXCLAMATION_MARK_ICON_XPATH = TRACKING_DETAILS_SLIDER_XPATH + "//i[@class='fa fa-exclamation fa-stack-1x fa-inverse']";
    public final static String LINE_NO_AND_CATALOG_NO_DETAILS_XPATH = TRACKING_DETAILS_SLIDER_XPATH + "//div[@class='shippment-details-body active']/h5";
    public final static String SHIPMENT_INFO_SENT_PROGRESS_BAR_XPATH = TRACKING_DETAILS_SLIDER_XPATH + "//div[@class='tracking-bar']//div[contains(@class, 'Dispatched')]";
    public final static String IN_TRANSIT_PROGRESS_BAR_XPATH = TRACKING_DETAILS_SLIDER_XPATH + "//div[@class='tracking-bar']//div[contains(@class, 'InTransit')]";
    public final static String DELIVERED_PROGRESS_BAR_XPATH = TRACKING_DETAILS_SLIDER_XPATH + "//div[@class='tracking-bar']//div[contains(@class, 'Delivered')]";
    public final static String SHIPMENT_INFO_SENT_STATUS_NAME_XPATH = SHIPMENT_INFO_SENT_PROGRESS_BAR_XPATH + "/span";
    public final static String IN_TRANSIT_STATUS_NAME_XPATH = IN_TRANSIT_PROGRESS_BAR_XPATH + "/span";
    public final static String DELIVERED_STATUS_NAME_XPATH = DELIVERED_PROGRESS_BAR_XPATH + "/span";
    public final static String NEXT_TRACKING_INFO_BUTTON_XPATH = "//a[@class='text-blue track-next ']";
    public final static String PREVIOUS_TRACKING_INFO_BUTTON_XPATH = "//a[@class='text-blue track-prev ']";


}