package com.geempower.storefront.page_block_elements;

public class InvoiceDetailsPopUpElements {
    public final static String INVOICE_DETAILS_POP_UP_XPATH = "//div[@id='invoice-customer-service-modal']//div[@class='modal-content']";
    public final static String INVOICE_DETAILS_POP_UP_CLOSE_BUTTON_XPATH = INVOICE_DETAILS_POP_UP_XPATH + "//button";
    public final static String INVOICE_DETAILS_HEADER_XPATH = INVOICE_DETAILS_POP_UP_XPATH + "//h4";
    public final static String INVOICE_DETAILS_BODY_TEXT_XPATH = INVOICE_DETAILS_POP_UP_XPATH + "//li";
    public final static String TRACKING_INFO_DATA_XPATH = "//td/a[@class='order-overlay']";
    public final static String BOL_DATA_XPATH = "//div[contains(@id,'description')]/div/ul/li/a";
    public final static String EXPAND_FIRST_LINE_ORDER_DETAILS_ICON_XPATH = "//i[@class='fa fa-angle-down table-collpase display-inline-block collapsed']";
    public final static String CLOSE_BOL_POP_UP_ICON_XPATH = "//div[@class='modal fade general-multiple-bol-modal in']//button[text()='Close']";
    public final static String BOL_AND_TRACKING_NUMBERS_POP_UP_TITLE_XPATH = "//div[@class='modal fade general-multiple-bol-modal in']//h4";
    public final static String BILLS_OF_LANDING_IN_BOL_AND_TRACKING_NUMBERS_POP_UP_XPATH = "//table[@id='DataTables_Table_0']/tbody/tr";
    public final static String LIST_OF_ALL_CHECKBOXES_CATALOG_NO_XPATH = "//a[contains(@class,'product-popup')]/../../td[@class = 'checkbox-col']//input";
    public final static String NECESSARY_QUANTITY_OF_CAT_NO_VALUE_XPATH = "//td[@class='create-summary-catalog']/a[@data-code-view = '%s']/../../td[@class ='create-summary-qty']/span";

}