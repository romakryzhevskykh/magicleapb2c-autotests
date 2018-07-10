package com.template.storefront.page_elements;

public class ShoppingCartPageElements {
	public static final String H2_HEADERS_XPATH = "//h2[normalize-space(text())]";
	public static final String H2_SHOPPING_CART_TITLE = "//div[@class='col-xs-12 col-sm-5']//h2[normalize-space(text())]";
	public static final String H2_SHOPPING_CART_TITLE2 = "//div[@class='col-sm-12']//h2[normalize-space(text())]";
	public static final String HEADER2_SUBTITLE = "//div[@class='col-sm-12']//p[normalize-space(text())]";
	public static final String ELEMENTS_IN_ADD_PRODUCT_BOX = "//div[@class='box esab-ui-cart-box']//div[normalize-space()]";
	public static final String SHIP_TO_DROPDOWN = "//select[@id='addressId']";
	public static final String SHIP_TO_VALUE = SHIP_TO_DROPDOWN + "//option[text()='%s']";
	public static final String SKU_INPUT_XPATH = "//input[@type='search']";
	public static final String ADD_MORE_PRODUCTS_XPATH = "//div[@class='add-more-products-btn']//a";
	public static final String ADD_TO_CART_BUTTON_XPATH = "//button[@data-esab-ui='add-to-cart']";
	public static final String QTY_FIELDS_XPATH = "//input[@class='js-quick-order-qty']";
	// Product name value should be taken from ProductModel.
	public static final String PRODUCT_NAME_FOR_VERIFICATION_XPATH = "//li[@class='esab-ui-cart__product-item']"
			+ "//span[@class='item__name' and text()='%s']";
	public static final String PRODUCT_NAME_ELEMENT_XPATH = "//li[@class='esab-ui-cart__product-item']"
			+ "//div[@class='item__code' and text()='%s']//parent::div/parent::li//span[@class='item__name']";
	// SCU value should be taken from ProductModel.
	public static final String PRODUCT_SCU_XPATH = "//li[@class='esab-ui-cart__product-item']"
			+ "//div[@class='item__code' and text()='%s']";
	public static final String PRODUCT_INSTOCK_XPATH = "//li[@class='esab-ui-cart__product-item']"
			+ "//div[@class='item__stock']//span[@class='stock' and text()='%s']";
	public static final String PRODUCT_PRICE_XPATH = "//li[@class='esab-ui-cart__product-item']"
			+ "//div[@class='item__code' and text()='%s']//parent::div/parent::li//div[@class='item__price']";
	public static final String PRODUCT_QTY_XPATH = "//li[@class='esab-ui-cart__product-item']"
			+ "//div[@class='item__code' and text()='%s']//parent::div/parent::li//input[@name='quantity']";
	public static final String PRODUCT_TOTAL_PRICE = "//li[@class='esab-ui-cart__product-item']"
			+ "//div[@class='item__code' and text()='%s']//parent::div/parent::li"
			+ "//div[@class='item__total js-item-total hidden-xs hidden-sm']";
	public static final String PRODUCT_DETAILS_BUTTON_XPATH = "//li[@class='esab-ui-cart__product-item']"
			+ "//div[@class='item__code' and text()='%s']//parent::div/parent::li"
			+ "//span[@class='glyphicon glyphicon-option-vertical']";
	public static final String PRODUCT_REMOVE_BUTTON_XPATH = "//li[@class='js-execute-entry-action-button'"
			+ " and @data-entry-product-code='%s' and @data-entry-action='REMOVE']";
	public static final String SUBTOTAL_XPATH = "//div[@class='js-cart-totals row']"
			+ "//div[@class='col-xs-6 cart-totals-right text-right']";
	public static final String SAVE_CART_BUTTON_XPATH = "//button[@class='btn btn-default save__cart--link cart__head--link js-save-cart-link']";
	public static final String CHECKOUT_BUTTON_XPATH = "//button[@class='btn btn-primary btn--continue-checkout js-continue-checkout-button']";

}
