package com.template.storefront.page_elements;

public class ShoppingCartPageElements {
	public static final String H2_HEADERS_XPATH = "//h2[normalize-space(text())]";
	public static final String H2_SHOPPING_CART_TITLE = "//div[@class='col-xs-12 col-sm-5']//h2[normalize-space(text())]";
	public static final String H2_SHOPPING_CART_TITLE2 = "//div[@class='col-sm-12']//h2[normalize-space(text())]";
	public static final String HEADER2_SUBTITLE = "//div[@class='col-sm-12']//p[normalize-space(text())]";
	public static final String ELEMENTS_IN_ADD_PRODUCT_BOX = "//div[@class='box esab-ui-cart-box']//div[normalize-space()]";
	public static final String SHIP_TO_DROPDOWN = "//select[@id='addressId']";
	public static final String SHIP_TO_VALUE = SHIP_TO_DROPDOWN + "//option[text()='%s']";

}
