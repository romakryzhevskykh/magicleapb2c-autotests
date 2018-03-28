package com.geempower.storefront.page_elements;

public class PriceAndAvailabilityPageElements {
    public final static String ALL_CHECKBOXES_XPATH = ".//label[@class='myCheckbox select-all-desk-js']";
    public final static String ADD_TO_CARD_BUTTON_XPATH = ".//button[@class='btn primary-btn add-to-cart-btn']";
    public final static String QUANTITY_INPUT_XPATH = "//table[contains(@class, 'price-availability-table')]//tr[contains(@class, 'price-item') and td/a[@data-product = '%s']]/td[contains(@class,'qty-input')]/input";
    public final static String EXTENDED_PRICE_XPATH = "//table[contains(@class, 'price-availability-table')]//tr[contains(@class, 'price-item') and td/a[@data-product = 'THQL1120']]/td[contains(@class,'col extendedPrice')]";
    public final static String UPDATE_PRICE_AND_AVAILABILITY_BUTTON_XPATH = "//button[@id='upd_pr_and_av_btn']";

}
