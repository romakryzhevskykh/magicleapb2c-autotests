package com.geempower.storefront.page_elements.product;

public class PDPPageElements {
    public final static String CATALOG_NO_HEADER_TITLE_XPATH = "//div[@class = 'name-text clearfix']/h4//span[2]";
    public final static String PRODUCT_DETAILS_BLOCK_HEADER_XPATH = "//div[@class = 'panel-heading']/h3";
    public final static String PRODUCT_SUMMARY_TITLE_XPATH = "//div[@id='product-details']/h3";
    public final static String AVAILABILITY_DETAILS_TITLE_XPATH = "//div[@id='price-availability']/div[1]//h3";
    public final static String PRICING_DETAILS_TITLE_XPATH = "//div[@id='price-availability']/div[4]//h3";
    public final static String DISTRIBUTION_WAREHOUSE_INFO_TABLE_HEADER_XPATH = "//table[@class='table info-table']/thead/tr/th[1]";
    public final static String PRODUCT_AVAILABILITY_INFO_TABLE_HEADER_XPATH = "//table[@class='table info-table']/thead/tr/th[2]";
    public final static String ADD_TO_CART_BUTTON_ON_PDP_PAGE_XPATH = "//button[@data-target='#cart-modal']";
    public final static String IMAGE_IN_PRODUCT_DETAILS_BLOCK_XPATH = "//div[@class = 'gallery-bigbox relative']//div";
    public final static String ACTIVE_PRODUCT_DETAILS_TAB_XPATH = "//li[contains(@class,'active')]//a[@href ='#product-details']";
    public final static String ACTIVE_PA_TAB_XPATH = "//li[contains(@class,'active')]//a[@href ='#price-availability']";
    public final static String ALL_PRODUCT_DETAILS_TABLE_ITEMS_XPATH = "//div[@id='product-details']//td[1]/span";
    public final static String ALL_PRICING_DETAILS_TABLE_ITEMS_XPATH = "//div[@id='price-availability']//tr/td[1]";
    public final static String PRICE_AND_AVAILABILITY_TAB_XPATH = "//a[@href='#price-availability']";
}