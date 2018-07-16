package com.template.storefront.page_elements;

public class OrderReviewPageElements {
	public static final String XPATH_CONFIRAMTION_CHECKBOX = "//form[@id='placeOrderForm1']//label";
	public static final String XPATH_PLACE_ORDER_BUTTON = "//button[@id='placeOrder']";
	public static final String XPATH_PAYMENT_INFORMATION_LABEL = "//div[@class='esab-ui-container']//"
			+ "div//b[text()='%s']//ancestor-or-self::*[@class='esab-ui-container']";
	public static final String XPATH_PURCHASE_ORDER_VALUE = String.format(XPATH_PAYMENT_INFORMATION_LABEL,
			"Purchase Order #") + "//div[contains(text(),'%s')]";
	public static final String XPATH_SHIPPING_INFORMATION_LABELS = "//div[@class='esab-ui-container']//"
			+ "div[@class='row row__bottom-margin']//div//b[text()='%s']//parent::div";
	public static final String XPATH_SHIPPING_INFO_BASIC = "//div[@class='esab-ui-container']//div//b[text()='%s']"
			+ "//parent::div//parent::div[@class='row row__bottom-margin']";
	public static final String XPATH_SHIP_TO_SOLD_TO_ADDRESS_VALUE = String.format(XPATH_SHIPPING_INFO_BASIC,
			"Ship To Address:");
	public static final String XPATH_ORDER_REVIEW_PAGE_HEADER = "//div[@class='form-section']//h2";
	public static final String XPATH_ACCOUNT_NUMBER = String.format(XPATH_SHIPPING_INFO_BASIC, "Account Number:");
	public static final String XPATH_REQUESTED_DELIVERY_DATE = String.format(XPATH_SHIPPING_INFO_BASIC,
			"Requested Delivery Date:");
	public static final String XPATH_ALLOW_PARTIAL_DELIVERY = String.format(XPATH_SHIPPING_INFO_BASIC,
			"Allow Partial Delivery:");
	public static final String XPATH_PACKAGING_INSTRUCTIONS = String.format(XPATH_SHIPPING_INFO_BASIC,
			"Packaging Instructions:");
	public static final String XPATH_SHIPPING_INSTRUCTIONS = String.format(XPATH_SHIPPING_INFO_BASIC,
			"Shipping Instructions:");
	public static final String XPATH_NAME_PRODUCT_LINK = "//table[contains (@class, 'esab-ui-table-products')]"
			+ "//a[text()='%s']";
	public static final String XPATH_PRODUCT_TABLE_ROW_BY_PRODUCT_NAME = XPATH_NAME_PRODUCT_LINK
			+ "//ancestor-or-self::tr";

	// Used number of column because all of column is the same except the
	// Product name
	// td[3] - Qty
	//In using need to use String format. 
	//XPATH mask://table[contains (@class, 'esab-ui-table-products')]//a[text()='%s']//ancestor-or-self::tr//td[3]
	//Example: String.format(XPATH_PRODUCT_QTY, "Some product name");
	public static final String XPATH_PRODUCT_QTY = XPATH_PRODUCT_TABLE_ROW_BY_PRODUCT_NAME + "//td[3]";
	// td[4] - Price
	//Example: String.format(XPATH_PRODUCT_PRICE, "Some product name")
	public static final String XPATH_PRODUCT_PRICE = XPATH_PRODUCT_TABLE_ROW_BY_PRODUCT_NAME + "//td[4]";
	// td[5] - Total Price
	public static final String XPATH_PRODUCT_TOTAL_PRICE = XPATH_PRODUCT_TABLE_ROW_BY_PRODUCT_NAME + "//td[5]";
	//dd[1] is Subtotal, dd[2] is Tax. 
	//There is no other way to locate element because there is 4 non unique elements on one level
	public static final String XPATH_SUBTOTAL = "//dt[text()='Subtotal']//parent::dl/dd[1]";
	public static final String XPATH_TAX = "//dt[text()='Subtotal']//parent::dl/dd[2]";
	public static final String XPATH_ORDER_TOTAL = "//div[contains(@class, 'product-box-total')]//span";

}
