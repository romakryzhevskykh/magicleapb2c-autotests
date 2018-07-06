package com.template.storefront.page_elements;

public class ShippingAddressPageElements {
	public static final String XPATH_SHIPPING_INSTRUCTIONS_INPUT = "//textarea[@name='shippingInstructions']";
	public static final String XPATH_NEXT_BUTTOON_SHIPPING_ADDR = "//button[@id='addressSubmit']";
	public static final String XPATH_REQUESTED_DELIVERY_DATE = "//input[@id='RequestedDeliveryDate']";
	public static final String XPATH_VALIDATION_ERROR = "//span[@id='shippingInstructions.errors']";
	public static final String XPATH_PARTIAL_DELIVERY_RADIO_BUTTON = "//div[@class='radiobox clearfix']"
			+ "//input[@value='%s']";
	public static final String XPATH_PACKAGING_INSTRUCTIONS_TEXTAREA = "//div//textarea[@id='PackagingInstructions']";
	public static final String XPATH_MODIFY_ADDRESS_BUTTON = "//button[@class='btn btn-default btn-block js-address-book']";
	public static final String XPATH_CLOSE_MODIFY_ADDR_POPUP = "//button[@id='cboxClose']";
	public static final String XPATH_LOCATE_ADRESS_IN_MODIFY = "//div[@class = 'addressEntry']"
			+ "//p[contains(.,'%s') and contains(.,'%s')]//parent::form";
	public static final String XPATH_USE_THIS_ADDR_FOR_SPECIFIC_ADDR = "//div[@class = 'addressEntry']"
			+ "//p[contains(.,'%s') and contains(.,'%s')]//parent::form//button[@type='submit']";
}
