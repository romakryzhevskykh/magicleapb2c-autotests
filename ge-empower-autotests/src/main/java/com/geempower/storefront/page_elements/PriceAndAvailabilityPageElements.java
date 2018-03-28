package com.geempower.storefront.page_elements;

public class PriceAndAvailabilityPageElements {
    public final static String ALL_CHECKBOXES_XPATH = ".//label[@class='myCheckbox select-all-desk-js']";
    public final static String ADD_TO_CARD_BUTTON_XPATH = ".//button[@class='btn primary-btn add-to-cart-btn']";
    public final static String DESCRIPTION_FIELD_XPATH = ".//td[@class='product-col']";
    public final static String LIST_PRICE_FIELD_XPATH = ".//td[@class='data-table-value-col listPrice']";
    public final static String FINAL_NET_PRICE_FIELD_XPATH = ".//td[@class='data-table-final-value-col primaryNetPrice']";
    public final static String AVAILABILITY_FIELD_XPATH = "//table[contains(@class, 'price-availability-table')]//tr[contains(@class, 'price-item') and td/a[@data-product = '%s']]/td[contains(@class,'productWrHouse')]";
    public final static String QUANTITY_INPUT_XPATH = "//table[contains(@class, 'price-availability-table')]//tr[contains(@class, 'price-item') and td/a[@data-product = '%s']]/td[contains(@class,'qty-input')]/input";
    public final static String EXTENDED_PRICE_XPATH = "//table[contains(@class, 'price-availability-table')]//tr[contains(@class, 'price-item') and td/a[@data-product = '%s']]/td[contains(@class,'col extendedPrice')]";
    public final static String UPDATE_PRICE_AND_AVAILABILITY_BUTTON_XPATH = "//button[@id='upd_pr_and_av_btn']";
}
