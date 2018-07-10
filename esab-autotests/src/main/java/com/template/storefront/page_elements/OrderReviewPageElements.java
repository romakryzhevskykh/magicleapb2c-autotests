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

}
