package com.geempower.storefront.page_elements.product;

public class PDPPageElements {
    public final static String CATALOG_NO_HEADER_TITLE_XPATH = "//div[@class = 'name-text clearfix']/h4//span[2]";
    public final static String PRODUCT_DETAILS_BLOCK_HEADER_XPATH = "//div[@class = 'panel-heading']/h3";
    public final static String AVAILABILITY_DETAILS_TITLE_XPATH = "//div[@id='price-availability']/div[1]//h3";
    public final static String DISTRIBUTION_WAREHOUSE_INFO_TABLE_HEADER_XPATH = "//table[@class='table info-table']/thead/tr/th[1]";
    public final static String PRODUCT_AVAILABILITY_INFO_TABLE_HEADER_XPATH = "//table[@class='table info-table']/thead/tr/th[2]";
    public final static String ADD_TO_CART_BUTTON_ON_PDP_PAGE_XPATH = "//button[@data-target='#cart-modal']";
    public final static String IMAGE_IN_PRODUCT_DETAILS_BLOCK_XPATH = "//div[@class = 'gallery-bigbox relative']//div";
    public final static String ALL_PRODUCT_DETAILS_TABLE_ITEMS_XPATH = "//div[@id='product-details']//td[1]/span";
    public final static String ALL_PRICING_DETAILS_TABLE_ITEMS_XPATH = "//div[@id='price-availability']//tr/td[1]";
    public final static String ALL_GENERAL_CHARACTERISTICS_TABLE_ITEMS_XPATH = "//div[@class='product-detail-table row']//div[contains(@class,'featureName')]/span";
    public final static String ALL_PUBLICATIONS_HEADERS_XPATH = "//table[contains(@class,'product-detail-publication-table')]//th[contains(@class,'table-visible-lg-block')]";

    public final static String PRODUCT_SUMMARY_HEADER_TITLE_XPATH = "//div[@id='product-details']/h3";
    public final static String PRICING_DETAILS_HEADER_TITLE_XPATH = "//div[@id='price-availability']/div[4]//h3";
    public final static String GENERAL_CHARACTERISTICS_HEADER_TITLE_XPATH = "//div[@id ='specifications']/h3";
    public final static String LIST_OF_PUBLICATIONS_HEADER_TITLE_XPATH = "//div[@id ='publications']/h4";

    private final static String ALL_TABS_BLOCK_XPATH = "//div[@class ='my-pending-accounts-wrapper']";

    public final static String ACTIVE_PRODUCT_DETAILS_TAB_XPATH = "//li[@tab-id='0']";
    public final static String ACTIVE_PA_TAB_XPATH = ALL_TABS_BLOCK_XPATH + "//li[@tab-id='1']";
    public final static String ACTIVE_SPECIFICATION_TAB_XPATH = ALL_TABS_BLOCK_XPATH + "//li[@tab-id='2']";
    public final static String ACTIVE_PUBLICATIONS_TAB_XPATH = ALL_TABS_BLOCK_XPATH + "//li[@tab-id='3']";

    public final static String PRICE_AND_AVAILABILITY_TAB_XPATH = "//a[@href='#price-availability']";
    public final static String SPECIFICATIONS_TAB_XPATH = "//a[@href='#specifications']";
    public final static String PUBLICATIONS_TAB_XPATH = "//a[@href='#publications']";

    public final static String LINK_IN_THE_PUBLICATIONS_TABLE_XPATH = "//table[contains(@class,'product-detail-publication-table')]//tbody/tr[1]/td/span/a";
}