package com.template.storefront.page_elements;

public class SavedCartsPageElements {
	public static final String XPATH_SAVED_CART_NAME = "//td//a[contains(text(), '%s')]";
	public static final String XPATH_SAVED_CARTS_LIST = "//table//tr[@class='responsive-table-item']";
	public static final String XPATH_PAGINATION_BAR_RESULTS = "//div[@class = 'pagination-bar-results']";
	public static final String XPATH_EMPTY_SAVED_CARTS_LIST_VALUE = "//div[contains(@class, 'content-empty')]"
			+ "//div[contains(@class, 'esab-ui-cart-box')]";

}
